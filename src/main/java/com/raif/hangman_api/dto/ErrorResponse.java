package com.raif.hangman_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    // This is the consistent structure we return for ALL errors
    // Every error response in the entire API looks exactly like this

    private int status;       // HTTP status code e.g. 404, 400, 500
    private String error;     // Short description e.g. "Not Found", "Bad Request"
    private String message;   // Detailed message e.g. "User not found"
    private String path;      // Which endpoint caused the error e.g. "/api/auth/login"
}