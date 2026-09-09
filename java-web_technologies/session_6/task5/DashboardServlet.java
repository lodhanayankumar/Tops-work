/*5.Simulate a 'Remember Me' feature like Zomato's login: modify your login logic to keep the user logged in using a session until they explicitly 
 * log out or close the browser, and explain in comments how session timeout would affect this behavior.
 */

package test13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if (session != null&&session.getAttribute("username") != null) {

            String username = (String) session.getAttribute("username");

            out.println("Welcome " + username);
            out.println("You are in logged");
            out.println("<br>"+"<a href='logout'>Logout</a>");
        } else {
            out.println("Please Login First");
            out.println("<a href='index.html'>Login</a>");
        }
    }
}