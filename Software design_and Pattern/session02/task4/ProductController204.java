/*4.Create a servlet named ProductController that acts as the Controller in MVC, handling requests to add 
 * a new product and forwarding to product-list.jsp for display.
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

@WebServlet("/ProductController204")
public class ProductController204 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO203 dao = new ProductDAO203();

        List<Product203> products = dao.getAllProducts();

        request.setAttribute("products", products);

        RequestDispatcher rd = request.getRequestDispatcher("product-list203.jsp");

        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        double price = Double.parseDouble(request.getParameter("price"));

        Product203 product = new Product203();

        product.setId(id);
        product.setName(name);
        product.setPrice(price);

        ProductDAO203 dao = new ProductDAO203();

        dao.addProduct(product);

        List<Product203> products = dao.getAllProducts();

        request.setAttribute("products", products);

        RequestDispatcher rd = request.getRequestDispatcher("product-list203.jsp");

        rd.forward(request, response);
    }
}