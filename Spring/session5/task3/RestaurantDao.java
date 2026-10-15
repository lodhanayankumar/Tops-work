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

 //insert
    public int insertRestaurant(Restaurant restaurant) {

        String sql = "INSERT INTO restaurants (name, cuisine, rating) "
                   + "VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                restaurant.getName(),
                restaurant.getCuisine(),
                restaurant.getRating());
    }
//update
    public int updateRestaurant(Restaurant restaurant) {

        String sql = "UPDATE restaurants "
                   + "SET name = ?, cuisine = ?, rating = ? "
                   + "WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                restaurant.getName(),
                restaurant.getCuisine(),
                restaurant.getRating(),
                restaurant.getId());
    }
//delete by ID
    public int deleteRestaurant(int id) {

        String sql = "DELETE FROM restaurants WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }
//select all restaurants
    public List<Restaurant> getAllRestaurants() {

        String sql = "SELECT id, name, cuisine, rating FROM restaurants";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("cuisine"),
                        rs.getDouble("rating")));
    }
//select by ID
    public Restaurant getRestaurantById(int id) {

        String sql = "SELECT id, name, cuisine, rating "
                   + "FROM restaurants WHERE id = ?";

        List<Restaurant> restaurants = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("cuisine"),
                        rs.getDouble("rating")),id);

        return restaurants.isEmpty() ? null : restaurants.get(0);
    }
}
