<%-- *2.Build a JSP page called showUser.jsp that takes a 'username' parameter from the request URL and displays 
'Welcome, {username}!' dynamically using a JSP scriptlet.<br><br><em><strong>Hint:</strong> Access 
the parameter using request.getParameter("username").</em>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String username = request.getParameter("username");
%>
<h1>Welcome, <%= username %>!</h1>
</body>
</html>