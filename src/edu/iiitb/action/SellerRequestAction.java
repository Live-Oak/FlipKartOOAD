/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForAdmin;
import edu.iiitb.model.ViewRequestSeller;

/**
 * @author paras
 *
 */
public class SellerRequestAction extends ActionSupport{

	ArrayList<ViewRequestSeller> request ;
	int customerId , productId , purchaseQty;
	/**
	 * @return the request
	 */
	public ArrayList<ViewRequestSeller> getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(ArrayList<ViewRequestSeller> request) {
		this.request = request;
	}
	
	
	
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

	/**
	 * @return the purchaseQty
	 */
	public int getPurchaseQty() {
		return purchaseQty;
	}

	/**
	 * @param purchaseQty the purchaseQty to set
	 */
	public void setPurchaseQty(int purchaseQty) {
		this.purchaseQty = purchaseQty;
	}

	public String execute()
	{
		request = new ArrayList<ViewRequestSeller>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try {
			dbHandler.fetchPurchaseProductRequestForAdmin(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at execute() of SellerRequestAction.java");
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	public String approveRequest()
	{
		request = new ArrayList<ViewRequestSeller>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try {
			dbHandler.deleteProductPurchaseEntry(getProductId() , getCustomerId());
			dbHandler.updateProductQuantity(getProductId() , getPurchaseQty() ,getCustomerId());
			dbHandler.fetchPurchaseProductRequestForAdmin(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at approveRequest() of SellerRequestAction.java");
			e.printStackTrace();
			return "error";
		}
		addActionMessage("Request Approved Successfully");
		return "success";
	}
	
	public String rejectRequest()
	{
		request = new ArrayList<ViewRequestSeller>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try {
			dbHandler.deleteProductPurchaseEntry(getProductId() , getCustomerId());
			dbHandler.fetchPurchaseProductRequestForAdmin(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at rejectRequest() of SellerRequestAction.java");
			e.printStackTrace();
			return "error";
		}
		addActionMessage("Request Rejected Successfully");
		
		return "success";
	}
	
}
