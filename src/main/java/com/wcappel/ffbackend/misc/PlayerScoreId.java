package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Player;

import java.io.Serializable;

public class PlayerScoreId implements Serializable {
    private Player playerRef;
    private byte week;

    public PlayerScoreId() {}

    public PlayerScoreId(Player playerRef, byte week) {
        this.playerRef = playerRef;
        this.week = week;
    }

    public Player getPlayerRef() {
        return playerRef;
    }

    public void setPlayerRef(Player playerRef) {
        this.playerRef = playerRef;
    }

    public byte getWeek() {
        return week;
    }

    public void setWeek(byte week) {
        this.week = week;
    }
}
