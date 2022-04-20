package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.Player;
import com.wcappel.ffbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8080/ffapi/v1/
@RestController @RequestMapping("/ffapi/v1/players") public class PlayerController {
    @Autowired private PlayerRepository playerRepository;

    // http://localhost:8080/ffapi/v1/players
    @GetMapping("/getallplayers") public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
