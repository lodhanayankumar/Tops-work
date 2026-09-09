/*2.Develop a Servlet named AddProductServlet that accepts product details from a form 
 * (name, price, category), creates a Product Java Bean, and stores it in the session.
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
