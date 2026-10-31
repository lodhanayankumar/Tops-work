
package com.example.openaiintegration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class OpenaiintegrationApplication
        implements CommandLineRunner {

    @Value("${openai.api.key:}")
    private String apiKey;

    public static void main(String[] args) {
        SpringApplication.run(
            OpenaiintegrationApplication.class, args);
    }

    @Override
    public void run(String... args) {

        if (apiKey != null && !apiKey.isBlank()) {
            System.out.println(
                "OpenAI API Key Configured Successful!");
        } else {
            System.out.println(
                "OpenAI API Key Missing!");
        }
    }
}
