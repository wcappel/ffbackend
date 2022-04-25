package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.Player;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerScoreId that = (PlayerScoreId) o;
        return week == that.week && player.equals(that.player);
    }

    @Override public int hashCode() {
        return Objects.hash(player, week);
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
