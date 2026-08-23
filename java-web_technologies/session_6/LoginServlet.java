package test13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login_1")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("nayan") && password.equals("1234")) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            /* Session timeout:
             * The session will expire after the timeout period if
             * there is no activity.
             * For example, 30 minutes:
             */
            session.setMaxInactiveInterval(30 * 60);

            out.println("Login Successful");
            out.println("Welcome " + username);
            out.println("<br>"+"<a href='dashboard'>Go to Dashboard</a>");
            out.println("<br>"+"<a href='logout'>Logout</a>");
        } else {
            out.println("Invalid Username or Password");
            out.println("<a href='index.html'>Try Again</a>");
        }
    }
}