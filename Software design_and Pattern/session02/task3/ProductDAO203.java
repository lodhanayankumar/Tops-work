/*3.Write a JSP file named product-list.jsp that displays a table of all products fetched from ProductDAO, similar to 
 * how Zomato lists restaurants.
 */

package model203;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO203 {

    public void addProduct(Product203 product) {

        String sql ="insert into products(id, name, price) value(?, ?, ?)";

        try {
            Connection con = DBConnection203.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

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
    public List<Product203> getAllProducts() {

        List<Product203> productList = new ArrayList<>();

        String sql ="select id, name, price from products";

        try {
            Connection con = DBConnection203.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product203 product = new Product203();

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