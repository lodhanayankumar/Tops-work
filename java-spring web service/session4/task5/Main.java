
package com.example;

import java.util.Map;
import java.util.Scanner;

import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your favorite music genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter your current mood: ");
        String mood = sc.nextLine();

        System.out.print("Enter your favorite artist: ");
        String artist = sc.nextLine();

        PromptTemplate template = PromptTemplate.from("""
                You are a Spotify-style music recommendation assistant.

                The user's music preferences are:

                Favorite Genre: {{genre}}
                Current Mood: {{mood}}
                Favorite Artist: {{artist}}

                Recommend 5 songs based on these preferences.

                For each recommendation, provide:
                1. Song title
                2. Artist name
                3. Music genre
                4. A short reason for recommending the song.

                Make the recommendations personalized and easy to understand.
                Do not invent songs or artists.""");

        Prompt prompt = template.apply( Map.of("genre", genre, "mood", mood,"artist", artist));

        System.out.println("\n----Spotify Generated promt--");
        System.out.println(prompt.text());

        sc.close();
    }
}
