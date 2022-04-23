package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Player;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable public class RosterId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="League", updatable = false, insertable = false, nullable = false)
        private League league;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="Player_name", nullable = false),
            @JoinColumn(name="Position", nullable = false)
        }) private Player player;

    public RosterId() {}

    public RosterId(League league, Player player) {
        this.league = league;
        this.player = player;
    }

    @Override public String toString() {
        return "RosterId{" +
                "league=" + league +
                ", player=" + player +
                '}';
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
