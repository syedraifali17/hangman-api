package com.raif.hangman_api.repository;

import com.raif.hangman_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// JpaRepository<User, Long> means:
// - We're working with the User entity
// - The primary key type is Long
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring reads this method name and automatically generates:
    // SELECT * FROM users WHERE username = ?
    // You don't write that SQL — the method name IS the query
    Optional<User> findByUsername(String username);

    // Spring generates: SELECT COUNT(*) > 0 FROM users WHERE username = ?
    boolean existsByUsername(String username);
}