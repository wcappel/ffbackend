package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.dto.PlayerDTO;
import com.wcappel.ffbackend.misc.LineupInfo;
import com.wcappel.ffbackend.misc.PlayerId;
import com.wcappel.ffbackend.model.Player;
import com.wcappel.ffbackend.model.Roster;
import com.wcappel.ffbackend.repository.RosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController @RequestMapping("/ffapi/v1/rosters")public class RosterController {
    @Autowired private RosterRepository rosterRepository;

    @GetMapping("/getallrosters") List<Roster> getAllRosters() {
        return rosterRepository.findAll();
    }

    // This should eventually not be public, or even an endpoint
    // Make separate endpoint/repo methods for trades, etc.
    @PostMapping("/addroster") public Roster addRoster(@RequestBody Roster r) {
        System.out.println(r);
        return rosterRepository.save(r);
    }

    @PutMapping("/updaterosterposition") public void
    updateRosterPosition(@RequestBody Roster r) {

        Optional<Roster> existingRosterOptional = rosterRepository.findById(r.getRosterId());
        if (existingRosterOptional.isPresent()) {
            // Roster object w/ ID exists, update position
            // Check to see if roster position is unoccupied (except for bench, if bench is not full)
            List<Roster> sameRosterPositionList = rosterRepository
                    .findByRosteredAndRosterPositionAndRosterId_League(r.getRostered(), r.getRosterPosition(),
                            r.getRosterId().getLeague());
            System.out.println(sameRosterPositionList);

            if (sameRosterPositionList.isEmpty() || r.getRosterPosition().equals("BNCH")) {
                Roster existingRoster = existingRosterOptional.get();
                existingRoster.setRosterPosition(r.getRosterPosition());
                rosterRepository.save(existingRoster);
            } else {
                System.out.println("Roster position already taken!");
            }
        }
    }

    @GetMapping("/getteamroster/league={league},team={team}") public List<LineupInfo>
    getTeamRoster(@PathVariable int league, @PathVariable String team) {
        return rosterRepository.getTeamRoster(league, team);
    }

    @GetMapping("/getleagueroster/league={league}") public List<Roster>
    getLeagueRoster(@PathVariable int league) {
        return rosterRepository.getLeagueRoster(league);
    }

    @GetMapping("/getunrosteredplayers/league={league}") public List<Player>
    getUnrosteredPlayers(@PathVariable int league) {
        List<PlayerDTO> unrosteredPlayersDTOs = rosterRepository.getUnrosteredPlayers(league);
        return unrosteredPlayersDTOs.stream()
                .map(dto -> new Player(new PlayerId(dto.getName(), dto.getPosition())))
                .collect(Collectors.toList());
    }

    @GetMapping("/getnumofplayersonbench/league={league},team={team}") public int
    getNumOfPlayersOnBench(@PathVariable int league, @PathVariable String team) {
        return rosterRepository.getNumOfPlayersOnBench(league, team);
    }
}