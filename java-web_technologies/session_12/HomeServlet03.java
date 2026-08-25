/*3.Implement session tracking in a Java web app by creating a LoginServlet that stores the username 
 * in the session after login, and a HomeServlet that greets the user by name if the session is active, 
 * or redirects to login if not.<br><br><em><strong>Hint:</strong> Use HttpSession to manage the session 
 * data.</em>
 */

package a13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HomeServlet03")
public class HomeServlet03 extends HttpServlet {

    protected void doGet(HttpServletRequest request,     HttpServletResponse response)  throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||session.getAttribute("username") == null) {

            response.sendRedirect("login03.jsp");
            return;
        }
        String username =  (String) session.getAttribute("username");

        PrintWriter out = response.getWriter();

        out.println("Home");
        out.println("Welcome, " + username );
        out.println("Your session is active.");
   }
}

/*LoginServlet03.java
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
}*/
/*login03.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="LoginServlet03" method="post">
Username:
<input type="text" name="username" required>
<br>
Password:
<input type="password" name="password" required>
<br>
<button type="submit">Login</button>
</form>
</body>
</html>*/