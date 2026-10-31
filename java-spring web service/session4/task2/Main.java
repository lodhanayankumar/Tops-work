
package com.example;

import java.util.Map;
import java.util.Scanner;

import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your food craving: ");
        String craving = sc.nextLine();

//reusable prompt template
        PromptTemplate template = PromptTemplate.from("""
                You are a Zomato-style restaurant recommendation assistant.

                The customer has the following food craving:
                {{craving}}

                Suggest 3 suitable restaurant or food options.

                For each suggestion, provide:
                1. Restaurant name (sample name is acceptable).
                2. Food or dish name.
                3. Short description.
                4. Estimated price in Indian Rupees.

                Make the suggestions attractive and easy to understand.
                """);

//insert craving template
        Prompt prompt = template.apply(Map.of("craving", craving));

        System.out.println("\ngenerated promat");
        System.out.println(prompt.text());

        sc.close();
    }
}
