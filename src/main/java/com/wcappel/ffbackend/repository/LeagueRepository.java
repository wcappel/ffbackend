package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.StandingInfo;
import com.wcappel.ffbackend.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LeagueRepository extends JpaRepository<League, Long> {
    @Query(value = "SELECT Count(*) FROM Teams t WHERE league = :currLeague", nativeQuery = true)
        byte getNumOfTeamsInLeague(@Param("currLeague") int currLeague);

    @Query(value = "SELECT new com.wcappel.ffbackend.misc.StandingInfo(t, CASE WHEN t.wins > 0 OR t.losses > 0 OR t.ties > 0 THEN " +
            "CAST(((t.wins + (t.ties / 2)) / (t.wins + t.losses + t.ties)) AS float) ELSE CAST(0 AS float) END AS wPC) " +
            "FROM Team t WHERE t.teamId.league.leagueId = :currLeague GROUP BY t.teamId.teamName ORDER BY wPC")
    List<StandingInfo> getLeagueStandings(@Param("currLeague") int currLeague);

    @Query(value = "SELECT Commissioner FROM Leagues WHERE League_ID = :currLeague", nativeQuery = true)
    String getCommissioner(@Param("currLeague") int currLeague);

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM Teams WHERE League = :currLeague," +
            " AND Owner = :user) THEN True ELSE False END", nativeQuery = true)
    boolean checkUserHasTeamInLeague(@Param("currLeague") int currLeague, @Param("user") String user);

    @Query(value = "SELECT Commissioner FROM Leagues WHERE League = :currLeague", nativeQuery = true)
    String getLeagueCommissioner(@Param("currLeague") int currLeague);

    Optional<League> findByLeagueId(int id);
}