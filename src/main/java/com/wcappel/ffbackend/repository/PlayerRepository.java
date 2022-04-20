package com.wcappel.ffbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wcappel.ffbackend.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
