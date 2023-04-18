package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.auth.AuthUtils;
import com.wcappel.ffbackend.auth.GTokenValidator;
import com.wcappel.ffbackend.auth.ReturnedTokenInfo;
import com.wcappel.ffbackend.misc.MatchupGenerator;
import com.wcappel.ffbackend.dto.StandingDTO;
import com.wcappel.ffbackend.misc.TeamId;
import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Matchup;
import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.repository.LeagueRepository;
import com.wcappel.ffbackend.repository.MatchupRepository;
import com.wcappel.ffbackend.repository.TeamRepository;
import com.wcappel.ffbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController @RequestMapping("/ffapi/v1/leagues") public class LeagueController {
    @Autowired private LeagueRepository leagueRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private MatchupRepository matchupRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private GTokenValidator gTokenValidator;

    @GetMapping("/getallleagues") List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @PostMapping("/addleague") League addLeague(@RequestBody League l) {
        return leagueRepository.save(l);
    }

    @GetMapping("/getnumofteamsinleague/league={league}") byte getNumOfTeamsInLeague(@PathVariable int league) {
        return leagueRepository.getNumOfTeamsInLeague(league);
    }

    @GetMapping("/getleaguestandings/league={league}")
    List<StandingDTO> getLeagueStandings(@PathVariable int league, @RequestHeader("Authorization") String authToken) {
        ReturnedTokenInfo tokenInfo = gTokenValidator.verifyGToken(authToken);
        // Check if user has team in league for now, optimize later
        boolean userInLeague = AuthUtils.checkUserHasAccessToLeague(tokenInfo, league, leagueRepository, userRepository);
        if (tokenInfo.isValid() && userInLeague) {
            return leagueRepository.getLeagueStandings(league);
        }
        return null;
    }

    @PostMapping("/generatematchups/league={league}") List<Matchup> generateMatchups(@PathVariable int league) {
        List<Team> leagueTeams = teamRepository.getTeamsByLeague(league);
        System.out.println(leagueTeams);
        List<Matchup> matchups = MatchupGenerator.genMatchups(leagueTeams);
        List<Matchup> res = new ArrayList<>();
        for (Matchup m : matchups) {
            res.add(matchupRepository.save(m));
        }
        return res;
    }

    @PostMapping("/endweekforleague/league={league}") void endWeekForLeague(@PathVariable int league) {
        // Update all matchup data and declare match outcomes
        List<Matchup> currentMatchups = matchupRepository.getCurrentLeagueMatchupsInternal(league);
        League leagueEntity = leagueRepository.findByLeagueId(league).isPresent() ?
                leagueRepository.findByLeagueId(league).get() : null;

        if (leagueEntity == null) return;

        for (Matchup matchup : currentMatchups) {
            float homeTeamPointsTotal = teamRepository.getTeamFantasyPoints(league,
                    matchup.getHomeTeam().getTeamId().getTeamName());
            float awayTeamPointsTotal = teamRepository.getTeamFantasyPoints(league,
                    matchup.getAwayTeam().getTeamId().getTeamName());

            // Update and save matchup data
            matchup.setHomeScore(homeTeamPointsTotal);
            matchup.setAwayScore(awayTeamPointsTotal);
            matchupRepository.save(matchup);

            Team homeTeam = teamRepository.findById(new TeamId(matchup.getHomeTeam().getTeamId().getTeamName(), leagueEntity)).isPresent() ?
                    teamRepository.findById(new TeamId(matchup.getHomeTeam().getTeamId().getTeamName(), leagueEntity)).get() : null;
            Team awayTeam = teamRepository.findById(new TeamId(matchup.getAwayTeam().getTeamId().getTeamName(), leagueEntity)).isPresent() ?
                    teamRepository.findById(new TeamId(matchup.getAwayTeam().getTeamId().getTeamName(), leagueEntity)).get() : null;

            // Update and save team records
            if (homeTeam != null && awayTeam != null) {
                if (homeTeamPointsTotal > awayTeamPointsTotal) {
                    // Home wins
                    homeTeam.setWins((byte) (homeTeam.getWins() + 1));
                    awayTeam.setLosses((byte) (awayTeam.getLosses() + 1));
                } else if (homeTeamPointsTotal < awayTeamPointsTotal) {
                    // Away wins
                    awayTeam.setWins((byte) (awayTeam.getWins() + 1));
                    homeTeam.setLosses((byte) (homeTeam.getLosses() + 1));
                } else {
                    // Tie
                    homeTeam.setTies((byte) (homeTeam.getTies() + 1));
                    awayTeam.setTies((byte) (awayTeam.getTies() + 1));
                }

                teamRepository.save(homeTeam);
                teamRepository.save(awayTeam);
            } else {
                System.out.println("One of teams in the matchup has returned as null");
            }
        }

        // Increment league's Current_week if not end of season
        leagueEntity.setCurrentWeek((byte) (leagueEntity.getCurrentWeek() + 1));

        // NOTE: Consider adding a "Season_length" field to Leagues table
        // to hold number of weeks in a league's season
        // This field can then be used for MatchupGenerator (input through LeagueController)
        // and above in this document, to check against Current_week
    }
}
