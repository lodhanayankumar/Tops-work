<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
    <h1>Dashboard</h1>
    <c:if test="${not empty userName}">
        <h2>Welcome, ${userName}!</h2>
    </c:if>
    <c:if test="${empty userName}">
        <h2>Welcome, Guest!</h2>
    </c:if>
</body>
</html>