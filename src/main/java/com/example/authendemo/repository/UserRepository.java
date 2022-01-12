package com.example.authendemo.repository;

import com.example.authendemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("" + "SELECT CASE WHEN COUNT(s) > 0 THEN " +
    "TRUE ELSE FALSE END " +
    "FROM User s " +
    "WHERE s.username = ?1")
    Boolean selectExistsUsername(String username);
}
