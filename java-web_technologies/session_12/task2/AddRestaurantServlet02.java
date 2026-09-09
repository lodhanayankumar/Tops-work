/*2.Build a JSP page named AddRestaurant.jsp where users can enter a restaurant name and cuisine type 
 * (like Zomato). On form submission, use a Servlet to store the details in a MySQL database using 
 * JDBC.
 */

package a13;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection02;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddRestaurantServlet02")
public class AddRestaurantServlet02 extends HttpServlet {

    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        String restaurantName =  request.getParameter("restaurantName");
        String cuisineType = request.getParameter("cuisineType");
        String sql ="INSERT INTO restaurants " +"(restaurant_name, cuisine_type) VALUES (?, ?)";

        try {

            Connection con = DBConnection02.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, restaurantName);
            ps.setString(2, cuisineType);
            int result = ps.executeUpdate();
            ps.close();
            con.close();

            if (result > 0) {
                response.getWriter().println("Restaurant added successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println( "Database Error: " + e.getMessage()+"</h2>");
        }
    }
}
