
package com.example.openaiintegration.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class MovieBotService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final String API_URL ="https://api.openai.com/v1/chat/completions";

    public String askMovieBot(String question) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

//request body
        Map<String, Object> requestBody = Map.of(
            "model", "gpt-5.4-mini",
            "messages", new Object[] {
                Map.of("role", "system",
                    "content", "You are a helpful movie expert. "
                       + "Answer movie-related questions."),
                Map.of("role", "user","content", question)});

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        JsonNode response = restTemplate.postForObject(API_URL,request,JsonNode.class);

        return response
            .path("choices").path(0).path("message").path("content").asText();
    }
}
