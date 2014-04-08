package edu.iiitb.action;

import java.util.ArrayList;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.ProductInfo;

public class CompareAction
{
	private int productId;
	ArrayList<Integer> pid= new ArrayList <Integer>(); 
	ArrayList<ProductInfo> productinfo=new ArrayList<ProductInfo>();
	ArrayList<String> description;
	public ArrayList<String> getDescription() {
		return description;
	}
	public void setDescription(ArrayList<String> Description) {
		description = Description;
	}

	public ArrayList<ProductInfo> getProductinfo() {
		return productinfo;
	}
	public void setProductinfo(ArrayList<ProductInfo> productinfo) {
		this.productinfo = productinfo;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductID(int productId) {
		this.productId = productId;
	}

	public String execute()
	{
		System.out.println("fisrt");
		pid.add(1);
		pid.add(2);
		//pid.add(3);
		DBHandlerForUser dbHandlerForUser = new DBHandlerForUser();
		try
		{
			for(int i=0;i<pid.size();i++)
			{
			productinfo.add(dbHandlerForUser.getproductinfoforcomparison(pid.get(i)));
			}
			System.out.println("size of the product"+productinfo.size());
			for(int i=0;i<productinfo.size();i++)
			{
				System.out.println(productinfo.get(i).getAvailableQuantity());
			}
		}
		catch(Exception e)
		{
			System.out.println("Error Search Action "+e);
			return "error";
		}
		return "success";
	
	}
	
}
