package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.TeamId;
import com.wcappel.ffbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, TeamId> {
    @Query(value = "SELECT * FROM Teams t WHERE owner = :currUser" , nativeQuery = true)
        List<Team> getTeamsByUser(@Param("currUser") String currUser);

    @Query(value = "SELECT * FROM Teams t WHERE owner = :currUser AND league = :currLeague", nativeQuery = true)
        List<Team> getTeamsByLeagueAndUser(@Param("currLeague") int currLeague, @Param("currUser") String currUser);

    @Query(value = "SELECT * FROM Teams t WHERE league = :currLeague", nativeQuery = true)
        List<Team> getTeamsByLeague(@Param("currLeague") int currLeague);

    @Query(value = "SELECT Sum(Temp.Fantasy_points) FROM (SELECT PlayerScores.Fantasy_points FROM PlayerScores, Rosters, Leagues" +
            " WHERE PlayerScores.Name = Rosters.Player_name AND PlayerScores.Position = Rosters.Position" +
            " AND Rosters.Rostered = :currTeam AND Rosters.League = :currLeague AND Leagues.League_ID = Rosters.League" +
            " AND Rosters.Position != \"BNCH\" AND PlayerScores.Week = Leagues.Current_week) AS Temp", nativeQuery = true)
        float getTeamFantasyPoints(@Param("currLeague") int currLeague, @Param("currTeam") String currTeam);
}
