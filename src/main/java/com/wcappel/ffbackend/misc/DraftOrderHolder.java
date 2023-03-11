package com.wcappel.ffbackend.misc;


import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component public class DraftOrderHolder {
    private final Map<League, DraftOrder> draftOrderPerLeague = new ConcurrentHashMap<>();

    public DraftOrder createLeagueDraftOrder(League league, List<Team> leagueTeams) {
        return draftOrderPerLeague.put(league, new DraftOrder(leagueTeams));
    }

    public DraftOrder getLeagueDraftOrder(League league) {
        return draftOrderPerLeague.get(league);
    }

    public DraftOrder removeLeagueDraftOrder(League league) {
        return draftOrderPerLeague.remove(league);
    }
}
