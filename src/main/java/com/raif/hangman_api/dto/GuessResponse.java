package com.raif.hangman_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuessResponse {

    private String result;
    // "CORRECT", "WRONG", "ALREADY_GUESSED", "WIN", "LOSS"

    private String maskedWord;
    // Current state of the word e.g. "_ _ e _ _ _ _ _"

    private int wrongGuesses;
    // How many wrong guesses so far

    private int maxWrongGuesses;
    // Always 6

    private String guessedLetters;
    // All letters tried so far e.g. "aeiou"

    private String status;
    // "ACTIVE", "WON", "LOST"

    private String hint;
    // Null normally, populated at 3 and 5 wrong guesses

    private String actualWord;
    // Null during active game, revealed on win or loss
}