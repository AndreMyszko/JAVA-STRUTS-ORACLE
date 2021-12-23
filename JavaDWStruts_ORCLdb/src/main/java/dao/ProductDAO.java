package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import pojo.Product;

public class ProductDAO {

	public static List<Product> getAllProducts(){
		List<Product> productList = new ArrayList<Product>();
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM C##DEV.TB_PRODUCT");
			while(rs.next()) {
				Product product = new Product(rs.getInt("pord_id"), rs.getString("prod_name"), rs.getString("prod_category"), rs.getInt("prod_price"));
				productList.add(product);
			}
			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	
	
}
