/*3.Implement URL rewriting in a servlet-based Java web app: pass the username as a URL parameter from 
 * LoginServlet to ProfileServlet, and display the username on the profile page.<br><br><em><strong>Hint:
 * </strong> Use response.sendRedirect with URL parameters and request.getParameter to retrieve them.</em>
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

@WebServlet("/login_03")
public class LoginServlet_03 extends HttpServlet {

    protected void doPost(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username.equals("nayan") && password.equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("dashboard.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.println("Invalid Username or Password");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}


