package com.wcappel.ffbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.wcappel.ffbackend.dto.PlayerDTO;
import com.wcappel.ffbackend.misc.PlayerId;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @Table(name="Players") public class Player {
    @JsonUnwrapped @EmbeddedId PlayerId playerId;

    public Player() {}

    public Player(PlayerId playerId) {
        this.playerId = playerId;
    }

    public Player(PlayerDTO playerDto) {
        this.playerId = new PlayerId(playerDto.getName(), playerDto.getPosition());
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                '}';
    }
}
