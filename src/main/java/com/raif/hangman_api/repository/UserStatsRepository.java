package com.raif.hangman_api.repository;

import com.raif.hangman_api.entity.UserStats;
import com.raif.hangman_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserStatsRepository extends JpaRepository<UserStats, Long> {

    Optional<UserStats> findByUser(User user);

    // For leaderboard — returns all stats sorted by highest streak descending
    List<UserStats> findAllByOrderByHighestStreakDesc();
}