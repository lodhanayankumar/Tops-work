
package com.example.springjdbcproject;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDao {

    private final JdbcTemplate jdbc;

    private static final String insert =
                  "INSERT INTO restaurants (name,cuisine,rating) VALUES (?,?,?)";

    private static final String update =
                  "UPDATE restaurants SET name=?,cuisine=?,rating=? WHERE id=?";

    private static final String delete =
                   "DELETE FROM restaurants WHERE id=?";

    private static final String selectall =
                   "SELECT * FROM restaurants";

    private static final String selectone =
                   "SELECT * FROM restaurants WHERE id=?";

    private static final String select_above4 =
                   "SELECT * FROM restaurants WHERE rating>4";

    public RestaurantDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
//create
    public int insertRestaurant(Restaurant r) {
        return jdbc.update(insert,
            r.getName(), r.getCuisine(), r.getRating());
    }

 //update
    public int updateRestaurant(Restaurant r) {
        return jdbc.update(update,
            r.getName(), r.getCuisine(), r.getRating(), r.getId());
    }

//delete
    public int deleteRestaurant(int id) {
        return jdbc.update(delete, id);
    }

//all
    public List<Restaurant> getAllRestaurants() {
        return jdbc.query(selectall, (rs, row) ->
            new Restaurant(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("cuisine"),
                rs.getDouble("rating")
            )
        );
    }
//one accese
    public Restaurant getRestaurantById(int id) {
        List<Restaurant> list = jdbc.query(selectone, (rs, row) ->
            new Restaurant(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("cuisine"),
                rs.getDouble("rating")
            ), id);

        return list.isEmpty() ? null : list.get(0);
    }

//rating above 4
    public List<Restaurant> getRestaurantsAboveFour() {
        return jdbc.query(select_above4, (rs, row) ->
            new Restaurant(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("cuisine"),
                rs.getDouble("rating"))
        );
    }
}
