
package com.example;

import java.util.Scanner;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("Error: OpenAI API key is missing!");
            System.out.println("configure OPENAI_API_KEY.");
            sc.close();
            return;
        }

        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey).modelName("gpt-4o-mini").build();

        System.out.print("Enter your question: ");
        String question = sc.nextLine();

        try {
            String answer = model.chat("you are a helpful customer support assistant" +
                    "give simple, clear and step-by-step answers.\n\n" +"User question: " + question);

            System.out.println("\n**AI RESPONSE***");
            System.out.println("User question: " + question);
            System.out.println("\nAI Answer:");
            System.out.println(answer);

        } catch (Exception e) {
            System.out.println("Error while contacting OpenAI:");
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
