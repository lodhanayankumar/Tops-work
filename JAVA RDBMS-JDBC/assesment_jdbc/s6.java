/*SCENARIO
You are optimising end-of-day reporting for a food delivery platform. The report
generation job needs to insert 500 daily summary rows into a report_logs table — one
row per fulfilled order. Currently the code calls executeUpdate() inside a for-loop,
sending one INSERT to the database per iteration.
*/
package assesment;

import java.sql.*;
import java.util.Random;

public class s6 {

    public static void main(String[] args) {

        Connection con = null;

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database Connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_delivery",
                    "root",
                    "Nayan@2001");

            // Disable Auto Commit
            con.setAutoCommit(false);

            // SQL Query
            String sql = "INSERT INTO report_logs(order_id, restaurant_name, total_amount) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            Random random = new Random();

            System.out.println("Adding Orders to Batch...\n");

            // Add Records into Batch
            for (int i = 1; i <= 10; i++) {

                int orderId = 100 + i;
                String restaurant = "Restaurant " + i;

                // Random amount between 100 and 1000
                double totalAmount = 100 + random.nextInt(901);

                ps.setInt(1, orderId);
                ps.setString(2, restaurant);
                ps.setDouble(3, totalAmount);

                // Add Query into Batch
                ps.addBatch();

                System.out.println("Order ID : " + orderId);
                System.out.println("Restaurant : " + restaurant);
                System.out.println("Total Amount : " + totalAmount);
                System.out.println("-------------------------");
            }

            // Execute Batch
            int[] result = ps.executeBatch();

            // Commit Transaction
            con.commit();

            System.out.println("\nBatch Processing Successful.");
            System.out.println("Total Records Inserted : " + result.length);

            ps.close();
            con.close();

        }

        catch (BatchUpdateException e) {

            System.out.println("\nBatch Processing Failed.");

            int[] updateCounts = e.getUpdateCounts();

            System.out.println("Records Inserted Before Failure : " + updateCounts.length);

            try {

                if (con != null) {

                    con.rollback();

                    System.out.println("Rollback Completed.");

                }

            } catch (SQLException ex) {

                System.out.println(ex);

            }

        }

        catch (Exception e) {

            System.out.println(e);

        }

        finally {

            try {

                if (con != null) {

                    con.setAutoCommit(true);

                    con.close();

                }

            } catch (Exception e) {

                System.out.println(e);

            }

        }

    }

}