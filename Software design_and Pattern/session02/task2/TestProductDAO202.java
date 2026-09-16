/*2.Implement a DAO class called ProductDAO with methods addProduct(Product product) and 
 * getAllProducts() that interact with a MySQL database table 'products'.<br><br><em><strong>
 * sHint:</strong> Use JDBC for database connectivity and PreparedStatement for queries.</em>
 */

package Daoo;

import java.util.List;

import pattern02.Product201;

public class TestProductDAO202 {

    public static void main(String[] args) {

        ProductDAO202 dao = new ProductDAO202();

        Product201 product = new Product201();

        product.setId(104);
        product.setName("Keyboard");
        product.setPrice(1200);

        dao.addProduct(product);

        List<Product201> products = dao.getAllProducts();

        System.out.println("\nAll Products:");

        for (Product201 p : products) {

            System.out.println("id: " + p.getId());
            System.out.println("name: " + p.getName());
            System.out.println("price: " + p.getPrice());
        }
    }
}