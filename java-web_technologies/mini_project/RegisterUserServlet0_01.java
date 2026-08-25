/*1.Create a simple web form named RegisterUser.jsp for new users to sign up with fields: username, 
 * email, and password. On submit, post the data to a RegisterUserServlet that saves the user info 
 * into a database table called users.
 */

package servle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dbc.DBConnection0_01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUserServlet0_01")
public class RegisterUserServlet0_01 extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.getWriter().println("User registered successfully!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Registration failed!");
        }
    }
}

/*RegisterUser0.0_1.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
<h2>User Registration</h2>
<form action="RegisterUserServlet0_01" method="post">
    Username:<input type="text" name="username"><br>
    Email:<input type="email" name="email"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Register">
</form>
</body>
</html>*/
/*DBConnection0_01.java
package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection0_01 {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test1";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }
}*/