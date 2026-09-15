/*3.Create a simple ProductDAO interface and a ProductDAOImpl class for a Flipkart-style app. 
 * The DAO should have methods addProduct(Product p), getProductById(int id), and deleteProduct(int id). 
 * Implement these methods with basic print statements to simulate database actions.
 */

package Task1;

public class ProductDAOImpl103 implements ProductDAO103 {

    @Override
    public void addProduct(Product103 p) {

        System.out.println("Product added successfully.");
        System.out.println("ID: " + p.id);
        System.out.println("Name: " + p.name);
        System.out.println("Price: " + p.price);
    }

    @Override
    public Product103 getProductById(int id) {

        System.out.println("Getting product with ID: " + id);

        Product103 p = new Product103(id, "Mobile Phone", 15000);

        return p;
    }

    @Override
    public void deleteProduct(int id) {

        System.out.println("Product with ID " + id
                + " deleted successfully.");
    }
}