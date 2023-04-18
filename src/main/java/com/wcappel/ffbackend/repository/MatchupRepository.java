package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.MatchupId;
import com.wcappel.ffbackend.model.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchupRepository extends JpaRepository<Matchup, MatchupId> {
    @Query(value = "SELECT DISTINCT m FROM Matchup m WHERE m.matchupId.league.leagueId = :currLeague " +
            "AND m.week = m.matchupId.league.currentWeek")
    List<Matchup> getCurrentLeagueMatchupsInfo(@Param("currLeague") int currLeague);

    @Query(value = "SELECT DISTINCT m FROM Matchup m WHERE " +
            "(m.homeTeam.teamId.teamName = :currTeam OR m.awayTeam.teamId.teamName = :currTeam) AND m.matchupId.league.leagueId = :currLeague")
    List<Matchup> getAllTeamMatchupsInfo(@Param("currLeague") int currLeague, @Param("currTeam") String currTeam);

    @Query(value = "SELECT DISTINCT Matchups.* FROM Matchups, Leagues WHERE Matchups.League = Leagues.League_ID" +
            " AND Matchups.League = :currLeague AND Matchups.Week = Leagues.Current_week", nativeQuery = true)
    List<Matchup> getCurrentLeagueMatchupsInternal(@Param("currLeague") int currLeague);

    @Query(value = "SELECT DISTINCT m FROM Matchup m WHERE m.week = m.matchupId.league.currentWeek " +
            "AND (m.homeTeam.owner.username = :currUser OR m.awayTeam.owner.username = :currUser)")
    List<Matchup> getCurrentMatchupsByUser(@Param("currUser") String currUser);


}

