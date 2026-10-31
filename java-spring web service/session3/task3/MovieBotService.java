
package com.example.openaiintegration.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class MovieBotService {

    @Value("${openai.api.key:}")
    private String apiKey;

    private final String API_URL ="https://api.openai.com/v1/chat/completions";

    public String askMovieBot(String question) {

        if (apiKey == null || apiKey.isBlank()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"OpenAI API key is missing. Please configure your API key.");
        }

        try {

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            Map<String, Object> requestBody = Map.of("model", "gpt-5.4-mini","messages", new Object[] {
                    Map.of("role", "system","content", "You are a helpful movie expert "+ "Answer movie-related questions."
                      ), Map.of("role", "user","content", question) });

            HttpEntity<Map<String, Object>> request =new HttpEntity<>(requestBody, headers);

            ResponseEntity<JsonNode> response =restTemplate.exchange( API_URL,HttpMethod.POST,request,JsonNode.class);

            if (response.getStatusCode().is2xxSuccessful()&& response.getBody() != null) {

                return response.getBody().path("choices").path(0).path("message").path("content").asText();
            }
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,"OpenAI returned an unsuccessful response");

        } catch (HttpStatusCodeException e) {

            if (e.getStatusCode().value() == 401) {
                throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "invalid OpenAI API keycheck your API key.");
            }

            if (e.getStatusCode().value() == 429) {
                throw new ResponseStatusException(
                    HttpStatus.TOO_MANY_REQUESTS,"OpenAI API quota exceeded or rate limit reached.");
            }

            throw new ResponseStatusException(
                HttpStatus.BAD_GATEWAY,"OpenAI API error. HTTP Status: " + e.getStatusCode().value());
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,"unable to connect to OpenAI API.");
        }
    }
}
