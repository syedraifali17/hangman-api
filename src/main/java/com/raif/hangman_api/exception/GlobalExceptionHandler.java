package com.raif.hangman_api.exception;

import com.raif.hangman_api.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
// @RestControllerAdvice means: this class watches ALL controllers
// Whenever any controller method throws an exception,
// Spring looks here first to see if there is a handler for it
// Think of it as a safety net around your entire API
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    // @ExceptionHandler tells Spring: when THIS specific exception type is thrown
    // anywhere in the app, run THIS method to handle it
    public ResponseEntity<ErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {
        // HttpServletRequest gives us access to the request details
        // We use it to get the URL path that caused the error

        ErrorResponse error = new ErrorResponse(
                404,
                "Not Found",
                ex.getMessage(),
                // ex.getMessage() returns the message we passed to the exception
                // e.g. "User not found" or "No active game found"
                request.getRequestURI()
                // e.g. "/api/game/status"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        // Return HTTP 404 with our clean error JSON
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(
            BadRequestException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                400,
                "Bad Request",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        // Return HTTP 400 with our clean error JSON
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    // This handles validation failures — when @Valid fails on a DTO
    // e.g. someone sends an empty username or a password that is too short
    // Spring throws MethodArgumentNotValidException automatically
    public ResponseEntity<ErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        // ex.getBindingResult().getFieldErrors() gives us a list of all
        // fields that failed validation and why
        String message = ex.getBindingResult()
                .getFieldErrors()
                // Get all field errors as a list
                .stream()
                // Convert to stream so we can process them
                .map(FieldError::getDefaultMessage)
                // For each error, get the message we wrote in the DTO
                // e.g. "Username cannot be empty" or "Password must be at least 6 characters"
                .collect(Collectors.joining(", "));
        // Join all messages with a comma if there are multiple errors
        // e.g. "Username cannot be empty, Password must be at least 6 characters"

        ErrorResponse error = new ErrorResponse(
                400,
                "Validation Failed",
                message,
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    // This is the catch-all handler
    // If ANY other exception is thrown that we haven't specifically handled,
    // this method catches it and returns a 500 Internal Server Error
    // This prevents Spring from returning its ugly default error page
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                500,
                "Internal Server Error",
                "An unexpected error occurred",
                // We don't expose the actual error message for security
                // The real error is still printed in the server logs
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}