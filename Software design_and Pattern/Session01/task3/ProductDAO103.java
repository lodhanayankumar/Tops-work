/*3.Create a simple ProductDAO interface and a ProductDAOImpl class for a Flipkart-style app. 
 * The DAO should have methods addProduct(Product p), getProductById(int id), and deleteProduct(int id). 
 * Implement these methods with basic print statements to simulate database actions.
 */
package Task1;

public interface ProductDAO103 {

    void addProduct(Product103 p);

    Product103 getProductById(int id);

    void deleteProduct(int id);
}