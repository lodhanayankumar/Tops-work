package com.example.springjdbcproject;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringjdbcprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringjdbcprojectApplication.class, args);
    }

    @Bean
    CommandLineRunner testRestaurantDao(RestaurantDao dao) {
        return args -> {

// Insert
            Restaurant restaurant = new Restaurant(0, "Food Plaza", "Indian", 4.3);

            int inserted = dao.insertRestaurant(restaurant);
            System.out.println("insert rows: " + inserted);

//select all
            System.out.println("\n*All Restaurants");

            List<Restaurant> restaurants = dao.getAllRestaurants();

            for (Restaurant r : restaurants) {
                System.out.println( r.getId() + " | " + r.getName() + " | " +
                        r.getCuisine() + " | " + r.getRating());
            }

//suddenly add
            Restaurant saved = null;

            for (Restaurant r : restaurants) {
                if ("Food Plaza".equals(r.getName())) {
                    saved = r;
                }
            }

            if (saved != null) {

//update
                saved.setRating(4.8);
                saved.setCuisine("Gujarati");

                int updated = dao.updateRestaurant(saved);
                System.out.println("\nUpdated rows: " + updated);

//select by ID
                Restaurant updatedRestaurant =
                        dao.getRestaurantById(saved.getId());

                if (updatedRestaurant != null) {
                    System.out.println(
                            "Updated restaurant: "
                            + updatedRestaurant.getName()
                            + ", "
                            + updatedRestaurant.getCuisine()
                            + ", Rating: "
                            + updatedRestaurant.getRating());
                }

//delete
                int deleted = dao.deleteRestaurant(saved.getId());
                System.out.println("Deleted rows: " + deleted);
            }
        };
    }
}
