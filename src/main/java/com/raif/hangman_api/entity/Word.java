package com.raif.hangman_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "words")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word;        // The actual word to guess e.g. "elephant"

    @Column(nullable = false)
    private String hint1;       // First hint, shown at 3 wrong guesses

    @Column(nullable = false)
    private String hint2;       // Second hint, shown at 5 wrong guesses

    @Column(nullable = false)
    private String category;    // e.g. "Animals", "Food", "Technology"
}