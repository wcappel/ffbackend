package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.StandingDTO;
import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League, Long> {
    @Query(value = "SELECT Count(*) FROM Teams t WHERE league = :currLeague", nativeQuery = true)
        int getNumOfTeamsInLeague(@Param("currLeague") String currLeague);

    @Query(value = "SELECT * FROM (SELECT Team_name, League, Owner, Wins, Losses, Ties," +
        " CASE WHEN Wins > 0 OR Losses > 0 OR Ties > 0 THEN CAST(((Wins + (Ties / 2)) / (Wins + Losses + Ties)) AS FLOAT)" +
        " ELSE CAST(0 AS FLOAT)" +
        " END AS W_pc, Logo_url FROM Teams WHERE League = :currLeague GROUP BY Team_name)" +
        " AS Temp ORDER BY W_pc DESC", nativeQuery = true)
        List<StandingDTO> getLeagueStandings(@Param("currLeague") int currLeague);

    @Query(value = "SELECT Commissioner FROM Leagues WHERE League_ID = :currLeague", nativeQuery = true)
    String getCommissioner(@Param("currLeague") int currLeague);
}