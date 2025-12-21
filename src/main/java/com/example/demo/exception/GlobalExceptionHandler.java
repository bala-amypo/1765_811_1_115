package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle BadRequestException
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now()));
    }

    // Handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now()));
    }

    // Fallback for other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now()));
    }

    // Inner class to structure response
    static class ExceptionResponse {
        private String message;
        private int status;
        private LocalDateTime timestamp;

        public ExceptionResponse(String message, int status, LocalDateTime timestamp) {
            this.message = message;
            this.status = status;
            this.timestamp = timestamp;
        }

        // Getters
        public String getMessage() { return message; }
        public int getStatus() { return status; }
        public LocalDateTime getTimestamp() { return timestamp; }
    }
}
