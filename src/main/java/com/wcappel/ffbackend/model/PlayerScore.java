package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.PlayerScoreId;

import javax.persistence.*;

@Entity @Table(name="PlayerScores") public class PlayerScore {
    @JsonUnwrapped @EmbeddedId private PlayerScoreId playerScoreId;
    @Column(name="NFL_team", length=3) private String nflTeam;
    @Column(name="Available") private boolean available;
    @Column(name="Fantasy_points") private Float fantasyPoints;

    public PlayerScore() {}

    public PlayerScore(PlayerScoreId playerScoreId, String nflTeam, boolean available, float fantasyPoints) {
        this.playerScoreId = playerScoreId;
        this.nflTeam = nflTeam;
        this.available = available;
        this.fantasyPoints = fantasyPoints;
    }

    @Override public String toString() {
        return "PlayerScore{" +
                "playerScoreId=" + playerScoreId +
                ", nflTeam='" + nflTeam + '\'' +
                ", available=" + available +
                ", fantasyPoints=" + fantasyPoints +
                '}';
    }

    public PlayerScoreId getPlayerScoreId() {
        return playerScoreId;
    }

    public void setPlayerScoreId(PlayerScoreId playerScoreId) {
        this.playerScoreId = playerScoreId;
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
}
