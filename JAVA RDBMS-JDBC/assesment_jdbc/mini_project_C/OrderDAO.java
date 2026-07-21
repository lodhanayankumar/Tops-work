package mini_project_C_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {

    // Place Order using Transaction
    public void placeOrder(int customerId, String restaurantName, double amount) {

        if (amount <= 0) {
            System.out.println("Amount cannot be negative or zero.");
            return;
        }

        String updateWallet = "UPDATE customers "
                + "SET wallet_balance = wallet_balance - ? "
                + "WHERE customer_id = ? AND wallet_balance >= ?";

        String insertOrder = "INSERT INTO orders "
                + "(customer_id, restaurant_name, amount, order_date) "
                + "VALUES (?, ?, ?, CURDATE())";

        try (Connection con = database_connection.getConnection()) {

            // Start Transaction
            con.setAutoCommit(false);

            try {

                // Step 1 : Deduct Wallet Balance
                try (PreparedStatement ps1 = con.prepareStatement(updateWallet)) {

                    ps1.setDouble(1, amount);
                    ps1.setInt(2, customerId);
                    ps1.setDouble(3, amount);

                    int rows = ps1.executeUpdate();

                    if (rows == 0) {
                        throw new SQLException("Insufficient Wallet Balance.");
                    }
                }

                // Step 2 : Insert Order
                try (PreparedStatement ps2 = con.prepareStatement(insertOrder)) {

                    ps2.setInt(1, customerId);
                    ps2.setString(2, restaurantName);
                    ps2.setDouble(3, amount);

                    ps2.executeUpdate();
                }

                // Commit Transaction
                con.commit();

                System.out.println("--------------------------------");
                System.out.println("Order Placed Successfully.");
                System.out.println("--------------------------------");

            } catch (Exception e) {

                // Rollback Transaction
                con.rollback();

                System.out.println("--------------------------------");
                System.out.println("Transaction Rolled Back.");
                System.out.println(e.getMessage());
                System.out.println("--------------------------------");
            }

            con.setAutoCommit(true);

        } catch (Exception e) {

            System.out.println("Database Error : " + e.getMessage());
        }
    }

    // View Order History
    public void viewOrderHistory(int customerId) {

        String sql = "SELECT order_id, restaurant_name, amount, order_date "
                   + "FROM orders "
                   + "WHERE customer_id = ? "
                   + "ORDER BY order_date DESC";

        try (
                Connection con = database_connection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {

                boolean found = false;

                System.out.println("\n============== ORDER HISTORY ==============");
                System.out.printf("%-10s %-20s %-12s %-15s%n",
                        "Order ID", "Restaurant", "Amount", "Date");
                System.out.println("----------------------------------------------------------");

                while (rs.next()) {

                    found = true;

                    System.out.printf("%-10d %-20s %-12.2f %-15s%n",
                            rs.getInt("order_id"),
                            rs.getString("restaurant_name"),
                            rs.getDouble("amount"),
                            rs.getDate("order_date"));
                }

                if (!found) {
                    System.out.println("No Orders Found.");
                }

                System.out.println("----------------------------------------------------------");

            }

        } catch (Exception e) {

            System.out.println("Database Error : " + e.getMessage());
        }
    }
}