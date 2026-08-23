/*3.Simulate a Flipkart-style product details page: create a ProductServlet that takes a productId from 
 * the request and, if the productId is missing or invalid, sets the HTTP status code to 404 and displays 
 * 'Product not found'. Otherwise, set the status code to 200 and display 'Product details for [productId]'.
 */

package test12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/produc_t")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String productId = request.getParameter("productId");
        if (productId == null || productId.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("Product not found");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            out.println("Product details for "+productId);
        }
    }
}

/*Product.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Flipkart Product Search</h1>
    <form action="produc_t" method="get">
        Enter Product ID:<input type="text" name="productId"><br><br>
        <input type="submit" value="View Product">
    </form>
</body>
</html>*/