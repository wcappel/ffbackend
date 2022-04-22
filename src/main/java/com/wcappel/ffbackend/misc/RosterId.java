package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Player;

import java.io.Serializable;

public class RosterId implements Serializable {
    private String playerName;
    private String playerPos;
    private int leagueId;

    public RosterId() {}

    public RosterId(String playerName, String playerPos, int leagueId) {
        this.playerName = playerName;
        this.playerPos = playerPos;
        this.leagueId = leagueId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(String playerPos) {
        this.playerPos = playerPos;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int league) {
        this.leagueId = league;
    }
}
