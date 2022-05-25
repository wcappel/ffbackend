package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.misc.MatchupGenerator;
import com.wcappel.ffbackend.misc.StandingDTO;
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
}
