/*2.Modify your code to accept a category name as user input and display only the products from that category, 
 * showing their names and prices using ResultSet traversal.<br><br><em><strong>Hint:</strong> 
 * Use a PreparedStatement to prevent SQL injection.</em>
 */
package jdbc_session4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc_session4_2  {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Category Name: ");
        String category = sc.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT product_name, price FROM products WHERE category = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nProduct Name\t\tPrice");
            System.out.println("--------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getString("product_name") + "\t\t₹" +
                        rs.getDouble("price"));
            }

            if (!found) {
                System.out.println("No products found in this category.");
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
