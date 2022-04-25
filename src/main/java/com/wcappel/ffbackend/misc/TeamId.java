package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable public class TeamId implements Serializable {
    @Column(name="Team_name", length=30, nullable = false) private String teamName;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = League.class)
        @JoinColumn(name="League", referencedColumnName = "League_ID", nullable = false)
        private League league;

    public TeamId() {}

    public TeamId(String teamName, League league) {
        this.teamName = teamName;
        this.league = league;
    }

    @Override public String toString() {
        return "TeamId{" +
                "teamName='" + teamName + '\'' +
                ", league=" + league +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamId teamId = (TeamId) o;
        return teamName.equals(teamId.teamName) && league.equals(teamId.league);
    }

    @Override public int hashCode() {
        return Objects.hash(teamName, league);
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
}
