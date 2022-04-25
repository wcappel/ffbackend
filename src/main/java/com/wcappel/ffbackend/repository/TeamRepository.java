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

    @Query(value = "SELECT * FROM Teams t WHERE league = :currLeague", nativeQuery = true)
        List<Team> getTeamsByLeague(@Param("currLeague") String currLeague);
}
