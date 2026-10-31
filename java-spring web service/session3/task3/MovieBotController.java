
package com.example.openaiintegration.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import com.example.openaiintegration.dto.QuestionRequest;
import com.example.openaiintegration.service.MovieBotService;

@RestController
public class MovieBotController {

    @Autowired
    private MovieBotService movieBotService;

    @PostMapping("/askMovieBot")
    public ResponseEntity<?> askMovieBot(@RequestBody QuestionRequest request) {

        try {
            if (request.getQuestion() == null ||request.getQuestion().isBlank()) {

                return ResponseEntity.badRequest().body(Map.of("error", "Question cannot be empty"));
            }

// call openai 
            String answer = movieBotService.askMovieBot(
                request.getQuestion());

            return ResponseEntity.ok(Map.of("answer", answer));

        } catch (ResponseStatusException e) {

            return ResponseEntity.status(e.getStatusCode())
                .body(Map.of("error", e.getReason() == null
                ? "OpenAI request failed": e.getReason()));
        }
    }
}
