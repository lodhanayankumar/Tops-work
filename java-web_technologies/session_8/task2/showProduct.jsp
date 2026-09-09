<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Product Details</h2>
    <jsp:useBean id="product" class="test14.Product" scope="page" />
    <p>Product Name: <%= product.getName() %></p>
    <p>Product Price: <%= product.getPrice() %></p>
</body>
</html>