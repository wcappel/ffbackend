package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @Table(name="Leagues") public class League {
    @Id @Column(name="League_ID", nullable = false, unique = true) @GeneratedValue(strategy= GenerationType.IDENTITY)
        int leagueId;
    @Column(name="Name", length=50, nullable = false) String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name="Commissioner") User commissioner;
    @Column(name="Current_week") byte currentWeek;
    @Column(name="Pre_match") boolean preMatch;
    @Column(name="Logo_url", length=200) String logoUrl;

    public League() {}

    public League(Integer leagueId) {
        this.leagueId = leagueId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return leagueId == (league.leagueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueId);
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueID=" + leagueId +
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

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
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
