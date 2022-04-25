package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeagueRepository extends JpaRepository<League, Long> {
    @Query(value = "SELECT Count(*) FROM Teams t WHERE league = :currLeague", nativeQuery = true)
        int getNumOfTeamsInLeague(@Param("currLeague") String currLeague);
}
