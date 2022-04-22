package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.Roster;
import com.wcappel.ffbackend.repository.RosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/rosters") public class RosterController {
    @Autowired private RosterRepository rosterRepository;

    // http://localhost:8080/ffapi/v1/rosters
    @GetMapping("/getallrosters")
    public List<Roster> getAllRosters() {
        return rosterRepository.findAll();
    }

    @PostMapping("/addroster")
    public Roster addRoster(@RequestBody Roster r) {
        System.out.println(r.toString());
        return rosterRepository.save(r);
    }
}

