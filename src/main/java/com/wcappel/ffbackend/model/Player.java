package com.wcappel.ffbackend.model;

import com.wcappel.ffbackend.misc.PlayerId;

import javax.persistence.*;

@Entity @IdClass(PlayerId.class)@Table(name="Players") public class Player {

    @Id @Column(name="Name") private String name;
    @Id @Column(name="Position") private String position;

    public Player() {}

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }
}
