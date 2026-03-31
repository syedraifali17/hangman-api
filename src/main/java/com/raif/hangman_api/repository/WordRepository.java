package com.raif.hangman_api.repository;

import com.raif.hangman_api.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findByCategory(String category);

    @Query(value = "SELECT * FROM words ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
        // nativeQuery = true means this is real SQL, not JPQL
        // JPQL does not support RANDOM() directly in all databases
        // nativeQuery = true lets us write raw PostgreSQL SQL
        // ORDER BY RANDOM() shuffles all rows randomly then LIMIT 1 takes the first one
    Word findRandomWord();
}

