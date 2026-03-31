package com.raif.hangman_api.service;

import com.raif.hangman_api.dto.GameStatusResponse;
import com.raif.hangman_api.dto.GuessRequest;
import com.raif.hangman_api.dto.GuessResponse;
import com.raif.hangman_api.dto.StartGameRequest;
import com.raif.hangman_api.entity.GameSession;
import com.raif.hangman_api.entity.GameSession.GameStatus;
import com.raif.hangman_api.entity.User;
import com.raif.hangman_api.entity.UserStats;
import com.raif.hangman_api.entity.Word;
import com.raif.hangman_api.exception.BadRequestException;
import com.raif.hangman_api.exception.ResourceNotFoundException;
import com.raif.hangman_api.repository.GameSessionRepository;
import com.raif.hangman_api.repository.UserRepository;
import com.raif.hangman_api.repository.UserStatsRepository;
import com.raif.hangman_api.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameSessionRepository gameSessionRepository;
    private final UserRepository userRepository;
    private final WordRepository wordRepository;
    private final UserStatsRepository userStatsRepository;

    // ========== START GAME ==========
    public GameStatusResponse startGame(StartGameRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        gameSessionRepository.findByUserAndStatus(user, GameStatus.ACTIVE)
                .ifPresent(existingSession -> {
                    throw new BadRequestException(
                            "You already have an active game. Finish it before starting a new one."
                    );
                });

        Word randomWord = wordRepository.findRandomWord();

        GameSession session = new GameSession();
        session.setUser(user);
        session.setWord(randomWord);
        session.setWrongGuesses(0);
        session.setGuessedLetters("");
        session.setStatus(GameStatus.ACTIVE);

        GameSession savedSession = gameSessionRepository.save(session);
        return buildGameStatusResponse(savedSession);
    }

    // ========== GET GAME STATUS ==========
    public GameStatusResponse getGameStatus(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        GameSession session = gameSessionRepository
                .findByUserAndStatus(user, GameStatus.ACTIVE)
                .orElseThrow(() -> new ResourceNotFoundException("No active game found. Start a new game first."));

        return buildGameStatusResponse(session);
    }

    // ========== PROCESS GUESS ==========
    public GuessResponse processGuess(GuessRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        GameSession session = gameSessionRepository
                .findByUserAndStatus(user, GameStatus.ACTIVE)
                .orElseThrow(() -> new ResourceNotFoundException("No active game found. Start a new game first."));

        char guess = request.getLetter().toLowerCase().charAt(0);
        String guessedLetters = session.getGuessedLetters();

        if (guessedLetters.indexOf(guess) >= 0) {
            return new GuessResponse(
                    "ALREADY_GUESSED",
                    buildMaskedWord(session.getWord().getWord(), guessedLetters),
                    session.getWrongGuesses(),
                    6,
                    guessedLetters,
                    session.getStatus().name(),
                    null,
                    null
            );
        }

        String updatedGuessedLetters = guessedLetters + guess;
        session.setGuessedLetters(updatedGuessedLetters);

        String word = session.getWord().getWord();
        String result;
        String hint = null;

        if (word.indexOf(guess) >= 0) {
            result = "CORRECT";
            String newMaskedWord = buildMaskedWord(word, updatedGuessedLetters);

            if (!newMaskedWord.contains("_")) {
                session.setStatus(GameStatus.WON);
                gameSessionRepository.save(session);
                updateStreak(user, true);

                return new GuessResponse(
                        "WIN",
                        newMaskedWord,
                        session.getWrongGuesses(),
                        6,
                        updatedGuessedLetters,
                        "WON",
                        null,
                        word
                );
            }

        } else {
            result = "WRONG";
            int newWrongGuesses = session.getWrongGuesses() + 1;
            session.setWrongGuesses(newWrongGuesses);

            if (newWrongGuesses >= 6) {
                session.setStatus(GameStatus.LOST);
                gameSessionRepository.save(session);
                updateStreak(user, false);

                return new GuessResponse(
                        "LOSS",
                        buildMaskedWord(word, updatedGuessedLetters),
                        newWrongGuesses,
                        6,
                        updatedGuessedLetters,
                        "LOST",
                        null,
                        word
                );
            }

            if (newWrongGuesses == 3) {
                hint = "HINT 1: " + session.getWord().getHint1();
            } else if (newWrongGuesses == 5) {
                hint = "HINT 2: " + session.getWord().getHint2();
            }
        }

        gameSessionRepository.save(session);

        return new GuessResponse(
                result,
                buildMaskedWord(word, updatedGuessedLetters),
                session.getWrongGuesses(),
                6,
                updatedGuessedLetters,
                session.getStatus().name(),
                hint,
                null
        );
    }

    // ========== UPDATE STREAK ==========
    private void updateStreak(User user, boolean won) {

        UserStats stats = userStatsRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("User stats not found"));

        if (won) {
            int newStreak = stats.getCurrentStreak() + 1;
            stats.setCurrentStreak(newStreak);
            if (newStreak > stats.getHighestStreak()) {
                stats.setHighestStreak(newStreak);
            }
        } else {
            stats.setCurrentStreak(0);
        }

        userStatsRepository.save(stats);
    }

    // ========== HELPER METHODS ==========
    public GameStatusResponse buildGameStatusResponse(GameSession session) {

        String word = session.getWord().getWord();
        String guessedLetters = session.getGuessedLetters();
        String maskedWord = buildMaskedWord(word, guessedLetters);

        return new GameStatusResponse(
                session.getId(),
                maskedWord,
                word.length(),
                session.getWrongGuesses(),
                6,
                guessedLetters,
                session.getStatus().name(),
                session.getWord().getHint1(),
                session.getWord().getHint2(),
                session.getWord().getCategory()
        );
    }

    public String buildMaskedWord(String word, String guessedLetters) {

        StringBuilder masked = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (guessedLetters.indexOf(c) >= 0) {
                masked.append(c);
            } else {
                masked.append('_');
            }
            if (i < word.length() - 1) {
                masked.append(' ');
            }
        }

        return masked.toString();
    }
}