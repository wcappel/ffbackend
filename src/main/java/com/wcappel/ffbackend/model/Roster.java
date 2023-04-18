package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.misc.ProjectConstants;
import com.wcappel.ffbackend.misc.RosterId;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;

@Entity @Table(name="Rosters") public class Roster {
    @JsonUnwrapped @EmbeddedId private RosterId rosterId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name="Rostered", referencedColumnName = "Team_name", nullable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "League", referencedColumnName = "League"))
    }) private Team rostered;
    @Column(name="Roster_position", length=4) private String rosterPosition;

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
        if (ProjectConstants.ROSTER_POSITIONS.contains(rosterPosition)) {
            this.rosterPosition = rosterPosition;
        }
    }
}
