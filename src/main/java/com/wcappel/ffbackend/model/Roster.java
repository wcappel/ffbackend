package com.wcappel.ffbackend.model;

import com.wcappel.ffbackend.misc.RosterId;

import javax.persistence.*;

@Entity @IdClass(RosterId.class) @Table(name="Rosters") public class Roster {
    @Id @ManyToOne(fetch = FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="Player_name", referencedColumnName = "Name"),
            @JoinColumn(name="Position", referencedColumnName = "Position")
    }) private Player playerRef;
    @Id @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="League") private League league;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="League", referencedColumnName = "League", insertable = false, updatable = false),
            @JoinColumn(name="Rostered", referencedColumnName = "Team_name", insertable = false, updatable = false)
    }) private Team rostered;
    @Column(name="Roster_position") private String rosterPosition;

    public Roster() {}

    public Roster(Player playerRef, League league, Team rostered, String rosterPosition) {
        this.playerRef = playerRef;
        this.league = league;
        this.rosterPosition = rosterPosition;
        this.rostered = rostered;
    }

    public Player getPlayerRef() {
        return playerRef;
    }

    public Team getRostered() {
        return rostered;
    }

    public void setRostered(Team rostered) {
        this.rostered = rostered;
    }

    public void setPlayerRef(Player playerRef) {
        this.playerRef = playerRef;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getRosterPosition() {
        return rosterPosition;
    }

    public void setRosterPosition(String rosterPosition) {
        this.rosterPosition = rosterPosition;
    }
}
