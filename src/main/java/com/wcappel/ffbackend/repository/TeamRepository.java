package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.TeamId;
import com.wcappel.ffbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, TeamId> {

}
