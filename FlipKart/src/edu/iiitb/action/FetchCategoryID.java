/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.database.DBHandlerForAdmin;

/**
 * @author paras
 *
 */
public class FetchCategoryID {
	
	ArrayList<String> categoryId;
 	
	
	/**
	 * @return the categoryId
	 */
	public ArrayList<String> getCategoryId() {
		return categoryId;
	}


	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(ArrayList<String> categoryId) {
		this.categoryId = categoryId;
	}


	public String execute()
	{
		categoryId = new ArrayList<String>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		
		try {
			dbHandler.fetchCategoryID(categoryId);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at execute() of FetchCategoryID.java ");
			e.printStackTrace();
			return "error";
		}
		
		
	}

}
