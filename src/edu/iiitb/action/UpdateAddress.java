package edu.iiitb.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.User;
import edu.iiitb.model.UserEntry;


public class UpdateAddress extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	
	private String firstname,lastname,phonenumber,address1,address2,city,name;
	private int pincode;
	
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}	

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute() throws Exception{
		
		String[] splits = name.split(" ",2);
		firstname = splits[0];
		lastname = splits[1];
		
		
		
		User user1=(User) session.get("user");
		
		UserEntry user = new UserEntry();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPhonenumber(phonenumber);
		user.setEmail(user1.getEmail());
		user.setPinCode(pincode);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setCity(city);
		
		
		DBHandlerForUser dbHandler = new DBHandlerForUser();
		try {
			dbHandler.updateaddress(user);
			addActionMessage("Your address has been changed successfully.");
			return "success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
