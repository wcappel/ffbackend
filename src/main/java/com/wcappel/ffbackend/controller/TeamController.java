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

    @PostMapping("/addteam") public Team addTeam(@RequestBody Team t) {
        System.out.println(t.toString());
        return teamRepository.save(t);
    }

    @GetMapping("/getteamsbyuser/user={user}")
    public List<Team> getTeamsByUser(@PathVariable String user) {
        return teamRepository.getTeamsByUser(user);
    }

    @GetMapping("/getteamsbyleagueanduser/league={league},user={user}")
    public List<Team> getTeamsByLeagueAndUser(@PathVariable int league, @PathVariable String user) {
        return teamRepository.getTeamsByLeagueAndUser(league, user);
    }

    @GetMapping("/getteamsbyleague/league={league}")
    public List<Team> getTeamsByLeague(@PathVariable int league) {
        return teamRepository.getTeamsByLeague(league);
    }

    @GetMapping("/getteamfantasypoints/league={league},team={team}")
    public float getTeamFantasyPoints(@PathVariable int league, @PathVariable String team) {
        return teamRepository.getTeamFantasyPoints(league, team);
    }
}
