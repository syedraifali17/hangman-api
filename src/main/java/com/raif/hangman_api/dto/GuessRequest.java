package com.raif.hangman_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GuessRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Letter is required")
    @Pattern(regexp = "[a-zA-Z]", message = "Guess must be a single letter")
    // @Pattern checks the value against a regular expression
    // [a-zA-Z] means: one character that is either lowercase a-z or uppercase A-Z
    // This prevents users from sending numbers, symbols, or multiple letters
    private String letter;
}