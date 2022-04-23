package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.Matchup;
import com.wcappel.ffbackend.repository.MatchupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/matchups") public class MatchupController {
    @Autowired private MatchupRepository matchupRepository;

    @GetMapping("/getallmatchups") List<Matchup> getAllMatchups() {
        return matchupRepository.findAll();
    }

    @PostMapping("/addmatchup")
    public Matchup addMatchup(@RequestBody Matchup m) {
        System.out.println(m);
        System.out.println(matchupRepository.save(m));
        return matchupRepository.save(m);
    }
}
