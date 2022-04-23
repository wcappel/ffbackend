package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.PlayerScore;
import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.repository.PlayerScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/playerscores") public class PlayerScoreController {
    @Autowired private PlayerScoreRepository playerScoreRepository;

    @GetMapping("/getallplayerscores") List<PlayerScore> getAllPlayerScores() {
        return playerScoreRepository.findAll();
    }

    @PostMapping("/addplayerscore")
    public PlayerScore addTeam(@RequestBody PlayerScore s) {
        System.out.println(s);
        return playerScoreRepository.save(s);
    }
}
