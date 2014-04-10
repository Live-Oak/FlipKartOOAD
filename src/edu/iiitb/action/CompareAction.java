package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.json.JSONPopulator;
import org.apache.struts2.json.JSONUtil;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.database.DBHandlerforComparison;
import edu.iiitb.model.CompareCartCookie;
import edu.iiitb.model.CompareProductsModel;
import edu.iiitb.model.ProductInfo;

public class CompareAction
{
	private int productId;
	private String productname;
	String message;
	private int count;
	ArrayList<Integer> pid= new ArrayList <Integer>(); 
	ArrayList<ProductInfo> productinfo=new ArrayList<ProductInfo>();
	ArrayList<String> description;
	ArrayList<ProductInfo> productInfoAdded=new ArrayList<ProductInfo>();
	
	public ArrayList<String> getCategoryproducts() {
		return categoryproducts;
	}
	public void setCategoryproducts(ArrayList<String> categoryproducts) {
		this.categoryproducts = categoryproducts;
	}

	ArrayList<String> categoryproducts;
	
	public ArrayList<String> getDescription() {
		return description;
	}
	public void setDescription(ArrayList<String> Description) {
		description = Description;
	}

	public ArrayList<ProductInfo> getProductinfo() {
		return productinfo;
	}
	public void setProductinfo(ArrayList<ProductInfo> productinfo) {
		this.productinfo = productinfo;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductID(int productId) {
		this.productId = productId;
	}

	public String execute()
	{
		pid.add(1);
		pid.add(2);
		//pid.add(3);
		int categoryId=7;
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			for(int i=0;i<pid.size();i++)
			{
			productinfo.add(dbHandlerForUser.getproductinfoforcomparison(pid.get(i)));
			}
			System.out.println("size of the product"+productinfo.size());
			for(int i=0;i<productinfo.size();i++)
			{
				System.out.println(productinfo.get(i).getAvailableQuantity());
			}
			System.out.println("firstwala");
			categoryproducts=dbHandlerForUser.getproductsforcomparison(categoryId);
			System.out.println("secondwala");
			for(String i : categoryproducts)
			System.out.println(i);
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	
	}
	
	
	/*
	
	public String getCartProducts() {
			try {

				String content = null;
				boolean cookieFound = false;
				
				for (Cookie c : servletRequest.getCookies()) {
					if (c.getName().equals("comparecart")) {
						content = c.getValue();
						CompareCartCookie cookie = new CompareCartCookie();
						 JSONPopulator pop = new JSONPopulator();
						Map< ?, ?> map = (Map< ?, ?>)	JSONUtil
								.deserialize(content);
						 pop.populateObject(cookie, map);
						products = DBHandlerforComparison.getProductsFromCompareCart(cookie.getProductList());
						cookieFound = true;
						break;
					}
				}
				if(cookieFound == false)
				{
					products = new ArrayList<CompareProductsModel>();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		
		count = products.size();
		return "success";
	}

	
	*/
	
	
	/*public String getProductDetails() throws SQLException
	{
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		System.out.println("kwhdk");
		System.out.println("product nbame is"+productname);
		productInfoAdded=dbHandlerForUser.getProductInfoByName(productname);
		count=productInfoAdded.size();
		for(ProductInfo i : productInfoAdded)
		{
			System.out.println(i.getImage());
		}
		return "success";
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}*/
	
}
