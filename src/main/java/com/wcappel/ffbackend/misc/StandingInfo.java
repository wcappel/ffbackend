package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.Team;
import com.wcappel.ffbackend.model.User;

import java.util.Objects;

// Wrapper for Team to send win percentage info
public class StandingInfo extends Team {
    private float wPc;

    public StandingInfo() {}

    public StandingInfo(Team t, float wPc) {
        this.setTeamId(t.getTeamId());
        this.setOwner(t.getOwner());
        this.setWins(t.getWins());
        this.setLosses(t.getLosses());
        this.setTies(t.getTies());
        this.setOnBye(t.isOnBye());
        this.setLogoUrl(t.getLogoUrl());
        this.wPc = wPc;
    }

    public StandingInfo(TeamId teamId, User owner, byte wins, byte losses, byte ties, boolean onBye, String logoUrl, float wPc) {
        super(teamId, owner, wins, losses, ties, onBye, logoUrl);
        this.wPc = wPc;
    }

    @Override
    public String toString() {
        return "StandingInfo{" +
                "wPc=" + wPc +
                '}';
    }

    public float getwPc() {
        return wPc;
    }

    public void setwPc(float wPc) {
        this.wPc = wPc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StandingInfo that = (StandingInfo) o;
        return Float.compare(that.wPc, wPc) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wPc);
    }
}
