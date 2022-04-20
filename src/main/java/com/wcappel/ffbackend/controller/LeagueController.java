package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/leagues") public class LeagueController {
    @Autowired private LeagueRepository leagueRepository;

    @GetMapping("/getallleagues") List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @PostMapping("/addleague") League addLeague(@RequestBody League l) {
        return leagueRepository.save(l);
    }
}
