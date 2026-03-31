package com.raif.hangman_api.service;

import com.raif.hangman_api.entity.Word;
import com.raif.hangman_api.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    public Word getRandomWord() {
        // Calls our custom @Query in WordRepository
        // which runs: SELECT w FROM Word w ORDER BY RANDOM() LIMIT 1
        // Every call returns a different random word from the database
        return wordRepository.findRandomWord();
    }

    public List<Word> getWordsByCategory(String category) {
        // Returns all words from a specific category
        // e.g. getWordsByCategory("Animals") returns elephant, penguin, dolphin etc.
        return wordRepository.findByCategory(category);
    }

    public long getTotalWordCount() {
        // countBy() is provided free by JpaRepository
        // runs: SELECT COUNT(*) FROM words
        return wordRepository.count();
    }
}