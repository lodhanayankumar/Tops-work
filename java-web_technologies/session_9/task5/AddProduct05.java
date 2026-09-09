/*5.Refactor your AddProductServlet to handle multiple product registrations in a single 
 * session by maintaining a List<Product> in the session and updating showProduct.jsp to 
 * display all registered products.
 */

package test15;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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