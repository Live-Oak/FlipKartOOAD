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
public class FetchSubCategoryId {

	String categoryId;
	ArrayList<String> subCategoryId;
	/**
	 * @return the subCategoryId
	 */
	public ArrayList<String> getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSubCategoryId(ArrayList<String> subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String execute()
	{
		String[] idRole = getCategoryId().split("_");
		subCategoryId = new ArrayList<String>();
		DBHandlerForAdmin dbhandler = new DBHandlerForAdmin();
		try {
			dbhandler.fetchSubCategoryId(subCategoryId,idRole[0]);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at execute() of FetchSubCategoryId.java");
			e.printStackTrace();
			return "error";
		}
		
	}
	
}
