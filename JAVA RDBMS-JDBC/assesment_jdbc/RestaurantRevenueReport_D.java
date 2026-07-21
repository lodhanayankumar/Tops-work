/*STEP 1  ·  BUILD WITH AI
Use an AI tool of your choice (ChatGPT, Claude, GitHub Copilot, etc.) to help you write a Java
program that:
Connects to a MySQL database using JDBC and reads all rows from a food_orders table.
Groups the orders by restaurant_name and calculates the total revenue and order count per
restaurant.
Displays the results as a formatted console report — one line per restaurant — showing
restaurant name, number of orders, and total revenue.
Handles the case where the food_orders table is empty and prints a 'No orders found.'
message instead of throwing an exception*/


package assesment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RestaurantRevenueReport_D {

    // Database Configuration
    private static final String URL =
            "jdbc:mysql://localhost:3306/food_delivery";
    private static final String USER = "root";
    private static final String PASSWORD = "Nayan@2001";  

    public static void main(String[] args) {

        String query =
                "SELECT restaurant_name, " +
                "COUNT(*) AS order_count, " +
                "SUM(total_amount) AS total_revenue " +
                "FROM food_orders " +
                "GROUP BY restaurant_name " +
                "ORDER BY restaurant_name";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);

            // Execute Query
            ResultSet rs = ps.executeQuery();

            boolean hasData = false;

            System.out.println("\n============== RESTAURANT REVENUE REPORT ==============");
            System.out.printf("%-20s %-15s %-15s%n",
                    "Restaurant", "Orders", "Revenue");
            System.out.println("-------------------------------------------------------");

            while (rs.next()) {
                hasData = true;

                String restaurant = rs.getString("restaurant_name");
                int orders = rs.getInt("order_count");
                double revenue = rs.getDouble("total_revenue");

                System.out.printf("%-20s %-15d ₹%.2f%n",
                        restaurant, orders, revenue);
            }

            if (!hasData) {
                System.out.println("No orders found.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}