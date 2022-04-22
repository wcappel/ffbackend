package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;

import java.io.Serializable;

public class TeamId implements Serializable {
    private String teamName;
    private Integer leagueId;

    public TeamId() {}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public TeamId(String teamName, Integer leagueId) {
        this.teamName = teamName;
        this.leagueId = leagueId;
    }
}
