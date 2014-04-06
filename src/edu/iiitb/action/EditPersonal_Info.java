package edu.iiitb.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.User;
import edu.iiitb.model.UserEntry;






public class EditPersonal_Info extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	
	private UserEntry user = new UserEntry();
	

	public UserEntry getUser() {
		return user;
	}
	public void setUser(UserEntry user) {
		this.user = user;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map<String , Object> session) 
	{
		this.session = session;
	}
	
	public String execute()
	{
		User user1=(User) session.get("user");
		System.out.println("ghfhgfghfhgfgfhgfvhgvhgvhgvhgvhgbvgf "+user1.getEmail());
		DBHandlerForUser dbHandler = new DBHandlerForUser();
		try {
			user = dbHandler.getpersonalinfo(user1.getEmail());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		
		
		
		
		return "success";
	}
	
	
}



