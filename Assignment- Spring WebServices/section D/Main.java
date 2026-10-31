
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

public class Main {

    // OpenAI Chat Completions API URL
    private static final String API_URL =
            "https://api.openai.com/v1/chat/completions";

    // OpenAI model
    private static final String MODEL = "gpt-4o-mini";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read API key from environment variable
        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("Error: OpenAI API key is missing.");
            System.out.println("Please configure OPENAI_API_KEY.");
            scanner.close();
            return;
        }

        // Create Java HttpClient
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        // Create Jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("===== OpenAI Console Chatbot =====");
        System.out.println("Type 'exit' to quit.\n");

        // Repeat until user types exit
        while (true) {

            System.out.print("Enter your prompt: ");
            String userPrompt = scanner.nextLine();

            // Check exit command
            if (userPrompt.trim().equalsIgnoreCase("exit")) {
                System.out.println("Chatbot closed. Goodbye!");
                break;
            }

            // Do not send empty prompts
            if (userPrompt.isBlank()) {
                System.out.println("Please enter a prompt.\n");
                continue;
            }

            try {

                // Step 1: Create JSON request body using Jackson
                ObjectNode requestBody = mapper.createObjectNode();

                requestBody.put("model", MODEL);

                ArrayNode messages = requestBody.putArray("messages");

                ObjectNode message = messages.addObject();
                message.put("role", "user");
                message.put("content", userPrompt);

                // Convert JSON object into a string
                String jsonBody =
                        mapper.writeValueAsString(requestBody);

                // Step 2: Build HTTP POST request
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(API_URL))
                        .timeout(Duration.ofSeconds(60))
                        .header("Authorization", "Bearer " + apiKey)
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                        .build();

                // Step 3: Send request to OpenAI
                HttpResponse<String> response = client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

                // Step 4: Check HTTP response status
                if (response.statusCode() < 200 ||
                        response.statusCode() >= 300) {

                    System.out.println(
                            "OpenAI API Error (HTTP "
                            + response.statusCode() + ")"
                    );

                    // Try to display the API error message
                    JsonNode errorRoot =
                            mapper.readTree(response.body());

                    String errorMessage = errorRoot
                            .path("error")
                            .path("message")
                            .asText("Request failed. Please try again.");

                    System.out.println(errorMessage + "\n");
                    continue;
                }

                // Step 5: Parse successful JSON response
                JsonNode root = mapper.readTree(response.body());

                // Extract choices[0].message.content
                JsonNode choices = root.path("choices");

                if (!choices.isArray() || choices.isEmpty()) {
                    System.out.println(
                            "No assistant answer found.\n"
                    );
                    continue;
                }

                JsonNode content = choices.get(0)
                        .path("message")
                        .path("content");

                if (!content.isTextual()) {
                    System.out.println(
                            "Assistant reply is missing or invalid.\n"
                    );
                    continue;
                }

                // Step 6: Print only assistant reply text
                System.out.println("\n" + content.asText() + "\n");

            } catch (IOException e) {

                System.out.println(
                        "Network or JSON error: " + e.getMessage() + "\n"
                );

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println("Request was interrupted.");
                break;

            } catch (Exception e) {

                System.out.println(
                        "Unexpected error: " + e.getMessage() + "\n"
                );
            }
        }

        scanner.close();
    }
}
