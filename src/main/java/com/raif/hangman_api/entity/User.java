package com.raif.hangman_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity                          // Tells Spring: "this class is a database table"
@Table(name = "users")           // The actual table name in PostgreSQL
@Data                            // Lombok: auto-generates getters, setters, toString
@NoArgsConstructor               // Lombok: generates a constructor with no arguments
@AllArgsConstructor              // Lombok: generates a constructor with all arguments
public class User {

    @Id                                                    // This field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Database auto-increments it (1, 2, 3...)
    private Long id;

    @Column(nullable = false, unique = true)   // Cannot be empty, must be unique across all rows
    private String username;

    @Column(nullable = false)                  // Cannot be empty
    private String password;                   // Will store BCrypt hashed password, never plain text
}