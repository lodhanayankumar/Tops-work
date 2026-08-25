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

/*AddRestaurant02.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Add Restaurant</h2>

<form action="AddRestaurantServlet02" method="post">

<label>Restaurant Name:</label>
<input type="text" name="restaurantName" required>

<label>Cuisine Type:</label>
<input type="text" name="cuisineType"
       placeholder="Indian, Chinese, Italian"
       required>

<button type="submit">Add Restaurant</button>

</form>

</body>
</html>*/

/*DBConnection02.java
package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection02 {

    private static final String url ="jdbc:mysql://localhost:3306/restaurant_db";
    private static final String user = "root";
    private static final String pass = "root";

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url,user,pass);
    }
}*/