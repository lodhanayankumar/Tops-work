package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TaskDChatClient {

    private static final String API_URL ="https://api.openai.com/v1/chat/completions";

    private static final String MODEL = "gpt-4o-mini";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("error: OpenAI API key is missing.");
            sc.close();
            return;
        }

        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(20)).build();

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("===== OpenAI Console Chatbot =====");
        System.out.println("'exit' to quit.\n");

        while (true) {

            System.out.print("enter your prompt: ");
            String prompt = sc.nextLine();

            if (prompt.trim().equalsIgnoreCase("exit")) {
                System.out.println("Chatbot closed. Goodbye!");
                break;
            }
            if (prompt.isBlank()) {
                System.out.println("enter a valid prompt.\n");
                continue;
            }

            try {

                ObjectNode requestBody = mapper.createObjectNode();

                requestBody.put("model", MODEL);

                ArrayNode messages = requestBody.putArray("messages");

                ObjectNode userMessage = messages.addObject();

                userMessage.put("role", "user");
                userMessage.put("content", prompt);

                String jsonBody = mapper.writeValueAsString(requestBody);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(API_URL)).timeout(Duration.ofSeconds(60))
                        .header("Authorization", "Bearer " + apiKey)
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

                HttpResponse<String> response = client.send( request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() < 200 || response.statusCode() >= 300) {

                    System.out.println("API request failed. HTTP Status: " + response.statusCode());
                    continue;
                }

                JsonNode root = mapper.readTree(response.body());

                JsonNode choices = root.path("choices");

                if (!choices.isArray() || choices.isEmpty()) {
                    System.out.println("Error: No answer found in API response.");
                    continue;
                }

                JsonNode content = choices.get(0).path("message").path("content");

                if (content.isMissingNode() ||content.isNull() ||!content.isTextual() ||content.asText().isBlank()) {

                    System.out.println("Error: Assistant reply is empty.");
                    continue;
                }

                System.out.println("\n" + content.asText() + "\n");

            } catch (IOException e) {
                System.out.println("Network or JSON error: " + e.getMessage());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Request was interrupted.");
                break;

            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
