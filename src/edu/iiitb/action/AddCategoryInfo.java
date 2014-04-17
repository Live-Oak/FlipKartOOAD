/**
 * 
 */
package edu.iiitb.action;

import java.io.File;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.config.Config;
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
		
		Config.loadProperties();
		String destPath = Config.FILESTOREPATH;
		
		File destFile = new File(destPath,categoryInfo.getMyFileFileName());
		try {
			FileUtils.copyFile(categoryInfo.getMyFile(), destFile);
			categoryInfo.setCategoryImage("asset/Images/"+categoryInfo.getMyFileFileName());
		} catch (Exception e) {
			System.out.println("Exception at execute() of AddCategoryInfo .. Image uploading time");
			// TODO: handle exception
		}
		
		
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
