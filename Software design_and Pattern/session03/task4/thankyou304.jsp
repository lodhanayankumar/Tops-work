<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Thank You</title>
</head>
<body>
    <h2>Thank You for Your Feedback!</h2>
    <p>
        <b>Name:</b>
        <%= request.getAttribute("name") %>
    </p>
    <p>
        <b>Feedback:</b>
        <%= request.getAttribute("feedback") %>
    </p>
</body>
</html>