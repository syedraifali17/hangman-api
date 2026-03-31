package com.raif.hangman_api.exception;

// This exception is thrown when something is not found in the database
// e.g. user not found, active game not found
// It will map to HTTP 404 Not Found
public class ResourceNotFoundException extends RuntimeException {
    // extends RuntimeException means this is an unchecked exception
    // Unchecked exceptions do NOT need to be declared with "throws" everywhere
    // They bubble up automatically until something catches them

    public ResourceNotFoundException(String message) {
        super(message);
        // super(message) passes the message to RuntimeException's constructor
        // This is what you see when you print the exception
    }
}