package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.Player;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable public class PlayerScoreId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="Name", nullable = false),
            @JoinColumn(name="Position", nullable = false)
    }) private Player player;
    @Column(name="Week", nullable = false) private byte week;

    public PlayerScoreId() {}

    public PlayerScoreId(Player player, byte week) {
        this.player = player;
        this.week = week;
    }

    @Override
    public String toString() {
        return "PlayerScoreId{" +
                "player=" + player +
                ", week=" + week +
                '}';
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public byte getWeek() {
        return week;
    }

    public void setWeek(byte week) {
        this.week = week;
    }
}
