package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import pojo.Product;

public class ProductDAO {

	//params = filter logic attributes.
	public static List<Product> getAllProducts(String productName, String productCategory, String createdDate) {
		List<Product> productList = new ArrayList<Product>();
		
		String whereClause = "";
		if ((productName == null || productName.equals("")) && (productCategory == null || productCategory.equals("")) && (createdDate == null || createdDate.equals(""))) {
			whereClause = "";
		}else {
			whereClause = " WHERE ";
		}
		
		int count = 0;
		if (productName != null && !productName.equals("")) {
			count++;
			if (count != 1) {
				whereClause += " AND ";
			}
			whereClause += "prod_name = " + "'"+productName+"'";
		}
		if (productCategory != null && !productCategory.equals("")) {
			count++;
			if (count != 1) {
				whereClause += " AND ";
			}
			whereClause += "prod_category = " + "'"+productCategory+"'";
		}
		if (createdDate != null && !createdDate.equals("")) {
			count++;
			if (count != 1) {
				whereClause += " AND ";
			}
			whereClause += "created_date = " + "'"+createdDate+"'";
		}

		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			System.out.println("filter query: "+"SELECT * FROM C##DEV.TB_PRODUCT"+whereClause);
			ResultSet rs = st.executeQuery("SELECT * FROM C##DEV.TB_PRODUCT "+whereClause);
			while (rs.next()) {
				Product product = new Product(rs.getInt("pord_id"), rs.getString("prod_name"),
						rs.getString("prod_category"), rs.getInt("prod_price"), rs.getString("created_date"));
				productList.add(product);
			}
			// DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public static int addProduct(Product product) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO C##DEV.TB_PRODUCT VALUES(?,?,?,?,?)");
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			ps.setString(5, product.getCreatedDate());
			status = ps.executeUpdate();
			// DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Product getProductById(Integer productId) {
		Product product = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM C##DEV.TB_PRODUCT WHERE PORD_ID = ?");
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getInt("PORD_ID"), rs.getString("prod_name"), rs.getString("prod_category"),rs.getInt("prod_price"), rs.getString("created_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public static int updateProduct(Product product) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE C##DEV.TB_PRODUCT SET PROD_NAME=?, PROD_CATEGORY=?, PROD_PRICE=? WHERE PORD_ID=?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setInt(4, product.getProductId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteProduct(Integer productId) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM C##DEV.TB_PRODUCT WHERE PORD_ID=?");
			ps.setInt(1, productId);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	

}
