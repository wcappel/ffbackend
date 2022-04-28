package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.misc.LineupDTO;
import com.wcappel.ffbackend.model.Roster;
import com.wcappel.ffbackend.repository.RosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/rosters")public class RosterController {
    @Autowired private RosterRepository rosterRepository;

    @GetMapping("/getallrosters") List<Roster> getAllRosters() {
        return rosterRepository.findAll();
    }

    @PostMapping("/addroster") public Roster addRoster(@RequestBody Roster r) {
        System.out.println(r);
        return rosterRepository.save(r);
    }

    @GetMapping("/getteamroster/league={league},team={team}") public List<LineupDTO>
    getTeamRoster(@PathVariable int league, @PathVariable String team) {
        return rosterRepository.getTeamRoster(league, team);
    }

    @GetMapping("/getnumofplayersonbench/league={league},team={team}") public int
    getNumOfPlayersOnBench(@PathVariable int league, @PathVariable String team) {
        return rosterRepository.getNumOfPlayersOnBench(league, team);
    }
}