package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.RosterId;

import javax.persistence.*;

@Entity @Table(name="Rosters") public class Roster {
    @JsonUnwrapped @EmbeddedId private RosterId rosterId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="Rostered", referencedColumnName = "Team_name", insertable = false, updatable = false, nullable = false),
            @JoinColumn(name="League",referencedColumnName = "League", insertable = false, updatable = false, nullable = false)
        }) private Team rostered;
    @Column(name="Roster_position") private String rosterPosition;

    public Roster() {}

    public Roster(RosterId rosterId, Team rostered, String rosterPosition) {
        this.rosterId = rosterId;
        this.rostered = rostered;
        this.rosterPosition = rosterPosition;
    }

    @Override public String toString() {
        return "Roster{" +
                "rosterId=" + rosterId +
                ", rostered=" + rostered +
                '}';
    }

    public RosterId getRosterId() {
        return rosterId;
    }

    public void setRosterId(RosterId rosterId) {
        this.rosterId = rosterId;
    }

    public Team getRostered() {
        return rostered;
    }

    public void setRostered(Team rostered) {
        this.rostered = rostered;
    }

    public String getRosterPosition() {
        return rosterPosition;
    }

    public void setRosterPosition(String rosterPosition) {
        this.rosterPosition = rosterPosition;
    }
}
