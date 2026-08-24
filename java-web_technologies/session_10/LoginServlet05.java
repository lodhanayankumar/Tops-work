/*5.Modify your login servlet so that if login fails (wrong username or password), 
 * it forwards to login.jsp and displays 'Invalid Credentials' in bold red text above 
 * the form.<br><br><em><strong>Constraint:</strong> Do not reload the entire page;
 *  use request attributes to pass the error message.</em>
 */

package servlet02;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet05")
public class LoginServlet05 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "123456".equals(password)) {
            response.sendRedirect("home05.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials");

            RequestDispatcher rd = request.getRequestDispatcher("login05.jsp");
            rd.forward(request, response);
        }
    }
}

/*login05.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .error {
        color: red;
        font-weight: bold;
        margin-bottom: 15px;
    }
</style>
</head>
<body>
<h2>Login Form</h2>
<% 
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) { %>
    <div class="error">
        <%= errorMessage %>
    </div>
<% } %>
<form action="LoginServlet05" method="post">
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>*/