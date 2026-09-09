<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h2>Welcome to Home Page</h2>
    <%
        String username = (String) session.getAttribute("username");
    %>
    <h3>Welcome, <%= username %>!</h3>
    <p>You have successfully logged in.</p>
</body>
</html>