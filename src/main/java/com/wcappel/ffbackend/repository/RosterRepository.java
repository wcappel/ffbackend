package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.LineupDTO;
import com.wcappel.ffbackend.misc.RosterId;
import com.wcappel.ffbackend.model.Roster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RosterRepository extends JpaRepository<Roster, RosterId> {
    @Query(value = "SELECT Rosters.Player_name, Rosters.Position, Rosters.Roster_position, PlayerScores.NFL_team," +
            " PlayerScores.Available," +
            " CASE WHEN Leagues.Pre_match = FALSE THEN PlayerScores.Fantasy_points" +
            " ELSE NULL" +
            " END AS Points" +
            " FROM Rosters, PlayerScores, Leagues" +
            " WHERE Rosters.Player_name = PlayerScores.Name AND PlayerScores.Position = Rosters.Position" +
            " AND Rosters.League = Leagues.League_ID" +
            " AND PlayerScores.Week = Leagues.Current_week" +
            " AND Rosters.Rostered = :currTeam AND Rosters.League = :currLeague"
                    , nativeQuery = true)
    List<LineupDTO> getTeamRoster(@Param("currLeague") int currLeague, String currTeam);

    @Query(value = "SELECT Count(*) FROM Rosters WHERE League = :currLeague" +
            " AND Rostered = :currTeam AND Roster_position = \"BNCH\"", nativeQuery = true)
    int getNumOfPlayersOnBench(@Param("currLeague") int currLeague, @Param("currTeam") String currTeam);
}
