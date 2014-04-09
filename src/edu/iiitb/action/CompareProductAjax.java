package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.database.DBHandlerForUser;

import edu.iiitb.model.ProductInfo;

public class CompareProductAjax 
{
	private String productname;
	private String productId;
	private int count;
	ArrayList<ProductInfo> productInfoAdded=new ArrayList<ProductInfo>();

	public CompareProductAjax(String productname, ArrayList<ProductInfo> productInfoAdded)
	{
		super();
		this.setProductId(productId);
		this.setProductInfoAdded(productInfoAdded);
	}
	public CompareProductAjax() 
	{
		
	} 

	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public String getProductDetail() throws SQLException
	{
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		System.out.println("kwhdk");
		System.out.println("product nbame is"+productname);
		setProductInfoAdded(dbHandlerForUser.getProductInfoByName(productname));
		System.out.println(productInfoAdded.get(0).getImage());
		count=productInfoAdded.size();
		return "success";
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public ArrayList<ProductInfo> getProductInfoAdded() {
		return productInfoAdded;
	}
	public void setProductInfoAdded(ArrayList<ProductInfo> productInfoAdded) {
		this.productInfoAdded = productInfoAdded;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
