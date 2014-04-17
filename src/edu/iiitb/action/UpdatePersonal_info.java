package edu.iiitb.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.User;
import edu.iiitb.model.UserEntry;
import edu.iiitb.util.SendMailSSL;


public class UpdatePersonal_info extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	
	private String firstname,lastname,mobilenumber,landlinenumber,gender;
	private String newpassword;
	private String newEmail;
	

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

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
	
	
public String executepasswordchange() throws Exception{
		
		User user1=(User) session.get("user");
		
		UserEntry user = new UserEntry();
		user.setPassword(newpassword);
		user.setEmail(user1.getEmail());
		
		
		DBHandlerForUser dbHandler = new DBHandlerForUser();
		try {
			dbHandler.updatepassword(user);
			addActionMessage("Your password has been changed successfully.");
			return "success";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
public String executeupdateemail() throws Exception{
	
	User user1=(User) session.get("user");
	String fname=(String) session.get("fname");
	UserEntry user = new UserEntry();
	user.setNewemail(newEmail);
	user.setEmail(user1.getEmail());
	
	
	DBHandlerForUser dbHandler = new DBHandlerForUser();
	try {
		dbHandler.updateemail(user);
		addActionMessage("Your Email has been changed successfully.");
		SendMailSSL.sendUpdatedEmail(newEmail,fname);
		return "success";
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "error";
	}
}


}
