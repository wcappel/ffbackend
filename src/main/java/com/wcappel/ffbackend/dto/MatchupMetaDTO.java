package com.wcappel.ffbackend.dto;

public interface MatchupMetaDTO {
    int getLeague();
    byte getCurrent_week();
    boolean getPre_match();
    int getLeague_match_num();
    String gethomeTeam();
    String getawayTeam();
    Float getHome_score();
    Float getAway_score();
    String getHome_logo();
    String getAway_logo();
    String getHome_owner();
    String getAway_owner();
}
