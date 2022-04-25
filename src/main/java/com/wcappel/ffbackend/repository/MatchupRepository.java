package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.MatchupId;
import com.wcappel.ffbackend.model.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchupRepository extends JpaRepository<Matchup, MatchupId> {
    @Query(value = "SELECT * FROM Matchups WHERE League = :currLeague AND Week = :currWeek", nativeQuery = true)
    List<Matchup> getLeagueMatchupsByWeek(@Param("currLeague") int currLeague, @Param("currWeek") byte currWeek);
}

