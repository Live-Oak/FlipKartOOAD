package edu.iiitb.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.*;

public class placeOrderUserSessionCheck extends ActionSupport implements SessionAware
{
	custometAddressDetail addressDetails = new custometAddressDetail();
	private Map session;
	ArrayList<customerCartDetail> cartDetailsList = new ArrayList<customerCartDetail>();
	
	public ArrayList<customerCartDetail> getCartDetailsList() {
		return cartDetailsList;
	}
	public void setCartDetailsList(ArrayList<customerCartDetail> cartDetailsList) {
		this.cartDetailsList = cartDetailsList;
	}
	public custometAddressDetail getAddressDetails() {
		return addressDetails;
	}
	public void setCustomerAddress(custometAddressDetail addressDetails) {
		this.addressDetails = addressDetails;
	}
		
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	
	
	public String execute() throws SQLException
	{	
		User user;
		user = (User) session.get("user");
		if (user.getEmail() != null)
		{
			addressDetails.setEmail(user.getEmail());					
			DBHandlerForUser db = new DBHandlerForUser();		
			addressDetails = db.getUserAddressDetail(addressDetails.getEmail());			
			cartDetailsList = db.getCartDetail(addressDetails.getEmail());
		}
		for (customerCartDetail cart : cartDetailsList) {			
			System.out.println("Inside Action Starts");
			System.out.println(" Image Path : " +cart.getImage());
			System.out.println(" Name Path : " +cart.getProductName());	
			System.out.println(" Price Path : " +cart.getPrice());	
			System.out.println(" Quality Path : " +cart.getQuantity());	
			System.out.println("Inside Action Ends");
		}
		return "success";
	}
}
