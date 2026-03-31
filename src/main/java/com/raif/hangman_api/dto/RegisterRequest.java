package com.raif.hangman_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data  // Lombok generates getters, setters, toString automatically
public class RegisterRequest {

    @NotBlank(message = "Username cannot be empty")
    // @NotBlank means: not null, not empty string, not just spaces
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}