package com.wcappel.ffbackend.misc;

public interface StandingDTO {
    String getTeam_name();
    String getOwner();
    int getLeague();
    byte getWins();
    byte getLosses();
    byte getTies();
    float getW_pc();
}
