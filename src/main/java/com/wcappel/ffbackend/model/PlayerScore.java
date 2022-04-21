package com.wcappel.ffbackend.model;

import com.wcappel.ffbackend.misc.PlayerScoreId;

import javax.persistence.*;

@Entity @IdClass(PlayerScoreId.class) @Table(name="PlayerScores") public class PlayerScore {
    @Id @ManyToOne(fetch=FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="Name"),
            @JoinColumn(name="Position")
    }) private Player playerRef;
    @Id @Column(name="Week") private byte week;
    @Column(name="NFL_team") private String nflTeam;
    @Column(name="Available") private boolean available;
    @Column(name="Fantasy_points") private float fantasyPoints;

    public PlayerScore() {}

    public PlayerScore(Player playerRef, byte week, String nflTeam, boolean available, float fantasyPoints) {
        this.playerRef = playerRef;
        this.week = week;
        this.nflTeam = nflTeam;
        this.available = available;
        this.fantasyPoints = fantasyPoints;
    }

    public String getNflTeam() {
        return nflTeam;
    }

    public void setNflTeam(String nflTeam) {
        this.nflTeam = nflTeam;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public float getFantasyPoints() {
        return fantasyPoints;
    }

    public void setFantasyPoints(float fantasyPoints) {
        this.fantasyPoints = fantasyPoints;
    }

    public Player getPlayerRef() {
        return this.playerRef;
    }

    public void setPlayerRef(Player playerRef) {
        this.playerRef = playerRef;
    }

    public byte getWeek() {
        return this.week;
    }

    public void setWeek(byte week) {
        this.week = week;
    }
}
