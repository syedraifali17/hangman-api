package com.raif.hangman_api.service;

import com.raif.hangman_api.dto.UserStatsResponse;
import com.raif.hangman_api.entity.User;
import com.raif.hangman_api.entity.UserStats;
import com.raif.hangman_api.exception.ResourceNotFoundException;
import com.raif.hangman_api.repository.UserRepository;
import com.raif.hangman_api.repository.UserStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final UserStatsRepository userStatsRepository;
    private final UserRepository userRepository;

    // ========== GET MY STATS ==========
    public UserStatsResponse getMyStats(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        UserStats stats = userStatsRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Stats not found"));

        return new UserStatsResponse(
                user.getUsername(),
                stats.getCurrentStreak(),
                stats.getHighestStreak()
        );
    }

    // ========== GET LEADERBOARD ==========
    public List<UserStatsResponse> getLeaderboard() {

        List<UserStats> allStats = userStatsRepository
                .findAllByOrderByHighestStreakDesc();

        return allStats.stream()
                .map(stats -> new UserStatsResponse(
                        stats.getUser().getUsername(),
                        stats.getCurrentStreak(),
                        stats.getHighestStreak()
                ))
                .collect(Collectors.toList());
    }
}