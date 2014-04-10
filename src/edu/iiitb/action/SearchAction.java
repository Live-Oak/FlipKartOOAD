package edu.iiitb.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.Linklists;
import edu.iiitb.model.ProductInfo;

public class SearchAction extends ActionSupport{

	ArrayList<ProductInfo> productinfo;
	String categoryname, catid;
	ArrayList<String> companyList;
	ArrayList<Linklists> linktoitem;

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}
	public ArrayList<Linklists> getLinktoitem() {
		return linktoitem;
	}

	public void setLinktoitem(ArrayList<Linklists> linktoitem) {
		this.linktoitem = linktoitem;
	}

	public ArrayList<String> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(ArrayList<String> companyList) {
		this.companyList = companyList;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public ArrayList<ProductInfo> getProductinfo() {
		return productinfo;
	}

	public void setProductinfo(ArrayList<ProductInfo> productinfo) {
		this.productinfo = productinfo;
	}
	
	public String execute()
	{
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			//System.out.println("categoryname in action : " +categoryname);
			productinfo = dbHandlerForUser.getproductlistoncategory(categoryname); 
			// To get the List of all the product and their details
			linktoitem = dbHandlerForUser.getlinktothecategory(categoryname);
			// To get the links for the side results
			companyList = dbHandlerForUser.getCompanylistoncategory(categoryname);
			// To get the List of all the company for the following product
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	}
}
