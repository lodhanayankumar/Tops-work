package com.example.userprofileservice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlaylistNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePlaylistNotFound(
            PlaylistNotFoundException exception) {

        Map<String, String> response = Map.of(
                "message", "playlist not found"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
