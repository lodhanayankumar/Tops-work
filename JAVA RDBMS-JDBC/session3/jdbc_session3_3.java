/*3.Build a Java function deleteCartItem that deletes a product from a 
 * user's shopping cart in the cart_items table using PreparedStatement, 
 * given the cart_item_id
 */

package jdbc_session3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc_session3_3  {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    // Function to delete a cart item
    public static void deleteCartItem(int cartItemId) {

        String sql = "DELETE FROM cart_items WHERE cart_item_id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cartItemId);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Cart item deleted successfully.");
            } else {
                System.out.println("Cart item not found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Delete cart item with ID 101
        deleteCartItem(101);
    }
}
