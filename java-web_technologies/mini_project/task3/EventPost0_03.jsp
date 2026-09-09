<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post Event</title>
</head>
<body>
    <h2>Post New Event</h2>
    <%
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("Login0_02.jsp");
            return;
        }
    %>
    <p>Logged in as: <strong><%= username %></strong></p>
    <form action="EventPostServlet0_03" method="post">
        Event Title:<input type="text" name="title"><br>
        Event Date:<input type="date" name="event_date"><br>
        Description:<textarea name="description" rows="5" cols="40"></textarea>
        <br>
        <input type="submit" value="Post Event">
    </form>
</body>
</html>