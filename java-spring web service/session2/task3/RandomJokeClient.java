
package com.example.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RandomJokeClient {

    public static void main(String[] args) {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://official-joke-api.appspot.com/random_joke")).GET().build();

            HttpResponse<String> response = client.send(
                    request,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                ObjectMapper mapper = new ObjectMapper();

                JsonNode root = mapper.readTree(response.body());

                String setup = root.get("setup").asText();
                String punchline = root.get("punchline").asText();

                System.out.println("Random Joke");
                System.out.println("-------------------------");
                System.out.println("Setup: " + setup);
                System.out.println("Punchline: " + punchline);

            } else {
                System.out.println("API rror: "+ response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
