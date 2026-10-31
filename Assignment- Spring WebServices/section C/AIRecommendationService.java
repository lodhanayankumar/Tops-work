
package com.example.smartfooddelivery.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class AIRecommendationService {

    private static final String API_URL =
            "https://api.openai.com/v1/chat/completions";

    @Value("${openai.api.key:}")
    private String apiKey;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public AIRecommendationService() {

        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        this.objectMapper = new ObjectMapper();
    }

    public String getRecommendation(String preference)
            throws IOException, InterruptedException {

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "OpenAI API key is not configured."
            );
        }

        // Create JSON request body
        ObjectNode requestBody =
                objectMapper.createObjectNode();

        requestBody.put("model", "gpt-4o-mini");

        ArrayNode messages = requestBody.putArray("messages");

        ObjectNode message = messages.addObject();

        message.put("role", "user");

        message.put("content",
                "Suggest a healthy and delicious meal for this "
                + "dietary preference: " + preference
                + ". Give the meal name, ingredients and preparation steps. "
                + "Keep the answer simple."
        );

        String jsonBody =objectMapper.writeValueAsString(requestBody);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL)).timeout(Duration.ofSeconds(60))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() < 200 ||response.statusCode() >= 300) {

            throw new IOException("OpenAI API returned HTTP status "+ response.statusCode());
        }

        JsonNode root =objectMapper.readTree(response.body());

        JsonNode choices = root.path("choices");

        if (!choices.isArray() || choices.isEmpty()) {
            throw new IOException("No recommendation received from OpenAI.");
        }

        JsonNode content = choices.get(0).path("message").path("content");

        if (!content.isTextual() || content.asText().isBlank()) {
            throw new IOException("OpenAI returned an empty recommendation.");
        }

        return content.asText();
    }
}
