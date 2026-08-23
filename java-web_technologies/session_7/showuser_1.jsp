<%-- 3.Add a JSP directive at the top of your showUser.jsp to set the page encoding to UTF-8 and import the java.time.LocalDate class. Display the 
current date below the welcome message using LocalDate.now(). --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String username = request.getParameter("username");
%>
<h2>Welcome, <%= username %>!</h2>
<p>Current Date: <%= LocalDate.now() %></p>
</body>
</html>
