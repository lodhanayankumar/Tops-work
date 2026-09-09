/*5.Refactor your AddProductServlet to handle multiple product registrations in a single session by 
 * maintaining a List<Product> in the session and updating showProduct.jsp to display all registered 
 * products.
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