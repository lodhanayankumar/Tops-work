/*2.Implement a DAO class called ProductDAO with methods addProduct(Product product) and 
 * getAllProducts() that interact with a MySQL database table 'products'.
 * <br><br><em><strong>Hint:</strong> Use JDBC for database connectivity and PreparedStatement for queries.
 * </em>
 */

package Daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectio.DBConnection202;
import pattern02.Product201;

public class ProductDAO202 {

	    public void addProduct(Product201 product) {

	        String sql = "insert into products(id, name, price) value(?, ?, ?)";

	        try {

	            Connection con = DBConnection202.getConnection();

	            PreparedStatement ps =con.prepareStatement(sql);

	            ps.setInt(1, product.getId());
	            ps.setString(2, product.getName());
	            ps.setDouble(3, product.getPrice());

	            ps.executeUpdate();

	            System.out.println("Product added successfully!");

	            ps.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Product201> getAllProducts() {

	        List<Product201> productList = new ArrayList<>();

	        String sql = "select id, name, price from products";

	        try {

	            Connection con = DBConnection202.getConnection();

	            PreparedStatement ps = con.prepareStatement(sql);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Product201 product = new Product201();

	                product.setId(rs.getInt("id"));
	                product.setName(rs.getString("name"));
	                product.setPrice(rs.getDouble("price"));
	                productList.add(product);
	            }

	            rs.close();
	            ps.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return productList;
	    }
}
