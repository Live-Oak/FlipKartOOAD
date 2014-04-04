package edu.iiitb.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.ProductInfo;

public class BrowseAction extends ActionSupport 
{
	ArrayList<ProductInfo> productinfo;
	String keyword;
	ArrayList<String> companyList;
	
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
			//System.out.println("keyword in action : " +keyword);
			productinfo = dbHandlerForUser.getproductlist(keyword);
			companyList = dbHandlerForUser.getCompanylist(keyword);
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	}
}
