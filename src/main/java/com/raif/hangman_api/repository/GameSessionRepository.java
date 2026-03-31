package com.raif.hangman_api.repository;

import com.raif.hangman_api.entity.GameSession;
import com.raif.hangman_api.entity.GameSession.GameStatus;
import com.raif.hangman_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {

    // Find the active game for a specific user
    // Spring generates: SELECT * FROM game_sessions WHERE user_id = ? AND status = ?
    Optional<GameSession> findByUserAndStatus(User user, GameStatus status);
}