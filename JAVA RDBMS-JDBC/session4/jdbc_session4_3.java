/*3.Implement pagination for the products list: fetch and display only 5 products per page, and allow the user to 
 * enter a page number to view the corresponding set of products.
 */
package jdbc_session4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc_session4_3 {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Page Number: ");
        int page = sc.nextInt();

        int pageSize = 5;
        int offset = (page - 1) * pageSize;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Fetch Product Name, Category and Price
            String sql = "SELECT product_name, category, price FROM products LIMIT ? OFFSET ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nPage " + page);
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-20s %-15s %-10s%n",
                    "Product Name", "Category", "Price");
            System.out.println("------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.printf("%-20s %-15s ₹%.2f%n",
                        rs.getString("product_name"),
                        rs.getString("category"),
                        rs.getDouble("price"));
            }

            if (!found) {
                System.out.println("No products found.");
            }

            rs.close();
            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}