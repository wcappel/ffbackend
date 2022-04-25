package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.League;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchupId matchupId = (MatchupId) o;
        return matchNum == matchupId.matchNum && league.equals(matchupId.league);
    }

    @Override public int hashCode() {
        return Objects.hash(league, matchNum);
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
