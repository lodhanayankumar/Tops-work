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
</html>