package com.wcappel.ffbackend.model;

import javax.persistence.*;

@Entity @Table(name="Leagues") public class League {
    @Id @Column(name="League_ID") @GeneratedValue(strategy= GenerationType.IDENTITY) int leagueID;
    @Column(name="Name") String name;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="Commissioner") User commissioner;
    @Column(name="Current_week") byte currentWeek;
    @Column(name="Pre_match") boolean preMatch;
    @Column(name="Logo_url") String logoUrl;

    public League() {}

    public League(String name, User commissioner, String logoUrl) {
        this.currentWeek = 0;
        this.preMatch = true;
        this.name = name;
        this.commissioner = commissioner;
        this.logoUrl = logoUrl;
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
