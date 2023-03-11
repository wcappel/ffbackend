package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.MatchupId;
import com.wcappel.ffbackend.dto.MatchupMetaDTO;
import com.wcappel.ffbackend.model.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchupRepository extends JpaRepository<Matchup, MatchupId> {
    @Query(value = "SELECT DISTINCT Temp.League, Temp.Current_week, Temp.Pre_match, Temp.League_match_num," +
            " Temp.homeTeam, Temp2.awayTeam, Temp.Home_owner, Temp2.Away_owner, Temp.Home_score, Temp2.Away_score, Home_logo, Away_logo" +
            " FROM (SELECT Matchups.League, Leagues.Current_week, Pre_match, League_match_num," +
            " homeTeam, Owner AS Home_owner, Home_score, Teams.Logo_url AS Home_logo" +
            " FROM Matchups, Leagues, Teams" +
            " WHERE Matchups.League = League_ID AND Matchups.League = Teams.League AND Matchups.League = :currLeague" +
            " AND Matchups.homeTeam = Teams.Team_name AND Week = Leagues.Current_week) AS Temp," +
            " (SELECT Matchups.League, Leagues.Current_week, Pre_match, League_match_num," +
            " awayTeam, Owner AS Away_owner, Away_score, Teams.Logo_url AS Away_logo" +
            " FROM Matchups, Leagues, Teams" +
            " WHERE Matchups.League = League_ID AND Matchups.League = Teams.League AND Matchups.League = :currLeague" +
            " AND Matchups.awayTeam = Teams.Team_name" +
            " AND Week = Leagues.Current_week) AS Temp2 WHERE Temp.League_match_num = Temp2.League_match_num", nativeQuery = true)
    List<MatchupMetaDTO> getCurrentLeagueMatchupsInfo(@Param("currLeague") int currLeague);

    @Query(value = "SELECT DISTINCT Temp.League, Temp.Current_week, Temp.Pre_match, Temp.League_match_num," +
            " Temp.homeTeam, Temp2.awayTeam, Temp.Home_owner, Temp2.Away_owner, Temp.Home_score, Temp2.Away_score, Home_logo, Away_logo" +
            " FROM (SELECT Matchups.League, Leagues.Current_week, Pre_match, League_match_num," +
            " homeTeam, Owner AS Home_owner, Home_score, Teams.Logo_url AS Home_logo" +
            " FROM Matchups, Leagues, Teams" +
            " WHERE Matchups.League = League_ID AND Matchups.League = Teams.League AND Matchups.League = :currLeague" +
            " AND Matchups.homeTeam = Teams.Team_name) AS Temp," +
            " (SELECT Matchups.League, Leagues.Current_week, Pre_match, League_match_num," +
            " awayTeam, Owner as Away_owner, Away_score, Teams.Logo_url AS Away_logo" +
            " FROM Matchups, Leagues, Teams" +
            " WHERE Matchups.League = League_ID AND Matchups.League = Teams.League AND Matchups.League = :currLeague" +
            " AND Matchups.awayTeam = Teams.Team_name)" +
            " AS Temp2 WHERE Temp.League_match_num = Temp2.League_match_num" +
            " AND (Temp.homeTeam = :currTeam OR Temp2.awayTeam = :currTeam)", nativeQuery = true)
    List<MatchupMetaDTO> getAllTeamMatchupsInfo(@Param("currLeague") int currLeague, @Param("currTeam") String currTeam);

    @Query(value = "SELECT DISTINCT Matchups.* FROM Matchups, Leagues WHERE Matchups.League = Leagues.League_ID" +
            " AND Matchups.League = :currLeague AND Matchups.Week = Leagues.Current_week", nativeQuery = true)
    List<Matchup> getCurrentLeagueMatchupsInternal(@Param("currLeague") int currLeague);

//    List<MatchupMetaDTO> getCurrentMatchupsByUser(@Param("currUser") String currUser);
}

