package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.MatchupId;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;

@Entity @Table(name="Matchups") public class Matchup {
    @JsonUnwrapped @EmbeddedId MatchupId matchupId;
    @Column(name="Week", nullable = false) private int week;
    @JoinColumn(name="Home_team", referencedColumnName = "Team_name", nullable = false)
        private String homeTeam;
    @JoinColumn(name="Away_team", referencedColumnName = "Team_name", nullable = false)
        private String awayTeam;
    @Column(name="Home_score") private int homeScore;
    @Column(name="Away_score") private int awayScore;

    public Matchup() {}

    public Matchup(MatchupId matchupId, int week, String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.matchupId = matchupId;
        this.week = week;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override public String toString() {
        return "Matchup{" +
                "matchupId=" + matchupId +
                ", week=" + week +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }

    public MatchupId getMatchupId() {
        return matchupId;
    }

    public void setMatchupId(MatchupId matchupId) {
        this.matchupId = matchupId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}
