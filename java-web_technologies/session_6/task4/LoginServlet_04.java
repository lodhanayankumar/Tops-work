/*4.Add a 'Logout' button to your dashboard.jsp that invalidates the current HttpSession and 
 * redirects the user to the login page.<br><br><em><strong>Hint:</strong> Use session.
 * invalidate() in your LogoutServlet.</em>
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

@WebServlet("/login_04")
public class LoginServlet_04 extends HttpServlet {

    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("Deshboard_04.jsp");
        } else {
            out.println("Invalid Username or Password");
            out.println("<a href='login_04.html'>Try Again</a>");
        }
    }
}
