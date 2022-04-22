package com.wcappel.ffbackend.model;

import com.wcappel.ffbackend.misc.RosterId;

import javax.persistence.*;

@Entity @IdClass(RosterId.class) @Table(name="Rosters") public class Roster {
    @Id @Column(name="Player_name", insertable = false, updatable = false) private String playerName;
    @Id @Column(name="Position", insertable = false, updatable = false) private String playerPos;
    @Id @Column(name="League", insertable = false, updatable = false) private int leagueId;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="Player_name", referencedColumnName = "Name", insertable = false, updatable = false),
            @JoinColumn(name="Position", referencedColumnName = "Position", insertable = false, updatable = false)
    }) private Player playerRef;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="League", referencedColumnName = "League_ID", insertable = false, updatable = false) private League league;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumns({
            @JoinColumn(name="League", referencedColumnName = "League", insertable = false, updatable = false),
            @JoinColumn(name="Rostered", referencedColumnName = "Team_name", insertable = false, updatable = false)
    }) private Team rostered;
    @Column(name="Roster_position") private String rosterPosition;

    public Roster() {}

    public Roster(String playerName, String playerPosition, int leagueId, Player playerRef, League league,
                  Team rostered, String rosterPosition) {
        this.playerName = playerName;
        this.playerPos = playerPosition;
        this.leagueId = leagueId;
        this.playerRef = playerRef;
        this.league = league;
        this.rostered = rostered;
        this.rosterPosition = rosterPosition;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "playerName='" + playerName + '\'' +
                ", playerPos='" + playerPos + '\'' +
                ", leagueId=" + leagueId +
                ", playerRef=" + playerRef +
                ", league=" + league +
                ", rostered=" + rostered +
                ", rosterPosition='" + rosterPosition + '\'' +
                '}';
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(String playerPos) {
        this.playerPos = playerPos;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public Player getPlayerRef() {
        return playerRef;
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
