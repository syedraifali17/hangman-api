package com.raif.hangman_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "user_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne                           // One user has exactly one stats record
    @JoinColumn(name = "user_id")       // The foreign key column in the user_stats table
    private User user;

    private int currentStreak = 0;      // Resets to 0 on a loss
    private int highestStreak = 0;      // Only updates if currentStreak beats it
}