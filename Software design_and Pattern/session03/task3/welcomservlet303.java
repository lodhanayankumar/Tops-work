/*3.Build a logout button on your welcome page that calls session.invalidate() and redirects the user back 
 * to the login page. After logout, ensure the user cannot access the welcome page by typing its URL directly.
 */

package login1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome303")
public class welcomservlet303 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        showWelcomePage(response, username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null||session.getAttribute("username") == null) {
            response.sendRedirect("login303.html");
            return;
        }
        String username = (String) session.getAttribute("username");
        showWelcomePage(response, username);
    }
    private void showWelcomePage(HttpServletResponse response, String username) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h2>Welcome, " + username + "!</h2>");

        out.println("<p>You are successfully logged in.</p>");

        // Logout button
        out.println("<form action='logout303' method='post'>");
        out.println("<input type='submit' value='Logout'>");

    }
}
