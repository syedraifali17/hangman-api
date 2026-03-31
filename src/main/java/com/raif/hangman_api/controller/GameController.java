package com.raif.hangman_api.controller;

import com.raif.hangman_api.dto.GameStatusResponse;
import com.raif.hangman_api.dto.GuessRequest;
import com.raif.hangman_api.dto.GuessResponse;
import com.raif.hangman_api.dto.StartGameRequest;
import com.raif.hangman_api.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/start")
    // Handles POST /api/game/start
    // The user sends their userId in the request body
    public ResponseEntity<GameStatusResponse> startGame(
            @Valid @RequestBody StartGameRequest request) {

        GameStatusResponse response = gameService.startGame(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        // 201 CREATED because we are creating a new game session in the database
    }

    @GetMapping("/status")
    // Handles GET /api/game/status?userId=1
    // The userId comes from the URL query parameter not the body
    // because GET requests should not have a body
    public ResponseEntity<GameStatusResponse> getGameStatus(
            @RequestParam Long userId) {
        // @RequestParam pulls the value from the URL query string
        // e.g. /api/game/status?userId=1 → userId = 1

        GameStatusResponse response = gameService.getGameStatus(userId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/guess")
    // Handles POST /api/game/guess
    // The user sends their userId and the letter they want to guess
    public ResponseEntity<GuessResponse> guess(
            @Valid @RequestBody GuessRequest request) {

        GuessResponse response = gameService.processGuess(request);
        return ResponseEntity.ok(response);
    }
}