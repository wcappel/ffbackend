package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.RosterId;
import com.wcappel.ffbackend.model.Roster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RosterRepository extends JpaRepository<Roster, RosterId> {

}
