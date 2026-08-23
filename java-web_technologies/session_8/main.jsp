<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h3>Main Content</h3>
    <p>This is the main JSP page.</p>
    <p>The header and footer are included dynamically using jsp:include.</p>
    <jsp:include page="footer.jsp" />
</body>
</html>


<%-- header.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>
</head>
<body>

    <h2>Welcome to My JSP Website!</h2>
    <p>Welcome, User!</p>

    <hr>--%>
   
  <%-- footer.jsp
      <hr>

    <p>&copy; 2026 My JSP Website. All Rights Reserved.</p>

</body>
</html>  --%>