package com.wcappel.ffbackend.misc;

public interface MatchupMetaDTO {
    int getLeague();
    byte getCurrent_week();
    boolean getPre_match();
    int getLeague_match_num();
    String gethomeTeam();
    String getawayTeam();
    int getHome_score();
    int getAway_score();
    String getHome_logo();
    String getAway_logo();
    String getHome_owner();
    String getAway_owner();
}
