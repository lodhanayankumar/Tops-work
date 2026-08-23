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


/*login_03.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Login</h1>
    <form action="login_03" method="post">
        Username:<input type="text" name="username"><br>
        Password:<input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
*/
/*Deshboard.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
%>
<h1>Welcome <%= username %></h1>
<p>You have successfully logged in.</p>
</body>
</html>*/