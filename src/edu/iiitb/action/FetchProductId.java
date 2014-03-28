package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.database.DBHandlerForAdmin;

public class FetchProductId {

	ArrayList<String> productId;
	
	/**
	 * @return the productId
	 */
	public ArrayList<String> getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(ArrayList<String> productId) {
		this.productId = productId;
	}
	
	public String execute()
	{
		productId = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> pName = new ArrayList<String>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		
		try {
			dbHandler.fetchProductID(id);
			dbHandler.fetchProductName(pName);
			for(int i = 0;i<pName.size();i++)
			{
				productId.add(id.get(i)+"_"+pName.get(i));
			}
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at execute() of FetchCategoryID.java ");
			e.printStackTrace();
			return "error";
		}
	}
	
}
