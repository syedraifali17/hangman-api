package com.raif.hangman_api.controller;

import com.raif.hangman_api.entity.Word;
import com.raif.hangman_api.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    @GetMapping("/random")
    // Handles GET requests to /api/words/random
    // Returns a random word from the database
    public ResponseEntity<Word> getRandomWord() {
        Word word = wordService.getRandomWord();
        return ResponseEntity.ok(word);
    }

    @GetMapping("/category/{category}")
    // {category} is a path variable — it captures whatever the user puts in the URL
    // e.g. GET /api/words/category/Animals
    // @PathVariable pulls that value out of the URL and passes it to the method
    public ResponseEntity<List<Word>> getByCategory(@PathVariable String category) {
        List<Word> words = wordService.getWordsByCategory(category);
        return ResponseEntity.ok(words);
    }

    @GetMapping("/count")
    // Simple endpoint to verify how many words are in the database
    public ResponseEntity<Long> getWordCount() {
        return ResponseEntity.ok(wordService.getTotalWordCount());
    }
}