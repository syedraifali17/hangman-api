package com.raif.hangman_api.service;

import com.raif.hangman_api.dto.AuthResponse;
import com.raif.hangman_api.dto.LoginRequest;
import com.raif.hangman_api.dto.RegisterRequest;
import com.raif.hangman_api.entity.User;
import com.raif.hangman_api.entity.UserStats;
import com.raif.hangman_api.exception.BadRequestException;
import com.raif.hangman_api.exception.ResourceNotFoundException;
import com.raif.hangman_api.repository.UserRepository;
import com.raif.hangman_api.repository.UserStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserStatsRepository userStatsRepository;
    private final PasswordEncoder passwordEncoder;

    // ========== REGISTER ==========
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Username already taken");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        UserStats stats = new UserStats();
        stats.setUser(savedUser);
        userStatsRepository.save(stats);

        return new AuthResponse("Registration successful", savedUser.getUsername(), savedUser.getId());
    }

    // ========== LOGIN ==========
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid password");
        }

        return new AuthResponse("Login successful", user.getUsername(), user.getId());
    }
}