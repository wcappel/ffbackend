package com.wcappel.ffbackend.misc;

import com.wcappel.ffbackend.model.Matchup;
import com.wcappel.ffbackend.model.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchupGenerator {
    private static Matchup buildMatchup(Team homeTeam, Team awayTeam, int week) {
       if (homeTeam.getTeamId().getLeague() != awayTeam.getTeamId().getLeague()) {
           System.out.println("Teams are not in the same league!");
           return null;
       } else {
           Matchup newMatchup = new Matchup();
           MatchupId newId = new MatchupId();
           newId.setLeague(homeTeam.getTeamId().getLeague());
           newMatchup.setMatchupId(newId);
           newMatchup.setHomeTeam(homeTeam);
           newMatchup.setAwayTeam(awayTeam);
           newMatchup.setWeek(week);
           return newMatchup;
       }
    }

    public static List<Matchup> genMatchups(List<Team> teams) {
        // Valid numTeams are 6, 8, 10, 12, 14
        // There is not a valid alg. (that I know of) that can consistently
        // come up w/ matchups for n teams in m rounds (RR not applicable here)
        // for now, this will be hardcoded based on # of teams (and eventually # of weeks) constraint
        // Limit to 6 weeks for now?
        List<Matchup> matchups = new ArrayList<>();
        if (teams.size() == 6) {
            // Week 1
            Matchup wk1gm1 = buildMatchup(teams.get(1), teams.get(5), 1);
            matchups.add(wk1gm1);
            Matchup wk1gm2 = buildMatchup(teams.get(0), teams.get(2), 1);
            matchups.add(wk1gm2);
            Matchup wk1gm3 = buildMatchup(teams.get(4), teams.get(3), 1);
            matchups.add(wk1gm3);
            // Week 2
            Matchup wk2gm1 = buildMatchup(teams.get(1), teams.get(0), 2);
            matchups.add(wk2gm1);
            Matchup wk2gm2 = buildMatchup(teams.get(5), teams.get(3), 2);
            matchups.add(wk2gm2);
            Matchup wk2gm3 = buildMatchup(teams.get(4), teams.get(2), 2);
            matchups.add(wk2gm3);
            // Week 3
            Matchup wk3gm1 = buildMatchup(teams.get(1), teams.get(4), 3);
            matchups.add(wk3gm1);
            Matchup wk3gm2 = buildMatchup(teams.get(5), teams.get(0), 3);
            matchups.add(wk3gm2);
            Matchup wk3gm3 = buildMatchup(teams.get(2), teams.get(3), 3);
            matchups.add(wk3gm3);
            // Week 4
            Matchup wk4gm1 = buildMatchup(teams.get(1), teams.get(2), 4);
            matchups.add(wk4gm1);
            Matchup wk4gm2 = buildMatchup(teams.get(5), teams.get(4), 4);
            matchups.add(wk4gm2);
            Matchup wk4gm3 = buildMatchup(teams.get(0), teams.get(3), 4);
            matchups.add(wk4gm3);
            // Week 5
            Matchup wk5gm1 = buildMatchup(teams.get(1), teams.get(3), 5);
            matchups.add(wk5gm1);
            Matchup wk5gm2 = buildMatchup(teams.get(5), teams.get(2), 5);
            matchups.add(wk5gm2);
            Matchup wk5gm3 = buildMatchup(teams.get(0), teams.get(4), 5);
            matchups.add(wk5gm3);
            // Week 6
            Matchup wk6gm1 = buildMatchup(teams.get(1), teams.get(5), 6);
            matchups.add(wk6gm1);
            Matchup wk6gm2 = buildMatchup(teams.get(0), teams.get(2), 6);
            matchups.add(wk6gm2);
            Matchup wk6gm3 = buildMatchup(teams.get(4), teams.get(3), 6);
            matchups.add(wk6gm3);
        } else {
            matchups = null;
        }
        return matchups;
    }

//    public List<Matchup> genMatchups(List<Team> teams, byte numWeeks) {
//
//    }
}
