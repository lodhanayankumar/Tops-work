/*SCENARIO
You are working on the Order History screen for a food delivery app. A JDBC SELECT
returns a ResultSet with columns: order_id, restaurant_name, total_amount,
order_date, and status. A junior developer reads every column by positional index —
rs.getString(1), rs.getString(2), and so on.
*/

package assesment;

import java.sql.*;

public class s5 {
    public static void main(String[] args) {

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_delivery",
                    "root",
                    "Nayan@2001");

            // Execute SELECT Query
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT order_id, restaurant_name, total_amount, order_date, status FROM order_history");

            System.out.println("========= ORDER HISTORY =========");

            while (rs.next()) {

                // Read using COLUMN NAMES (Recommended)

                int orderId = rs.getInt("order_id");
                String restaurant = rs.getString("restaurant_name");
                double amount = rs.getDouble("total_amount");
                boolean amountNull = rs.wasNull();
                Date orderDate = rs.getDate("order_date");
                String status = rs.getString("status");

                // Handle SQL NULL
                if (status == null) {
                    status = "Not Available";
                }
                System.out.println("Order ID        : " + orderId);
                System.out.println("Restaurant Name : " + restaurant);
                
                if (amountNull) {
                    System.out.println("Total Amount    : NULL");
                } else {
                    System.out.println("Total Amount    : " + amount);
                }
                System.out.println("Order Date      : " + orderDate);
                System.out.println("Status          : " + status);
                System.out.println("--------------------------------");
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}