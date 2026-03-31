package com.raif.hangman_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StartGameRequest {

    @NotNull(message = "User ID is required")
    private Long userId;
    // The user tells us who they are by sending their userId
    // In a JWT system this would come from the token automatically
    // But since we are keeping auth simple, the user sends their id directly
}