/*3.Create a simple ProductDAO interface and a ProductDAOImpl class for a Flipkart-style app. 
 * The DAO should have methods addProduct(Product p), getProductById(int id), and deleteProduct(int id). 
 * Implement these methods with basic print statements to simulate database actions.
 */

package Task1;

public class FlipkartApp {

    public static void main(String[] args) {

        Product103 p = new Product103(101, "Samsung Mobile", 20000);

        ProductDAO103 dao = new ProductDAOImpl103();

        dao.addProduct(p);
//get product
        Product103 product = dao.getProductById(101);

        System.out.println("\nProduct found");
        System.out.println("ID: " + product.id);
        System.out.println("Name: " + product.name);
        System.out.println("Price: " + product.price+"\n");

     

        dao.deleteProduct(101);
    }
}