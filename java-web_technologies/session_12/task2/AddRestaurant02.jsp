<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Add Restaurant</h2>

<form action="AddRestaurantServlet02" method="post">

    <label>Restaurant Name:</label>
    <input type="text" name="restaurantName" required>

    <label>Cuisine Type:</label>
    <input type="text" name="cuisineType"
           placeholder="Indian, Chinese, Italian"
           required>

    <button type="submit">Add Restaurant</button>

</form>

</body>
</html>