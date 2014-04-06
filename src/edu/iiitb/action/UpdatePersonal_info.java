package edu.iiitb.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.User;
import edu.iiitb.model.UserEntry;


public class UpdatePersonal_info extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	
	private String firstname,lastname,mobilenumber,landlinenumber,gender;
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getLandlinenumber() {
		return landlinenumber;
	}

	public void setLandlinenumber(String landlinenumber) {
		this.landlinenumber = landlinenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute() throws Exception{
		
		User user1=(User) session.get("user");
		
		UserEntry user = new UserEntry();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPhonenumber(mobilenumber);
		user.setEmail(user1.getEmail());
		user.setGender(gender);
		
		DBHandlerForUser dbHandler = new DBHandlerForUser();
		try {
			dbHandler.updatepersonalinfo(user);
			addActionMessage("Your changes have been saved successfully.");
			return "success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	

}
