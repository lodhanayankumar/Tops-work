/*3.Add logic to your servlet so that if the email format is invalid, the user sees a red error message below 
 * the email field saying 'Please enter a valid email address.
 */

package servlet02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet03")
public class SignupServlet03 extends HttpServlet {

    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || !email.contains("@") || !email.endsWith(".com")) {
            response.sendRedirect("signup03.html?error=invalidEmail");
            return;
        }
        if (name == null || name.trim().isEmpty() || password == null || password.length() < 6) {
            response.sendRedirect("signup03.html");
            return;
        }
        response.getWriter().println("Signup Successful!");

    }
}

/*signup03.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Signup Form</h2>
<form action="SignupServlet03" method="post">
Name: <input type="text" name="name"><br>
Email:<input type="text" name="email">
<%
    String error = request.getParameter("error");
    if ("invalidEmail".equals(error)) {
%>
    <div style="color: red;">
        Please enter a valid email address.
    </div>
<% } %>
<br>
Password:<input type="password" name="password"><br>
<input type="submit" value="Signup">
</form>
</body>
</html>*/