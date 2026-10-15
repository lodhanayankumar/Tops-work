package com.example.springjdbcproject;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDao {

    private final JdbcTemplate jdbcTemplate;

    // Constructor injection
    public RestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

// Fetch restaurants with rating above 4.0
 public List<Restaurant> getRestaurantsAboveFour() {

     String sql = "SELECT id, name, cuisine, rating "
                + "FROM restaurants WHERE rating > ?";

     return jdbcTemplate.query(
             sql,
             (rs, rowNum) -> new Restaurant(
                     rs.getInt("id"),
                     rs.getString("name"),
                     rs.getString("cuisine"),
                     rs.getDouble("rating")
             ), 4.0);
 }
 }
