package edu.iiitb.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.Advertizement;
import edu.iiitb.model.CategoryModel;

public class StartAction extends ActionSupport 
{
	ArrayList<Advertizement> advertizement;
	ArrayList<CategoryModel> categoryModel1, categoryModel2, categoryModel3, categoryModel4, categoryModel5, categoryModel6, categoryModel7;

	int category;

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	public ArrayList<CategoryModel> getCategoryModel4() {
		return categoryModel4;
	}

	public void setCategoryModel4(ArrayList<CategoryModel> categoryModel4) {
		this.categoryModel4 = categoryModel4;
	}

	public ArrayList<CategoryModel> getCategoryModel5() {
		return categoryModel5;
	}

	public void setCategoryModel5(ArrayList<CategoryModel> categoryModel5) {
		this.categoryModel5 = categoryModel5;
	}

	public ArrayList<CategoryModel> getCategoryModel6() {
		return categoryModel6;
	}

	public void setCategoryModel6(ArrayList<CategoryModel> categoryModel6) {
		this.categoryModel6 = categoryModel6;
	}

	public ArrayList<CategoryModel> getCategoryModel7() {
		return categoryModel7;
	}

	public void setCategoryModel7(ArrayList<CategoryModel> categoryModel7) {
		this.categoryModel7 = categoryModel7;
	}

	public ArrayList<CategoryModel> getCategoryModel1() {
		return categoryModel1;
	}

	public void setCategoryModel1(ArrayList<CategoryModel> categoryModel1) {
		this.categoryModel1 = categoryModel1;
	}

	public ArrayList<CategoryModel> getCategoryModel2() {
		return categoryModel2;
	}

	public void setCategoryModel2(ArrayList<CategoryModel> categoryModel2) {
		this.categoryModel2 = categoryModel2;
	}

	public ArrayList<CategoryModel> getCategoryModel3() {
		return categoryModel3;
	}

	public void setCategoryModel3(ArrayList<CategoryModel> categoryModel3) {
		this.categoryModel3 = categoryModel3;
	}

	public ArrayList<Advertizement> getAdvertizement() {
		return advertizement;
	}

	public void setAdvertizement(ArrayList<Advertizement> advertizement) {
		this.advertizement = advertizement;
	}
	
	public String execute()
	{

		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
	
		try
		{
			advertizement = dbHandlerForUser.getadvertizement();
		}
		catch(Exception e)
		{
			System.out.println("Error Start Action "+e);
			return "error";
		}
		
		return "success";
	}
	
	public String getMenuCatagory()
	{
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			categoryModel1 = dbHandlerForUser.getsubcategorylist(category);
			categoryModel2 = dbHandlerForUser.getsubcategorylist(category);
			categoryModel3 = dbHandlerForUser.getsubcategorylist(category);
			categoryModel4 = dbHandlerForUser.getsubcategorylist(category);
			categoryModel5 = dbHandlerForUser.getsubcategorylist(category);
			categoryModel6 = dbHandlerForUser.getsubcategorylist(category);
			categoryModel7 = dbHandlerForUser.getsubcategorylist(category);
		}
		catch(Exception e)
		{
			
		}
		return "success";
	}
	
	
}
