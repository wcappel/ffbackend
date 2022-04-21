package com.wcappel.ffbackend.misc;

import java.io.Serializable;

public class PlayerId implements Serializable {
    private String name;
    private String position;

    public PlayerId() {}

    public PlayerId(String playerName, String playerPosition) {
        this.name = playerName;
        this.position = playerPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
