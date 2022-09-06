package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.TeamId;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @Table(name="Teams") public class Team {
    @JsonUnwrapped @EmbeddedId private TeamId teamId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="Owner", nullable = false)
        private User owner;
    @Column(name="Wins") private byte wins;
    @Column(name="Losses") private byte losses;
    @Column(name="Ties") private byte ties;
    @Column(name="On_bye") private boolean onBye;
    @Column(name="Logo_url", length=200) private String logoUrl;

    public Team() {}

    public Team(TeamId teamId, User owner, byte wins, byte losses, byte ties, boolean onBye, String logoUrl) {
        this.teamId = teamId;
        this.owner = owner;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.onBye = onBye;
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", owner=" + owner +
                ", wins=" + wins +
                ", losses=" + losses +
                ", ties=" + ties +
                ", onBye=" + onBye +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return wins == team.wins && losses == team.losses && ties == team.ties && onBye == team.onBye && Objects.equals(teamId, team.teamId) && Objects.equals(owner, team.owner) && Objects.equals(logoUrl, team.logoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, owner, wins, losses, ties, onBye, logoUrl);
    }

    public TeamId getTeamId() {
        return teamId;
    }

    public void setTeamId(TeamId teamId) {
        this.teamId = teamId;
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
