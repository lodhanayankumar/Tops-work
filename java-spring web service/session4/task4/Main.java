
package com.example;

import java.util.List;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {

    public static void main(String[] args) {

        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("Error: OpenAI API key is missing!");
            return;
        }

        OpenAiChatModel model = OpenAiChatModel.builder().apiKey(apiKey).modelName("gpt-4o-mini").build();

        List<String> faqQuestions = List.of(
                "How to use Paytm wallet?",
                "How to book a movie on BookMyShow?",
                "How do I get a refund on Flipkart?",
                "How can I order food online?",
                "How do I create an account on Amazon?");

        for (String question : faqQuestions) {

            System.out.println("\n=============");
            System.out.println("question: " + question);

            try {
                String answer = model.chat(
                        "You are a helpful customer support assistant. " +
                        "Answer the following question in simple English " +
                        "using clear steps:\n" + question);

                System.out.println("\nAI Answer:");
                System.out.println(answer);

            } catch (Exception e) {
                System.out.println("Unable to get answer: " + e.getMessage());
            }
        }

        System.out.println("\nAll questions processed");
    }
}
