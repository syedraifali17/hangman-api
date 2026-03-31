package com.raif.hangman_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserStatsResponse {

    private String username;
    private int currentStreak;
    private int highestStreak;
}