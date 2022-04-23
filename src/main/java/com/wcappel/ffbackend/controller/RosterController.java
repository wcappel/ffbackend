package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.Roster;
import com.wcappel.ffbackend.model.Team;
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
}