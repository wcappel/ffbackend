package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Player;

import java.io.Serializable;

public class RosterId implements Serializable {
    private Player playerRef;
    private League league;

    public RosterId() {}

    public RosterId(Player playerRef, League league) {
        this.league = league;
        this.playerRef = playerRef;
    }

    public Player getPlayerRef() {
        return playerRef;
    }

    public void setPlayerRef(Player playerRef) {
        this.playerRef = playerRef;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
