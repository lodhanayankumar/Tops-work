package com.example.httpclient;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenWeatherClient {

    private static final String API_KEY = "enterf api key";

    public static void fetchWeather() {

        try {
            HttpClient client = HttpClient.newHttpClient();

            String city = URLEncoder.encode("Ahmedabad,IN",StandardCharsets.UTF_8);

            String url = "https://api.openweathermap.org/data/2.5/weather"+ "?q=" + city+ "&appid=" + API_KEY + "&units=metric";

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                ObjectMapper mapper = new ObjectMapper();

                JsonNode root = mapper.readTree(response.body());

                double temperature = root.get("main").get("temp").asDouble();

                String description = root.get("weather").get(0).get("description").asText();

                System.out.println("Ahmedabad Current Weather");
                System.out.println("-----------------------------");

                System.out.println("Temperature: "+ temperature + " °C");

                System.out.println("Weather description: "+ description);

            } else {
                System.out.println("api error: "+ response.statusCode());
                System.out.println(response.body());
            }

        } catch (Exception e) {
            System.out.println("error fetching weather data:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fetchWeather();
    }
}
