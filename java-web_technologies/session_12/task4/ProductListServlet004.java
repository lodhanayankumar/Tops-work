/*4.Refactor an existing Servlet+JSP codebase for a Flipkart-style product listing so that it 
 * follows the MVC pattern: separate the data access (Model), request handling (Controller), 
 * and display (View) into different Java classes and JSP files.<br><br><em><strong>
 * Hint:</strong> Your Controller should not contain any HTML code.</em>
 */

package a13;

import java.io.IOException;

import java.util.List;

import model.Product004;
import dao.ProductDAO004;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductListServlet004")
public class ProductListServlet004 extends HttpServlet {

    protected void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException {

        try {

            ProductDAO004 dao = new ProductDAO004();
            List<Product004> products = dao.getAllProducts();

            request.setAttribute("products", products);
            request.getRequestDispatcher( "products004.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error","Unable to load products.");

            request.getRequestDispatcher("products004.jsp").forward(request, response);
        }
    }
}
