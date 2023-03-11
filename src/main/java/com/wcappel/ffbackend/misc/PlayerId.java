package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.dto.PlayerDTO;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable public class PlayerId implements Serializable, PlayerDTO {
    @Column(name="Name", length=50, nullable = false) private String name;
    @Column(name="Position", length=4, nullable = false) private String position;

    public PlayerId() {}

    public PlayerId(String playerName, String playerPosition) {
        this.name = playerName;
        this.position = playerPosition;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerId playerId = (PlayerId) o;
        return name.equals(playerId.name) && position.equals(playerId.position);
    }

    @Override public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "PlayerId{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
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
