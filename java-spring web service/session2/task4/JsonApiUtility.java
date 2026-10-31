package com.example.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonApiUtility {

    public static <T> T fetchAndParseJson(String url, Class<T> valueType) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("HTTP Error: " + response.statusCode());
            }

        ObjectMapper mapper = new ObjectMapper();

        T result = mapper.readValue(response.body(), valueType);

        return result;
    }
}
