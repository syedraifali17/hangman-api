package com.raif.hangman_api.controller;

import com.raif.hangman_api.dto.UserStatsResponse;
import com.raif.hangman_api.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/me")
    // GET /api/stats/me?userId=1
    // Returns the stats for a specific user
    public ResponseEntity<UserStatsResponse> getMyStats(@RequestParam Long userId) {
        return ResponseEntity.ok(statsService.getMyStats(userId));
    }

    @GetMapping("/leaderboard")
    // GET /api/stats/leaderboard
    // Returns all users sorted by highest streak
    // No userId needed — this is public information
    public ResponseEntity<List<UserStatsResponse>> getLeaderboard() {
        return ResponseEntity.ok(statsService.getLeaderboard());
    }
}