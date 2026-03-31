package com.raif.hangman_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "game_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne                          // Many game sessions can belong to one user
    @JoinColumn(name = "user_id")       // Foreign key: which user owns this session
    private com.raif.hangman_api.entity.User user;

    @ManyToOne                          // Many game sessions can use the same word
    @JoinColumn(name = "word_id")       // Foreign key: which word is being guessed
    private com.raif.hangman_api.entity.Word word;

    private int wrongGuesses = 0;       // Counts wrong guesses, max 6

    @Column(length = 26)
    private String guessedLetters = ""; // Stores guessed letters as a string e.g. "aeiou"

    @Enumerated(EnumType.STRING)        // Stores the enum name as text in DB ("ACTIVE" not 0)
    private GameStatus status = GameStatus.ACTIVE;

    // Enum defined inside the entity since it's only used here
    public enum GameStatus {
        ACTIVE, WON, LOST
    }
}