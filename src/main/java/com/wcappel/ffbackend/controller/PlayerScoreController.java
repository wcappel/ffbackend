package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.PlayerScore;
import com.wcappel.ffbackend.repository.PlayerScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/playerscores") public class PlayerScoreController {
    @Autowired private PlayerScoreRepository playerScoreRepository;

    @GetMapping("/getallplayerscores") List<PlayerScore> getAllPlayerScores() {
        return playerScoreRepository.findAll();
    }
}
