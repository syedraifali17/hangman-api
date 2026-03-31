package com.raif.hangman_api.exception;

// This exception is thrown when the request is invalid
// e.g. username already taken, game already active
// It will map to HTTP 400 Bad Request
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}