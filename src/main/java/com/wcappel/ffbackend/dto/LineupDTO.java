package com.wcappel.ffbackend.dto;

public interface LineupDTO {
    String getPlayer_name();
    String getPosition();
    String getRoster_position();
    String getNFL_team();
    boolean getAvailable();
    Float getPoints();
}
