<%-- 4.
Configure a custom error page error404.jsp in your web.xml to display 
a friendly message and a link back to the homepage whenever a user enters an 
invalid URL.<br><br><em><strong>Hint:</strong> Use the <error-page> tag in 
web.xml and test by visiting a non-existent page.</em>
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <style>
     body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 100px;
        }

        h1 {
            color: red;
        }

        a {
            text-decoration: none;
            color: blue;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <h1>404 - Page Not Found</h1>
    <p>Sorry, the page you are looking for does not exist.</p>
    <a href="<%= request.getContextPath() %>/index.html">
        Go Back to Home </a>
</body>
</html>

<%--  <?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
	<error-page>
        <error-code>404</error-code>
        <location>/error404.jsp</location>
    </error-page>
</web-app>
--%>
