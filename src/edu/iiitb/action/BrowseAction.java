package edu.iiitb.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.Linklists;
import edu.iiitb.model.ProductInfo;

public class BrowseAction extends ActionSupport 
{
	ArrayList<ProductInfo> productinfo;
	String keyword;
	ArrayList<String> companyList;
	ArrayList<Linklists> linktoitem;
	String catid, categoryname ;

	
	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

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


	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
			catid = dbHandlerForUser.getcategoryId(keyword);
			// get the id of product
			categoryname = dbHandlerForUser.getnameonid(catid);
			// get the name of product on id
			linktoitem = dbHandlerForUser.getlinktothecategory(categoryname);
			// To get the links for the side results
			productinfo = dbHandlerForUser.getproductlist(keyword);
			// get the list of products
			companyList = dbHandlerForUser.getCompanylist(keyword);
			// get the list of company
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	}
}
