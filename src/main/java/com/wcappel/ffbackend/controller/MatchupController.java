package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.misc.TeamId;
import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Matchup;
import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.repository.MatchupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/matchups") public class MatchupController {
    @Autowired private MatchupRepository matchupRepository;

    @GetMapping("/getallmatchups") List<Matchup> getAllMatchups() {
        return matchupRepository.findAll();
    }

    @PostMapping("/addmatchup") public Matchup addMatchup(@RequestBody Matchup m) {
        System.out.println(m);
        return matchupRepository.save(m);
    }

    @GetMapping("/getcurrentleaguematchups/league={league}")
    public List<Matchup> getLeagueMatchupsByWeek(@PathVariable int league) {
        return matchupRepository.getCurrentLeagueMatchupsInfo(league);
    }

    @GetMapping("/getallteammatchups/league={league},team={team}")
    public List<Matchup> getAllTeamMatchupsInfo(@PathVariable int league, @PathVariable String team) {
        return matchupRepository.getAllTeamMatchupsInfo(league, team);
    }

    @GetMapping("/getcurrentmatchupsbyuser/user={user}")
    public List<Matchup> getCurrentMatchupsByUser(@PathVariable String user) {
        return matchupRepository.getCurrentMatchupsByUser(user);
    }
}
