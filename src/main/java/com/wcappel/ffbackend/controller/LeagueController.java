package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.misc.MatchupGenerator;
import com.wcappel.ffbackend.misc.StandingDTO;
import com.wcappel.ffbackend.misc.TeamId;
import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Matchup;
import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.repository.LeagueRepository;
import com.wcappel.ffbackend.repository.MatchupRepository;
import com.wcappel.ffbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController @RequestMapping("/ffapi/v1/leagues") public class LeagueController {
    @Autowired private LeagueRepository leagueRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private MatchupRepository matchupRepository;

    @GetMapping("/getallleagues") List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @PostMapping("/addleague") League addLeague(@RequestBody League l) {
        return leagueRepository.save(l);
    }

    @GetMapping("/getnumofteamsinleague/league={league}") byte getNumOfTeamsInLeague(@PathVariable int league) {
        return leagueRepository.getNumOfTeamsInLeague(league);
    }

    @GetMapping("/getleaguestandings/league={league}") List<StandingDTO> getLeagueStandings(@PathVariable int league) {
        return leagueRepository.getLeagueStandings(league);
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
            float homeTeamPointsTotal = teamRepository.getTeamFantasyPoints(league, matchup.getHomeTeam());
            float awayTeamPointsTotal = teamRepository.getTeamFantasyPoints(league, matchup.getAwayTeam());

            // Update and save matchup data
            matchup.setHomeScore(homeTeamPointsTotal);
            matchup.setAwayScore(awayTeamPointsTotal);
            matchupRepository.save(matchup);

            Team homeTeam = teamRepository.findById(new TeamId(matchup.getHomeTeam(), leagueEntity)).isPresent() ?
                    teamRepository.findById(new TeamId(matchup.getHomeTeam(), leagueEntity)).get() : null;
            Team awayTeam = teamRepository.findById(new TeamId(matchup.getAwayTeam(), leagueEntity)).isPresent() ?
                    teamRepository.findById(new TeamId(matchup.getAwayTeam(), leagueEntity)).get() : null;

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
    }
}
