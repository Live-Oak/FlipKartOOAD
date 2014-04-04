/**
 * 
 */
package edu.iiitb.action;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.database.DBHandlerForAdmin;
import edu.iiitb.model.CategoryModel;
import edu.iiitb.model.ProductInfo;
import edu.iiitb.model.UserEntry;

/**
 * @author paras
 *
 */
public class FetchDatabaseInfo {

	ArrayList<UserEntry> user;
	ArrayList<ProductInfo> product;
	ArrayList<CategoryModel> category;
	ArrayList<String> sellerId;
	

	

<<<<<<< HEAD

	

=======
>>>>>>> 0c1587c4b28ced6c00506c953c657456b19a5cfb
	public String execute() {
		
		user = new ArrayList<UserEntry>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try
		{
			dbHandler.viewUserData(user);
		}catch(SQLException e)
		{
			System.out.println("Exception at execute() of FetchUser.java");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String productFetch()
	{
		product = new ArrayList<ProductInfo>();
<<<<<<< HEAD
		sellerId = new ArrayList<String>();
=======
		
>>>>>>> 0c1587c4b28ced6c00506c953c657456b19a5cfb
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try
		{
			dbHandler.viewProductData(product);
<<<<<<< HEAD
			dbHandler.fetchIdForGivenRole(sellerId , "Seller");
			for(int i = 0;i<sellerId.size();i++)
				System.out.println("Seller id is :: "+sellerId.get(i));
=======
			
				
>>>>>>> 0c1587c4b28ced6c00506c953c657456b19a5cfb
		}catch(SQLException e)
		{
			System.out.println("Exception at productFetch() of FetchUser.java");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String categoryFetch()
	{
		category = new ArrayList<CategoryModel>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try
		{
			dbHandler.viewCategoryData(category);
		}catch(SQLException e)
		{
			System.out.println("Exception at categoryFetch() of FetchUser.java");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String subCategoryFetch()
	{
		category = new ArrayList<CategoryModel>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try
		{
			dbHandler.viewSubCategoryData(category);
		}catch(SQLException e)
		{
			System.out.println("Exception at subCategoryFetch() of FetchUser.java");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	

<<<<<<< HEAD
	/**
	 * @return the sellerId
	 */
	public ArrayList<String> getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(ArrayList<String> sellerId) {
		this.sellerId = sellerId;
	}
=======

>>>>>>> 0c1587c4b28ced6c00506c953c657456b19a5cfb
	
	/**
	 * @return the user
	 */
	public ArrayList<UserEntry> getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(ArrayList<UserEntry> user) {
		this.user = user;
	}
	
	/**
	 * @return the product
	 */
	public ArrayList<ProductInfo> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ArrayList<ProductInfo> product) {
		this.product = product;
	}
	
	/**
	 * @return the category
	 */
	public ArrayList<CategoryModel> getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(ArrayList<CategoryModel> category) {
		this.category = category;
	}

}
