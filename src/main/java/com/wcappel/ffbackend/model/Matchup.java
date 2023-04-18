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
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="homeTeam", referencedColumnName = "Team_name", nullable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "League", referencedColumnName = "League"))
    }) private Team homeTeam;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="awayTeam", referencedColumnName = "Team_name", nullable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "League", referencedColumnName = "League"))
    }) private Team awayTeam;
    @Column(name="Home_score") private Float homeScore;
    @Column(name="Away_score") private Float awayScore;

    public Matchup() {}

    public Matchup(MatchupId matchupId, int week, Team homeTeam, Team awayTeam, Float homeScore, Float awayScore) {
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

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Float getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Float homeScore) {
        this.homeScore = homeScore;
    }

    public Float getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Float awayScore) {
        this.awayScore = awayScore;
    }
}
