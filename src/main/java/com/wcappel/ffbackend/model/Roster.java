package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.RosterId;

import javax.persistence.*;

@Entity @Table(name="Rosters") public class Roster {
    @JsonUnwrapped @EmbeddedId private RosterId rosterId;
    @JoinColumn(name="Rostered", referencedColumnName = "Team_name", nullable = false)
        private String rostered;
    @Column(name="Roster_position", length=4) private String rosterPosition;

    public Roster() {}

    public Roster(RosterId rosterId, String rostered, String rosterPosition) {
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

    public String getRostered() {
        return rostered;
    }

    public void setRostered(String rostered) {
        this.rostered = rostered;
    }

    public String getRosterPosition() {
        return rosterPosition;
    }

    public void setRosterPosition(String rosterPosition) {
        this.rosterPosition = rosterPosition;
    }
}
