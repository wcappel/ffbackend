package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.LineupInfo;
import com.wcappel.ffbackend.dto.PlayerDTO;
import com.wcappel.ffbackend.misc.LineupInfo;
import com.wcappel.ffbackend.misc.RosterId;
import com.wcappel.ffbackend.model.League;
import com.wcappel.ffbackend.model.Roster;
import com.wcappel.ffbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RosterRepository extends JpaRepository<Roster, RosterId> {
    @Query(value = "SELECT new com.wcappel.ffbackend.misc.LineupInfo(r, ps.nflTeam," +
            " ps.available," +
            " CASE WHEN l.preMatch = FALSE THEN ps.fantasyPoints" +
            " ELSE NULL" +
            " END AS Points)" +
            " FROM Roster r, PlayerScore ps, League l" +
            " WHERE r.rosterId.player.playerId.name = ps.playerScoreId.player.playerId.name AND ps.playerScoreId.player.playerId.position = r.rosterId.player.playerId.position" +
            " AND r.rosterId.league.leagueId = l.leagueId" +
            " AND ps.playerScoreId.week = l.currentWeek" +
            " AND r.rostered.teamId.teamName = :currTeam AND r.rosterId.league.leagueId = :currLeague"
                    , nativeQuery = false)
    List<LineupInfo> getTeamRoster(@Param("currLeague") int currLeague, String currTeam);

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

    List<Roster> findByRosteredAndRosterPositionAndRosterId_League(Team rostered, String rosterPosition, League league);
}
