package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.model.Product;

public class ProductDao extends BaseDao {
	public boolean addProduct(Product product) {
			String sql = "INSERT INTO products" + 
		"(prod_id,pname,price,stock)VALUES(?,?,?,?)";
			try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, product.getProd_id());
				pstmt.setString(2, product.getPname());
				pstmt.setDouble(3, product.getPrice());
				pstmt.setInt(4, product.getStock());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				return false;
			}
		}
}