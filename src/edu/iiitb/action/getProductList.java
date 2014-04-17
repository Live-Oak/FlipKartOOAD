<<<<<<< HEAD
package edu.iiitb.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.ProductInfo;

public class getProductList  extends ActionSupport 
{

	ArrayList<ProductInfo> productinfofilter;
	private String category;
	private int count;
	private String brand, price;
	private String[] brandnames;
	private String[] pricelist;
	private String categoryName;
	ArrayList<String> categoryList, categoryListtemp;
	
	
	public ArrayList<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}
	public ArrayList<String> getCategoryListtemp() {
		return categoryListtemp;
	}
	public void setCategoryListtemp(ArrayList<String> categoryListtemp) {
		this.categoryListtemp = categoryListtemp;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String[] getPricelist() {
		return pricelist;
	}
	public void setPricelist(String[] pricelist) {
		this.pricelist = pricelist;
	}
	public int getCount() {
		return count;
	}
	public String[] getBrandnames() {
		return brandnames;
	}
	public void setBrandnames(String[] brandnames) {
		this.brandnames = brandnames;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getCategory() {
		return category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public ArrayList<ProductInfo> getProductinfofilter() {
		return productinfofilter;
	}
	public void setProductinfofilter(ArrayList<ProductInfo> productinfofilter) {
		this.productinfofilter = productinfofilter;
	}
	
	public String getProductDetailprice()
	{
		categoryList = new ArrayList<String>();
		categoryListtemp = new ArrayList<String>();
		
		
		if(price != null)
			pricelist = price.split(",");
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			//System.out.println("Comapany to filter is : " +pricelist[count-1]);
			//System.out.println("Count is : "+count);
			
			categoryName = dbHandlerForUser.getnameonid(category);
			// get name on category
			
			categoryList.add(category);
			// add the first value to list
			
			categoryListtemp = dbHandlerForUser.getCategoryList(category);
			// get the sub category list for the first time
			
			
			if(categoryName.equalsIgnoreCase("Men") || categoryName.equalsIgnoreCase("Women"))
			{
				int count = categoryList.size();
				//System.out.println("Count is " +count);
				for(int i=1; i<count; i++)
				{
					categoryListtemp = dbHandlerForUser.getCategoryListwithcategory(categoryList.get(i), categoryName);
					if(categoryListtemp.size() > 0)
						categoryList.add(categoryListtemp.get(0));
				}
				// getting value for the level where we have to decide the path
				// adding it to the main side again
				
				// get the sub-sub category list if present
				for(int i=count-1; i<categoryList.size(); i++)
				{
					//System.out.println("It is here");
					categoryListtemp = dbHandlerForUser.getCategoryList(categoryList.get(i));
					if(categoryListtemp.size() > 0)
					{
						for(int j=0; j<categoryListtemp.size(); j++)
						{
							// add it to the main list
							categoryList.add(categoryListtemp.get(j));
						}
					}
				}
			}
			else
			{
				for(int i=0; i<categoryListtemp.size(); i++)
				{
					//System.out.println("value in category list is : " + categoryList.get(i));
					categoryList.add(categoryListtemp.get(i));
				}
				// add it to the main list
				for(int i=0; i<categoryList.size()-1; i++)
				{
					categoryListtemp = dbHandlerForUser.getCategoryList(categoryList.get(i+1));
					if(categoryListtemp.size() > 0)	
					{
						for(int j=0; j<categoryListtemp.size(); j++)
						{
							// add it to the main list
							categoryList.add(categoryListtemp.get(j));
						}
					}
				}
			}
			
			/*for(int i=0; i<categoryList.size(); i++)
				System.out.println("value in action "+categoryList.get(i));	*/
			
			productinfofilter = dbHandlerForUser.getproductlistoncategoryfilterprice(pricelist,categoryList,count);
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	}
	
	public String getProductDetail()
	{
		categoryList = new ArrayList<String>();
		categoryListtemp = new ArrayList<String>();
		
		if(brand != null)
			brandnames = brand.split(",");
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			//System.out.println("Comapany to filter is : " +brandnames[count-1]);
			//System.out.println("Count is : "+count);
			
			categoryName = dbHandlerForUser.getnameonid(category);
			// get name on category
			
			categoryList.add(category);
			// add the first value to list
			
			categoryListtemp = dbHandlerForUser.getCategoryList(category);
			// get the sub category list for the first time
			
			
			if(categoryName.equalsIgnoreCase("Men") || categoryName.equalsIgnoreCase("Women"))
			{
				int count = categoryList.size();
				//System.out.println("Count is " +count);
				for(int i=1; i<count; i++)
				{
					categoryListtemp = dbHandlerForUser.getCategoryListwithcategory(categoryList.get(i), categoryName);
					if(categoryListtemp.size() > 0)
						categoryList.add(categoryListtemp.get(0));
				}
				// getting value for the level where we have to decide the path
				// adding it to the main side again
				
				// get the sub-sub category list if present
				for(int i=count-1; i<categoryList.size(); i++)
				{
					//System.out.println("It is here");
					categoryListtemp = dbHandlerForUser.getCategoryList(categoryList.get(i));
					if(categoryListtemp.size() > 0)
					{
						for(int j=0; j<categoryListtemp.size(); j++)
						{
							// add it to the main list
							categoryList.add(categoryListtemp.get(j));
						}
					}
				}
			}
			else
			{
				for(int i=0; i<categoryListtemp.size(); i++)
				{
					//System.out.println("value in category list is : " + categoryList.get(i));
					categoryList.add(categoryListtemp.get(i));
				}
				// add it to the main list
				for(int i=0; i<categoryList.size()-1; i++)
				{
					categoryListtemp = dbHandlerForUser.getCategoryList(categoryList.get(i+1));
					if(categoryListtemp.size() > 0)	
					{
						for(int j=0; j<categoryListtemp.size(); j++)
						{
							// add it to the main list
							categoryList.add(categoryListtemp.get(j));
						}
					}
				}
			}
			
			/*for(int i=0; i<categoryList.size(); i++)
				System.out.println("value in action "+categoryList.get(i));*/	
			
			productinfofilter = dbHandlerForUser.getproductlistoncategoryfilter(brandnames,categoryList,count);
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	}
}
=======
package edu.iiitb.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.ProductInfo;

public class getProductList  extends ActionSupport 
{

	ArrayList<ProductInfo> productinfofilter;
	private String category;
	private int count;
	private String brand, price;
	private String[] brandnames;
	private String[] pricelist;
	private String categoryName;
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String[] getPricelist() {
		return pricelist;
	}
	public void setPricelist(String[] pricelist) {
		this.pricelist = pricelist;
	}
	public int getCount() {
		return count;
	}
	public String[] getBrandnames() {
		return brandnames;
	}
	public void setBrandnames(String[] brandnames) {
		this.brandnames = brandnames;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getCategory() {
		return category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public ArrayList<ProductInfo> getProductinfofilter() {
		return productinfofilter;
	}
	public void setProductinfofilter(ArrayList<ProductInfo> productinfofilter) {
		this.productinfofilter = productinfofilter;
	}
	
	public String getProductDetailprice()
	{
		if(price != null)
			pricelist = price.split(",");
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			System.out.println("Category id is : " +category);
			categoryName = dbHandlerForUser.getnameonid(category);
			System.out.println("Category Name is : " +categoryName);
			System.out.println("Count id is : " +count);
			System.out.println("Comapany to filter is : " +pricelist[count-1]);
			productinfofilter = dbHandlerForUser.getproductlistoncategoryfilterprice(pricelist,categoryName,count);
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	}
	
	public String getProductDetail()
	{
		if(brand != null)
			brandnames = brand.split(",");
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			productinfofilter = dbHandlerForUser.getproductlistoncategoryfilter(brandnames,category,count);
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	}
}
>>>>>>> branch 'master' of https://github.com/Live-Oak/FlipKartProject.git
