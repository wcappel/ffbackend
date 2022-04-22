package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/teams") public class TeamController {
    @Autowired private TeamRepository teamRepository;

    @GetMapping("/getallteams") List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @PostMapping("/addteam")
    public Team addTeam(@RequestBody Team t) {
        System.out.println(t.toString());
        return teamRepository.save(t);
    }
}
