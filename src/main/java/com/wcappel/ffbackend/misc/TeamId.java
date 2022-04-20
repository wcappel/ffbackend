package com.wcappel.ffbackend.misc;

import java.io.Serializable;

public class TeamId implements Serializable {
    private String teamName;
    private int league;

    public TeamId() {}

    public TeamId(String teamName, int league) {
        this.teamName = teamName;
        this.league = league;
    }
}
