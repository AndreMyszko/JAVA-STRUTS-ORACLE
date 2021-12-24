package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDAO;
import pojo.Product;

public class UpdateDataAction extends ActionSupport{
	
	Integer productId;
	String productName;
	String ProductCategory;
	Integer productPrice;
	
	public String execute() {
		Product product = ProductDAO.getProductById(productId);
		productId = product.getProductId();
		productName = product.getProductName();
		ProductCategory = product.getProductCategory();
		productPrice = product.getProductPrice();
		return "success";
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
}
