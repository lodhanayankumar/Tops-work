package com.example.restclient;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class RestClientDemo {

    private static final String api_url ="https://api.openai.com/v1/responses";

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) {

        String prompt ="suggest 3 creative Instagram captions for a food photo.";

        sendPostRequest(prompt);
    }

    public static void sendPostRequest(String prompt) {

//read the api
        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("ERROR: OpenAI API key is missing.");
            System.out.println("please configure OPENAI_API_KEY in run configurations.");
            return;
        }

        OkHttpClient client = new OkHttpClient();

        String json = "{"+ "\"model\":\"gpt-4.1-mini\","
                + "\"input\":\"" + escapeJson(prompt) + "\""+ "}";

        RequestBody body = RequestBody.create(json, JSON);
        
        Request request = new Request.Builder().url(api_url)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .post(body).build();

        try (Response response = client.newCall(request).execute()) {

            int statusCode = response.code();

            System.out.println("HTTP Status Code: " + statusCode);

            String responseBody = response.body() != null
                    ? response.body().string(): "";

            if (statusCode == 200) {

                System.out.println("SUCCESS: API request completed.");
                System.out.println("API Response:");
                System.out.println(responseBody);

            } else {

//print error message
                System.out.println("API REQUEST FAILED!");

                switch (statusCode) {

                    case 400:
                        System.out.println("Error: Bad request. Check the model name "
                                + "and request parameters.");
                        break;

                    case 401:
                        System.out.println("Error: Invalid or missing API key. "
                                + "Check OPENAI_API_KEY.");
                        break;

                    case 403:
                        System.out.println("Error: Access forbidden. Check your "
                                + "API permissions and organization access.");
                        break;

                    case 404:
                        System.out.println("Error: API endpoint or resource not found.");
                        break;

                    case 429:
                        System.out.println("Error: Rate limit exceeded or API quota "
                                + "exhausted. Check your usage limits and billing.");
                        break;

                    default:
                        if (statusCode >= 500 && statusCode <= 599) {
                            System.out.println("Error: OpenAI server error. "
                                    + "Try again later.");
                        } else {
                            System.out.println("Error: Unexpected HTTP status code.");
                        }
                        break;
                }

                System.out.println("Server response:");
                System.out.println(responseBody);
            }

        } catch (IOException e) {

            System.out.println("NETWORK ERROR!");
            System.out.println("Could not communicate with the OpenAI API.");
            System.out.println("Check your internet connection and try again.");
            System.out.println("Details: " + e.getMessage());
        }
    }

    // Escape special characters in JSON strings
    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}