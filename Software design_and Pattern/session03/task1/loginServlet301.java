/*1.Create a simple Java web app with a login form (username only) and use the HttpSession API to store the 
 * logged-in user's name after successful login. Display a personalized welcome message on a separate welcome.
 * jsp page that only appears if the session exists.
 */

package login1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login301")
public class loginServlet301 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        HttpSession session = request.getSession();

        session.setAttribute("username", username);
        response.sendRedirect("welcom301.jsp");
    }
}
