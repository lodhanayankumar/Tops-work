package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        MovieService service =
                context.getBean("movieService", MovieService.class);

        service.displayMovies();

        context.close();
    }
}
