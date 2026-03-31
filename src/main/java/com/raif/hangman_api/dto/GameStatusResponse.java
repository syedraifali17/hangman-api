package com.raif.hangman_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameStatusResponse {
    // This is what we send back to the user after starting a game
    // or when they request the current game status

    private Long sessionId;       // The ID of this game session
    private String maskedWord;    // e.g. "_ _ _ _ _ _ _ _" for elephant
    private int wordLength;       // How many letters the word has
    private int wrongGuesses;     // How many wrong guesses so far
    private int maxWrongGuesses;  // Always 6 — game over at 6
    private String guessedLetters; // e.g. "aeiou" — letters already tried
    private String status;        // "ACTIVE", "WON", or "LOST"
    private String hint1;         // Shown at 3 wrong guesses
    private String hint2;         // Shown at 5 wrong guesses
    private String category;      // e.g. "Animals" — shown from the start as a clue
}