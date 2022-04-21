package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.PlayerScoreId;
import com.wcappel.ffbackend.model.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, PlayerScoreId> {

}
