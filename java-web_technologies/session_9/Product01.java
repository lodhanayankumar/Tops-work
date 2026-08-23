/*5.Refactor your AddProductServlet to handle multiple product registrations in a single session by 
 * maintaining a List<Product> in the session and updating showProduct.jsp to display all registered products.
 */

package bean1;

public class Product01 {

    private String name;
    private double price;

    public Product01() {
        name = "Unknown Product";
        price = 0.0;
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
}
/*AddProduct05.java
 * package test15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean1.Product01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddProduct05")
public class AddProduct05 extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product01 product = new Product01();

        product.setName(name);
        product.setPrice(price);

        HttpSession session = request.getSession();

        List<Product01> productList =
                (List<Product01>) session.getAttribute("productList");

        if (productList == null) {
            productList = new ArrayList<Product01>();
        }

        productList.add(product);

        session.setAttribute("productList", productList);

        response.sendRedirect("addproducts05.jsp");
    }
}
 */




/*addProduct.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddProduct05" method="post">
    Product Name:<input type="text" name="name" ><br>
    Price:<input type="number" name="price" ><br>
    <input type="submit" value="Add Product">
</form>
</body>
</html>*/

/* addproducts05.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="bean1.Product01" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered Products</title>
</head>
<body>
<h2>Registered Products</h2>

<%
List<Product01> productList =
    (List<Product01>) session.getAttribute("productList");

if (productList != null && !productList.isEmpty()) {
%>
<table border="1" cellpadding="10">
<tr>
    <th>No.</th>
    <th>Product Name</th>
    <th>Price</th>
</tr>
<%
int count = 1;
for (Product01 product : productList) {%>
<tr>
    <td><%= count++ %></td>
    <td><%= product.getName() %></td>
    <td><%= product.getPrice() %></td>
</tr>
<% }%>
</table>
<% } else {%>
<p>No products registered yet.</p>
<%}%>
</body>
</html>*/