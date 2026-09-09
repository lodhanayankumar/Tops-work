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
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <% }%>
    <form action="SignupServlet01" method="post">
        Username:<input type="text" name="username"><br>
        Email:<input type="email" name="email"><br>
        Password:<input type="password" name="password"><br>
        <input type="submit" value="Signup">
    </form>
</body>
</html>