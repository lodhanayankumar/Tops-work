package com.example;

public class MovieService {

    private MovieRepository movieRepository;

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void displayMovies() {
    	movieRepository.getMovies();
        System.out.println("MovieService is working.");
    }
}