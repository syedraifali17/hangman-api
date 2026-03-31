package com.raif.hangman_api.controller;

import com.raif.hangman_api.dto.AuthResponse;
import com.raif.hangman_api.dto.LoginRequest;
import com.raif.hangman_api.dto.RegisterRequest;
import com.raif.hangman_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// @RestController = @Controller + @ResponseBody
// It means: this class handles HTTP requests AND automatically converts
// return values to JSON. You don't need to manually convert anything.

@RequestMapping("/api/auth")
// Every endpoint in this controller starts with /api/auth
// So register() will be at /api/auth/register

@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    // Spring injects UserService here automatically

    @PostMapping("/register")
    // This method handles POST requests to /api/auth/register
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        // @RequestBody tells Spring: take the JSON from the request body
        // and convert it into a RegisterRequest object automatically
        // @Valid tells Spring: run the validation annotations we put on RegisterRequest
        // (like @NotBlank, @Size) before this method even runs

        AuthResponse response = userService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        // ResponseEntity lets us control the HTTP status code
        // 201 CREATED is the correct status for successfully creating a new resource
        // .body(response) puts our AuthResponse object as the JSON response body
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {

        AuthResponse response = userService.login(request);

        return ResponseEntity.ok(response);
        // ResponseEntity.ok() is a shortcut for status 200 OK
    }
}