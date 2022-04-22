package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @Table(name="Leagues") public class League {
    @Id @Column(name="League_ID", nullable = false) @GeneratedValue(strategy= GenerationType.IDENTITY) Integer leagueID;
    @Column(name="Name", nullable = false) String name;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="Commissioner") User commissioner;
    @Column(name="Current_week") byte currentWeek;
    @Column(name="Pre_match") boolean preMatch;
    @Column(name="Logo_url") String logoUrl;

    public League() {}

    public League(Integer leagueID) {
        this.leagueID = leagueID;
    }

    public League(Integer leagueID, String name, User commissioner, String logoUrl) {
        this.leagueID = leagueID;
        this.currentWeek = 0;
        this.preMatch = true;
        this.name = name;
        this.commissioner = commissioner;
        this.logoUrl = logoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return leagueID.equals(league.leagueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueID);
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueID=" + leagueID +
                ", name='" + name + '\'' +
                ", commissioner=" + commissioner +
                ", currentWeek=" + currentWeek +
                ", preMatch=" + preMatch +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCommissioner() {
        return this.commissioner;
    }

    public void setCommissioner(User commissioner) {
        this.commissioner = commissioner;
    }

    public byte getCurrentWeek() {
        return this.currentWeek;
    }

    public void setCurrentWeek(byte currentWeek) {
        this.currentWeek = currentWeek;
    }

    public boolean isPreMatch() {
        return this.preMatch;
    }

    public Integer getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(Integer leagueID) {
        this.leagueID = leagueID;
    }

    public void setPreMatch(boolean preMatch) {
        this.preMatch = preMatch;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
