<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Order Summary</h1>
<p>Item Name: ${itemName}</p>
<p>Quantity: ${quantity}</p>
<p>Price: ₹${price}</p>
<p>Total Cost: ₹${quantity * price}</p>
</body>
</html>