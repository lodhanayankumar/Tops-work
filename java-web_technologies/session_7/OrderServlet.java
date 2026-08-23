/*4.Create a JSP page named orderSummary.jsp that uses Expression Language (EL) to display the values of three 
 * request attributes: 'itemName', 'quantity', and 'price'. Set these attributes in a servlet or using a test 
 * forward, and show the total cost as quantity × price using EL.<br><br><em><strong>Hint:</strong> Use 
 * ${attributeName} for EL expressions.</em>
 */

package test14;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("itemName", "Laptop");
        request.setAttribute("quantity", 2);
        request.setAttribute("price", 50000);

        request.getRequestDispatcher("orderSummery.jsp")
        .forward(request, response);
    }
}

/*orderSummery.jsp
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
*/