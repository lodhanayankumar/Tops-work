/*1.Create a servlet called MovieLoginServlet that checks if a user has entered the correct username and 
 * password (hardcode any values), and if successful, use response.sendRedirect() to send the user to a new 
 * servlet called MovieDashboardServlet.
 */


package test12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/movielogin")
public class MovieLoginservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if (username.equals("abc") && password.equals("1234")) {
            response.sendRedirect("moviedashboard");
        } else {
            out.println("Invalid Username or Password");
            out.println("Try Again");
        }
    }
}

/*MovieDashboardServlet
 * package test12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/moviedashboard")
public class MovieDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Welcome to Movie Dashboard");
        out.println("Login Successful!");
    }
}*/

/*login1.html
 * <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Movie Login</h1>
    <form action="movielogin" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body></html>*/
