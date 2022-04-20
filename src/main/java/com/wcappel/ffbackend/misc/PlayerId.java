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
}
