package org.anudip.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.anudip.sms.database.Dbconnection;
import org.anudip.sms.model.Product;
import java.util.List;
import java.util.ArrayList;

public class Productdao {

    // 1. ADD PRODUCT METHOD
    public boolean addProduct(Product product) {
        String query = "INSERT INTO products (product_name, price, quantity) VALUES (?, ?, ?)";

        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getStockQuantity());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. VIEW PRODUCTS METHOD
    public List<Product> viewProducts() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("product_id"); 
                String name = rs.getString("product_name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");

                Product product = new Product(id, name, price, quantity);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

//3. UPDATE PRODUCT METHOD
public boolean updateProduct(Product product) {
    String query = "UPDATE products SET product_name = ?, price = ?, quantity = ? WHERE product_id = ?";

    try (Connection conn = Dbconnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, product.getName());
        stmt.setDouble(2, product.getPrice());
        stmt.setInt(3, product.getStockQuantity()); // Capitalized S to match your getStockQuantity()
        stmt.setInt(4, product.getId());            // Matches your product ID getter method

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
//4. DELETE PRODUCT METHOD
public boolean deleteProduct(int id) {
    String query = "DELETE FROM products WHERE product_id = ?";

    try (Connection conn = Dbconnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
