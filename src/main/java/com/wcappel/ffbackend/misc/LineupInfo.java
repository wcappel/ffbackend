package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.Roster;
import com.wcappel.ffbackend.model.Team;

// Wrapper for Roster to send related info
public class LineupInfo extends Roster {
    private Float fantasyPoints;
    private boolean available;
    private String nflTeam;

    public LineupInfo() {}

    public LineupInfo(Roster r, String nflTeam, boolean available, Float fantasyPoints) {
        this.setRosterId(r.getRosterId());
        this.setRostered(r.getRostered());
        this.setRosterPosition(r.getRosterPosition());
        this.fantasyPoints = fantasyPoints;
        this.available = available;
        this.nflTeam = nflTeam;
    }

    public LineupInfo(RosterId rosterId, Team rostered, String rosterPosition, Float fantasyPoints, boolean available, String nflTeam) {
        super(rosterId, rostered, rosterPosition);
        this.fantasyPoints = fantasyPoints;
        this.available = available;
        this.nflTeam = nflTeam;
    }

    public Float getFantasyPoints() {
        return fantasyPoints;
    }

    public void setFantasyPoints(Float fantasyPoints) {
        this.fantasyPoints = fantasyPoints;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getNflTeam() {
        return nflTeam;
    }

    public void setNflTeam(String nflTeam) {
        this.nflTeam = nflTeam;
    }

    @Override
    public String toString() {
        return "LineupInfo{" +
                "fantasyPoints=" + fantasyPoints +
                ", available=" + available +
                ", nflTeam='" + nflTeam + '\'' +
                '}';
    }
}
