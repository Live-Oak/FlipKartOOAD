package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import edu.iiitb.database.DBHandlerforComparison;
import edu.iiitb.model.CompareProductsModel;

public class CompareProducts extends ActionSupport 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private int count;
	private ArrayList<CompareProductsModel> products;
	
	public CompareProducts(int productId, ArrayList<CompareProductsModel> products)
	{
		super();
		this.setProductId(productId);
		this.setProducts(products);
	}
	public CompareProducts() 
	{
		
	} 
	public String getProductDetails() throws SQLException
	{
		System.out.println(getProductId());
		setProducts(DBHandlerforComparison.getProducts(getProductId()));
		count=products.size();
		return "success";
	}

	public int getProductId() 
	{
		return productId;
	}

	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
	
	public ArrayList<CompareProductsModel> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<CompareProductsModel> products) {
		this.products = products;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
