package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.dto.LineupDTO;
import com.wcappel.ffbackend.dto.PlayerDTO;
import com.wcappel.ffbackend.misc.RosterId;
import com.wcappel.ffbackend.model.League;
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

    @Query(value = "SELECT * FROM Rosters WHERE League = :currLeague", nativeQuery = true)
    List<Roster> getLeagueRoster (@Param("currLeague") int currLeague);

    @Query(value = "SELECT Players.Name, Players.Position FROM Players\n" +
            "LEFT OUTER JOIN (SELECT * FROM Rosters WHERE League = :currLeague) AS Temp ON\n" +
            "Temp.Player_name = Players.Name AND Temp.Position = Players.Position\n" +
            "WHERE Temp.Player_name IS NULL AND Temp.Position IS NULL", nativeQuery = true)
    List<PlayerDTO> getUnrosteredPlayers(@Param("currLeague") int currLeague);

    @Query(value = "SELECT Count(*) FROM Rosters WHERE League = :currLeague" +
            " AND Rostered = :currTeam AND Roster_position = \"BNCH\"", nativeQuery = true)
    int getNumOfPlayersOnBench(@Param("currLeague") int currLeague, @Param("currTeam") String currTeam);

    List<Roster> findByRosteredAndRosterPositionAndRosterId_League(String rostered, String rosterPosition, League league);
}
