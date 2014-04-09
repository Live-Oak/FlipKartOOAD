package edu.iiitb.action;
import java.sql.SQLException;
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
	{	System.out.println("Bada Wala Bazinga...123");
		User user;
		user = (User) session.get("user");
		if (user.getEmail() != null)
		{
			addressDetails.setEmail(user.getEmail());		
			System.out.println("Session email is : " + addressDetails.getEmail());			
			DBHandlerForUser db = new DBHandlerForUser();		
			addressDetails = db.getUserAddressDetail(addressDetails.getEmail());
			System.out.println("Bada Wala Bazinga...");
		}
		return "success";
	}
}
