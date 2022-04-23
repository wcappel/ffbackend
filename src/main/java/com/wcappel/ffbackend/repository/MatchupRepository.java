package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.MatchupId;
import com.wcappel.ffbackend.model.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchupRepository extends JpaRepository<Matchup, MatchupId> {

}
