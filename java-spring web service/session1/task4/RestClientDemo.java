package com.example.restclient;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class RestClientDemo {

    private static final String api_url ="https://router.huggingface.co/hf-inference/models/openai-community/gpt2";

    private static final MediaType JSON =MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) {

        String prompt = "Once upon a time, a young programmer";

        generateText(prompt);
    }

    public static void generateText(String prompt) {

        String token = System.getenv("HF_API_TOKEN");

        if (token == null || token.isBlank()) {
            System.out.println("ERROR: Hugging Face token is missing.");
            System.out.println("Please configure HF_API_TOKEN in Run Configurations.");
            return;
        }

        OkHttpClient client = new OkHttpClient();

        JsonObject requestJson = new JsonObject();
        requestJson.addProperty("inputs", prompt);

        JsonObject parameters = new JsonObject();
        parameters.addProperty("max_new_tokens", 50);
        parameters.addProperty("return_full_text", false);

        requestJson.add("parameters", parameters);

        RequestBody body = RequestBody.create(requestJson.toString(), JSON);

        Request request = new Request.Builder().url(api_url)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json")
                .post(body).build();

        try (Response response = client.newCall(request).execute()) {

            int statusCode = response.code();

            System.out.println("Hugging Face Text Generation API");
            System.out.println("HTTP Status Code: " + statusCode);

            String responseData = response.body() != null
                    ? response.body().string(): "";

            if (response.isSuccessful()) {

                System.out.println("\nGenerated Text:");

                JsonElement result = JsonParser.parseString(responseData);

                if (result.isJsonArray()) {

                    JsonArray results = result.getAsJsonArray();

                    if (!results.isEmpty() && results.get(0).isJsonObject()) {

                        JsonObject firstResult =results.get(0).getAsJsonObject();

                        if (firstResult.has("generated_text")) {
                            System.out.println(firstResult.get("generated_text").getAsString());
                        } else {
                            System.out.println(responseData);
                        }

                    } else {
                        System.out.println(responseData);
                    }

                } else if (result.isJsonObject()) {
                      JsonObject object = result.getAsJsonObject();

                    if (object.has("generated_text")) {
                        System.out.println(object.get("generated_text").getAsString());
                    } else {
                        System.out.println(responseData);
                    }

                } else {
                    System.out.println(responseData);
                }

            } else {

                System.out.println("API REQUEST FAILED!");

                switch (statusCode) {
                    case 400:
                        System.out.println("Bad request. Check the prompt.");
                        break;

                    case 401:
                        System.out.println("Invalid or missing API token.");
                        break;

                    case 403:
                        System.out.println("Access forbidden. Check token permissions.");
                        break;

                    case 429:
                        System.out.println("Rate limit or usage quota exceeded.");
                        break;

                    case 503:
                        System.out.println("Model may be loading or temporarily unavailable.");
                        break;

                    default:
                        System.out.println("Unexpected error: " + statusCode);
                }

                System.out.println("Server response: " + responseData);
            }

        } catch (IOException e) {

            System.out.println("Network error while calling Hugging Face.");
            System.out.println("Details: " + e.getMessage());

        } catch (RuntimeException e) {

            System.out.println("Could not parse the API response.");
            System.out.println("Details: " + e.getMessage());
        }
    }
}