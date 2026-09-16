/*3.Write a JSP file named product-list.jsp that displays a table of all products fetched from ProductDAO, 
 * similar to how Zomato lists restaurants.
 */

package model203;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products203")
public class ProductListServlet203 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO203 dao = new ProductDAO203();

        List<Product203> products =dao.getAllProducts();

        request.setAttribute("products", products);
        
        RequestDispatcher rd = request.getRequestDispatcher("product-list203.jsp");

        rd.forward(request, response);
    }
}