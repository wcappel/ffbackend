package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
