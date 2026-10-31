package com.example.aimeal.service;

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

    @Value("${openai.api.key:}")
    private String apiKey;

    private final ObjectMapper mapper;
    private final HttpClient client;

    public AIRecommendationService(ObjectMapper mapper) {
        this.mapper = mapper;
        this.client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(20)).build();
    }

    public String getRecommendation(String preference) throws IOException, InterruptedException {

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("OpenAI API key is missing. Set OPENAI_API_KEY and restart the application.");
        }

        ObjectNode requestBody = mapper.createObjectNode();

        requestBody.put("model", "gpt-4o-mini");

        ArrayNode messages = requestBody.putArray("messages");

        ObjectNode systemMessage = messages.addObject();
        systemMessage.put("role", "system");
        systemMessage.put("content","You are a helpful food and meal recommendation assistant. " +
                "Suggest one suitable meal with a short explanation.");

        ObjectNode userMessage = messages.addObject();
        userMessage.put("role", "user");
        userMessage.put("content", "Suggest a meal based on this dietary preference: " + preference);

        String jsonBody = mapper.writeValueAsString(requestBody);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey).timeout(Duration.ofSeconds(60))
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new IOException(
                    "OpenAI API returned HTTP " + response.statusCode()
                    + ": " + response.body());
        }

        JsonNode responseJson = mapper.readTree(response.body());

        JsonNode contentNode = responseJson
                .path("choices").path(0).path("message").path("content");

        if (contentNode.isMissingNode()|| contentNode.isNull()|| !contentNode.isTextual()) {
            throw new IOException("OpenAI response did not contain assistant message content");
        }

        return contentNode.asText();
    }
}