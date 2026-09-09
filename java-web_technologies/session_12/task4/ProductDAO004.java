package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbconn.DBConnection02;
import model.Product004;

public class ProductDAO004 {

    public List<Product004> getAllProducts()
            throws Exception {

        List<Product004> products = new ArrayList<>();

        String sql = "SELECT * FROM products";
        Connection con = DBConnection02.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            Product004 product = new Product004();

            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));

            products.add(product);
        }

        rs.close();
        ps.close();
        con.close();

        return products;
    }
}