package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable public class MatchupId implements Serializable {
    @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="League", referencedColumnName="League_ID", updatable = false, insertable = false, nullable = false)
        private League league;
    @Column(name="League_match_num", nullable = false, unique = true) @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int matchNum;

    public MatchupId() {}

    public MatchupId(League league, int matchNum) {
        this.league = league;
        this.matchNum = matchNum;
    }

    @Override public String toString() {
        return "MatchupId{" +
                "league=" + league +
                ", matchNum=" + matchNum +
                '}';
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }
}
