package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDAO;
import pojo.Product;

public class WelcomeAction extends ActionSupport {

	List<Product> products;
	
	public void initializeProducts() {
		products = ProductDAO.getAllProducts();
	}
	
	public String execute() {
		initializeProducts();
		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
