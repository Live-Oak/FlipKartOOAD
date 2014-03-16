/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.database.DBHandlerForAdmin;
import edu.iiitb.model.CategoryModel;

/**
 * @author paras
 *
 */
public class AddCategoryInfo extends ActionSupport implements ModelDriven<CategoryModel>{

	CategoryModel categoryInfo = new CategoryModel();
	DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
	
	public void validate()
	{
		try {
			if(dbHandler.chkForCategoryIDAlreadyExists(categoryInfo.getCategoryId()))
				addFieldError("categoryId", "CategoryId already exists");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at validate() of AddCategoryInfo.java");
			e.printStackTrace();
		}
	}
	
	public String execute()
	{
		try {
			dbHandler.addCategoryinDB(categoryInfo);
			addActionMessage("Category Inserted Successfully");
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at execute() of AddCategoryInfo.java");
			e.printStackTrace();
			return "error";
		}
		
		
	}
	
	
	/**
	 * @return the categoryInfo
	 */
	public CategoryModel getCategoryInfo() {
		return categoryInfo;
	}


	/**
	 * @param categoryInfo the categoryInfo to set
	 */
	public void setCategoryInfo(CategoryModel categoryInfo) {
		this.categoryInfo = categoryInfo;
	}


	@Override
	public CategoryModel getModel() {
		// TODO Auto-generated method stub
		return categoryInfo;
	}

}
