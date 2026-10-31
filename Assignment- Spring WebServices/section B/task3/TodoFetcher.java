package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoFetcher {

    public static void main(String[] args) {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                    .GET().build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("API request failed!");
                System.out.println("Status Code: " + response.statusCode());
                return;
            }

//JSON response
            String jsonResponse = response.body();

            System.out.println("Raw JSON Response:");
            System.out.println(jsonResponse);

//Jackson ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

//JSON into Todo object
            Todo todo = mapper.readValue(jsonResponse, Todo.class);

            System.out.println("\n========== TODO DETAILS ==========");

            System.out.println("User ID   : " + todo.getUserId());
            System.out.println("Todo ID   : " + todo.getId());
            System.out.println("Title     : " + todo.getTitle());
            System.out.println("Completed : " + todo.isCompleted());

            System.out.println("==================================");

        } catch (Exception e) {

            System.out.println("Error occurred while fetching TODO data.");
            e.printStackTrace();
        }
    }
}