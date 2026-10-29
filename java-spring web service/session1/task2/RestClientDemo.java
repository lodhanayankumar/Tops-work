package com.example.restclient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RestClientDemo {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1").build();

        try (Response response = client.newCall(request).execute()) {

            System.out.println("HTTP rest client started");
            System.out.println("Status Code: " + response.code());

            if (response.isSuccessful() && response.body() != null) {
                System.out.println("response data:");
                System.out.println(response.body().string());
            } else {
                System.out.println("request failed.");
            }

        } catch (IOException e) {
            System.out.println("error while calling rest api.");
            e.printStackTrace();
        }
    }
}