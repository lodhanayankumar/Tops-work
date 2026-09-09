package a13;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet03")
public class LoginServlet03 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("HomeServlet03");
        } else {
            response.getWriter().println("Invalid username or password");
        }
    }
}