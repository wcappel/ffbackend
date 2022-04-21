package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wcappel.ffbackend.misc.PlayerId;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @IdClass(PlayerId.class) @Table(name="Players") public class Player {
    @Id @Column(name="Name") private String name;
    @Id @Column(name="Position") private String position;

    public Player() {}

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }
}
