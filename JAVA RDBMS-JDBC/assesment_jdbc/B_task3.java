/*Task 3: JDBC Order Logger with PreparedStatement
Write a Java program that connects to MySQL and performs INSERT and SELECT operations on
a food_orders table using PreparedStatement throughout.
*Establish a JDBC connection using DriverManager.getConnection(); define DB_URL, DB_USER,
and DB_PASSWORD as static final constants at the top of the class.
*Implement insertOrder(String customerId, String restaurantName, double amount) using a
PreparedStatement that inserts one row into food_orders and returns the auto-generated
order ID from Statement.RETURN_GENERATED_KEYS.
*Implement getOrdersByCustomer(String customerId) using a parameterised
PreparedStatement SELECT that returns an ArrayList<String> where each entry is formatted as:
'ORDER#<id> | <restaurant> | Rs.<amount>'.
*Manage all JDBC resources — Connection, PreparedStatement, and ResultSet — with
try-with-resources so they are closed automatically even if an exception is thrown.*/
package assesment;

import java.sql.*;
import java.util.ArrayList;

public class B_task3 {
    // Database Constants
    static final String DB_URL = "jdbc:mysql://localhost:3306/fooddb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "Nayan@2001";
    // Insert Order
    public static int insertOrder(String customerId, String restaurantName, double amount) {

        String sql = "INSERT INTO food_orders(customer_id, restaurant_name, amount) VALUES(?,?,?)";

        try (
                Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, customerId);
            ps.setString(2, restaurantName);
            ps.setDouble(3, amount);
            ps.executeUpdate();
            // ResultSet in try-with-resources
            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    // Get Orders By Customer
    public static ArrayList<String> getOrdersByCustomer(String customerId) {

        ArrayList<String> list = new ArrayList<>();

        String sql = "SELECT * FROM food_orders WHERE customer_id=?";

        try (
                Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, customerId);
            // ResultSet in try-with-resources
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    String order = "ORDER#" + rs.getInt("order_id")
                            + " | " + rs.getString("restaurant_name") + " | Rs." + rs.getDouble("amount");
                    list.add(order);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // Main Method
    public static void main(String[] args) {

        int id1 = insertOrder("C101", "Dominos", 550);
        int id2 = insertOrder("C101", "McDonalds", 320);
        int id3 = insertOrder("C102", "KFC", 450);

        System.out.println("Generated Order IDs:");
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);

        System.out.println("\nOrders of Customer C101:");

        ArrayList<String> orders = getOrdersByCustomer("C101");

        for (String order : orders) {
            System.out.println(order);
        }
    }
}