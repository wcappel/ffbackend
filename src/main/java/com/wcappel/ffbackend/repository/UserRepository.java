package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM Users WHERE Email = :userEmail LIMIT 1", nativeQuery = true)
    User getUserByEmail(@Param("userEmail") String userEmail);
}
