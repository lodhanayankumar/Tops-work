/*3.Create a simple ProductDAO interface and a ProductDAOImpl class for a Flipkart-style app. The DAO 
 * should have methods addProduct(Product p), getProductById(int id), and deleteProduct(int id). 
 * Implement these methods with basic print statements to simulate database actions.
 */

package Task1;

public class Product103 {

    int id;
    String name;
    double price;

    public Product103(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }
}