/*1.Create a servlet called MovieLoginServlet that checks if a user has entered the correct username and password 
 * (hardcode any values), and if successful, use response.sendRedirect() to send the user to a new 
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

@WebServlet("/moviedashboard")
public class MovieDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Welcome to Movie Dashboard");
        out.println("Login Successful!");
    }
}