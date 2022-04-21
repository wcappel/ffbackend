package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;

import java.io.Serializable;
import java.util.Objects;

public class TeamId implements Serializable {
    private String teamName;
    private League league;

    public TeamId() {}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public TeamId(String teamName, League league) {
        this.teamName = teamName;
        this.league = league;
    }
}
