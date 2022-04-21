package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wcappel.ffbackend.misc.TeamId;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @IdClass(TeamId.class) @Table(name="Teams") public class Team {
    @Id @Column(name="Team_name") private String teamName;
    @Id @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="League") private League league;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="Owner") private User owner;
    @Column(name="Wins") private byte wins;
    @Column(name="Losses") private byte losses;
    @Column(name="Ties") private byte ties;
    @Column(name="On_bye") private boolean onBye;
    @Column(name="Logo_url") private String logoUrl;

    public Team() {}

    public Team(String teamName, League league, User owner, byte wins, byte losses, byte ties, boolean onBye, String logoUrl) {
        this.teamName = teamName;
        this.league = league;
        this.owner = owner;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.onBye = onBye;
        this.logoUrl = logoUrl;
    }

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public byte getWins() {
        return wins;
    }

    public void setWins(byte wins) {
        this.wins = wins;
    }

    public byte getLosses() {
        return losses;
    }

    public void setLosses(byte losses) {
        this.losses = losses;
    }

    public byte getTies() {
        return ties;
    }

    public void setTies(byte ties) {
        this.ties = ties;
    }

    public boolean isOnBye() {
        return onBye;
    }

    public void setOnBye(boolean onBye) {
        this.onBye = onBye;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
