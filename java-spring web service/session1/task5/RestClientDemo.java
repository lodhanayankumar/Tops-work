package com.example.restclient;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class RestClientDemo {

    private static final String apiuel =
            "https://aiplatform.googleapis.com/v1/projects/";

    private static final MediaType JSON =
            MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) {

        /*
         * AI TOOL DOCUMENTATION
         *
         * AI tool used: ChatGPT
         *
         * Prompt given to ChatGPT:
         * "Write Java code using OkHttp to call the Google Vertex AI
         * REST API for text generation. Send a POST request with a
         * text prompt, authenticate using a Google Cloud access token,
         * parse the JSON response, and print the generated text.
         * Include error handling and document how the AI-generated
         * suggestion was used."
         *
         * How I used the AI output:
         * I used ChatGPT's suggestion to create the HTTP POST request,
         * configure the Authorization Bearer token, construct the
         * JSON request body, and parse the generated text from the
         * Vertex AI response. I also added error handling.
         */

        String prompt ="Explain artificial intelligence in simple English "
                + "with three real-world examples.";
           generateText(prompt);
    }

    public static void generateText(String prompt) {

        String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");

        String location = System.getenv("GOOGLE_CLOUD_LOCATION");

        String accessToken =System.getenv("GOOGLE_ACCESS_TOKEN");

        if (projectId == null || projectId.isBlank()
                || location == null || location.isBlank()
                || accessToken == null || accessToken.isBlank()) {

            System.out.println("ERROR: Google Cloud configuration is missing.");

            System.out.println(
                    "Configure GOOGLE_CLOUD_PROJECT, "
                    + "GOOGLE_CLOUD_LOCATION and GOOGLE_ACCESS_TOKEN.");

            return;
        }

        String endpoint = apiuel
                + projectId+ "/locations/"+ location
                + "/publishers/google/models/gemini-2.5-flash:generateContent";

        // Build the JSON request
        JsonObject requestJson = new JsonObject();

        JsonArray contents = new JsonArray();
        JsonObject content = new JsonObject();
        JsonArray parts = new JsonArray();
        JsonObject textPart = new JsonObject();

        textPart.addProperty("text", prompt);
        parts.add(textPart);

        content.add("parts", parts);
        contents.add(content);

        requestJson.add("contents", contents);

        JsonObject generationConfig = new JsonObject();

        generationConfig.addProperty("maxOutputTokens", 200);

        requestJson.add("generationConfig", generationConfig);

        RequestBody body = RequestBody.create(requestJson.toString(), JSON);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(endpoint)
                .addHeader("Authorization","Bearer " + accessToken)
                .addHeader("Content-Type","application/json").post(body).build();

        try (Response response = client.newCall(request).execute()) {

            int statusCode = response.code();

            String responseData = response.body() != null
                    ? response.body().string(): "";

            System.out.println("Vertex AI HTTP Status: " + statusCode);

            if (response.isSuccessful()) {
                JsonObject responseJson =
                        JsonParser.parseString(responseData).getAsJsonObject();

                if (responseJson.has("candidates")) {
                    JsonArray candidates = responseJson.getAsJsonArray("candidates");

                    if (!candidates.isEmpty()) {

                        JsonObject firstCandidate = candidates.get(0).getAsJsonObject();

                        JsonObject responseContent = firstCandidate.getAsJsonObject("content");

                        JsonArray responseParts = responseContent.getAsJsonArray("parts");

                        System.out.println("\nGenerated Text:");

                        for (int i = 0; i < responseParts.size(); i++) {

                            JsonObject part =responseParts.get(i).getAsJsonObject();

                            if (part.has("text")) {
                                System.out.println(part.get("text").getAsString());
                            }
                        }
                    } else {
                        System.out.println("No text-generation candidates returned.");
                    }
                } else {
                    System.out.println("No candidates found in the API response.");
                    System.out.println(responseData);
                }

            } else {
                System.out.println("Vertex AI request failed.");

                switch (statusCode) {

                    case 400:
                        System.out.println("Bad request. Check the model and JSON.");
                        break;

                    case 401:
                        System.out.println("Authentication failed. Refresh the access token.");
                        break;

                    case 403:
                        System.out.println("Permission denied. Check API access and IAM roles.");
                        break;

                    case 404:
                        System.out.println("Model or endpoint not found.");
                        break;

                    case 429:
                        System.out.println("Quota or rate limit exceeded.");
                        break;

                    default:
                        System.out.println("HTTP error: " + statusCode);
                }

                System.out.println("Server response: " + responseData);
            }

        } catch (IOException e) {
            System.out.println("Network error while calling Vertex AI.");

            System.out.println(e.getMessage());

        } catch (RuntimeException e) {
            System.out.println("Error processing the Vertex AI response");

            System.out.println(e.getMessage());
        }
    }
}