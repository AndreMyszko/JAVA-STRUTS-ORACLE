package action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductDAO;
import pojo.Product;

public class WelcomeAction extends ActionSupport {

	List<Product> products;
	//filterAtts:
	private String productName;
	private String productCategory;
	private Date createdDate;
	
	public void initializeProducts() {
		System.out.println("Filter Data: ");
		System.out.println("name: " + productName);
		System.out.println("category: " + productCategory);
		System.out.println("created: " + createdDate);
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
