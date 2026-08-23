/*3.Update your showProduct.jsp page to include <jsp:setProperty> that sets the Product bean's name and 
 * price from request parameters, then display the updated values on the page.<br><br><em><strong>Hint:
 * </strong> Use a query string like showProduct.jsp?name=Earbuds&price=1999 to test your code.</em>
 */

package test14;

public class product_1 {

    private String name;
    private double price;

    // Default constructor
    public product_1() {
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }
}

/*showProduct_01.jsp
 * 
 
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
<jsp:useBean id="product" class="test14.product_1" scope="page" />

<jsp:setProperty name="product" property="name" param="name" />
<jsp:setProperty name="product" property="price" param="price" />

<p> Product Name:<%= product.getName() %></p>
<p> Product Price:<%= product.getPrice() %></p>
</body>
</html>
*/