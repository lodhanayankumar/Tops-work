/*3.Design a JSP page called showProduct.jsp that retrieves the Product bean from the session 
 * and displays its details in a table format.
 */

package servlet02;

import java.io.IOException;

import bean02.Product0_2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddProductServlet02")
public class AddProductServlet02 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");

        Product0_2 product = new Product0_2();

        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);

        HttpSession session = request.getSession();
        session.setAttribute("product", product);
        response.sendRedirect("showProduct02.jsp");
    }
}

/*Product0_2.java
 * package bean02;

public class Product0_2 {

	    private String name;
	    private double price;
	    private String category;

	    public Product0_2() {
	    }

	    public Product0_2(String name, double price, String category) {
	        this.name = name;
	        this.price = price;
	        this.category = category;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }
	    
}
*/
/*addProduct02.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Product</h2>
<form action="AddProductServlet02" method="post">
    Product Name:<input type="text" name="name"><br>
    Price:<input type="number" name="price" step="0.01"><br>
    Category:<input type="text" name="category"><br>
    <input type="submit" value="Add Product">
</form>
</body>
</html>*/

/*ahowProduct02.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="bean02.Product0_2" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Product Details</h2>
<%
Product0_2 product = (Product0_2) session.getAttribute("product"); %>
<table border="1" cellpadding="10">
<tr>
    <th>Name</th>
    <td><%= product.getName() %></td>
</tr>

<tr>
    <th>Price</th>
    <td><%= product.getPrice() %></td>
</tr>

<tr>
    <th>Category</th>
    <td><%= product.getCategory() %></td>
</tr>
</table>
</body></html>*/