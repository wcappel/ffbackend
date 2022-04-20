package com.wcappel.ffbackend.model;

import javax.persistence.*;

@Entity @Table(name="Users") public class User {
    @Id @Column(name="Username") String username;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
