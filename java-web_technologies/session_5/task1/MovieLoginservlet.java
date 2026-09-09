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
