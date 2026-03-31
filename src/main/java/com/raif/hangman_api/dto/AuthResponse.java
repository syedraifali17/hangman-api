package com.raif.hangman_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor  // Lombok generates a constructor with all fields
// This is what we send BACK to the user after register or login
public class AuthResponse {

    private String message;   // e.g. "Login successful"
    private String username;  // e.g. "raif"
    private Long userId;      // e.g. 1 — useful for future requests
}
