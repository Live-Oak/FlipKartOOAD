package edu.iiitb.action;
import edu.iiitb.model.*;
import edu.iiitb.database.*;

import java.sql.SQLException;

public class getUserAddressDetails 
{
	
	custometAddressDetail addressDetails = new custometAddressDetail();
	
	public custometAddressDetail getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(custometAddressDetail addressDetails) {
		this.addressDetails = addressDetails;
	}

	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String execute() throws SQLException
	{	
		DBHandlerForUser db = new DBHandlerForUser();		
		addressDetails = db.getUserAddressDetail(email);		
		return "success";
	}

}
