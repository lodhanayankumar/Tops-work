<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    HttpSession sessionObj = request.getSession(false);

    if (sessionObj != null &&
        sessionObj.getAttribute("username") != null) {

        String username =
                (String) sessionObj.getAttribute("username");
%>

        <h2>Welcome, <%= username %>!</h2>
        <p>You are successfully logged in.</p>

<%
    } else {
%>

        <h2>Please login first.</h2>
        <a href="login301.html">Go to Login</a>

<%
    }
%>
</body>
</html>