/*4.Implement the MVC flow for a Flipkart-style product registration: the user submits a product via a form 
 * (JSP), the AddProductServlet acts as the controller, and the Product bean is the model.<br><br><em>
 * <strong>Hint:</strong> Ensure the servlet forwards the request to showProduct.jsp after storing the bean in 
 * the session.</em>
 */



public class Product000 {

    private String name;
    private double price;

    public Product000() {
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
