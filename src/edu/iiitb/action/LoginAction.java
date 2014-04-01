/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.Login;
import edu.iiitb.util.SendMailSSL;

public class LoginAction extends ActionSupport implements ModelDriven<Login>, SessionAware{

	/**
	 * 
	 */
	private Map session;

	private static final long serialVersionUID = 4685471000633757714L;
	Login details = new Login();
	DBHandlerForUser dbHandler = new DBHandlerForUser();
	private String message;

	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}


	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String execute()
	{
		String role;
		try
		{
			System.out.println(details.getEmail()+details.getPassword());
			role=dbHandler.chkForEmailID_PasswordAlreadyExists(details.getEmail(),details.getPassword());
					if(role.equals("admin"))
						return "admin";
					else if(role.equals("user"))
					{
						System.out.println("hfhjgjhghjghghgvghv");
						try
						{
						String fname=dbHandler.getfName(details.getEmail());
						System.out.println(fname);
						session.put("fname",fname);
						return "user";
						}
						catch(Exception e)
						{
							System.out.println(e);
							return "error";
						}

					}
					else
						return "seller";
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error execute() of RegisterUserAction.java ");
			e.printStackTrace();
			return "error";
		}
		
	}
	
	
	
	
	/**
	 * @return the details
	 */
	public Login getDetails() {
		return details;
	}


	/**
	 * @param details the details to set
	 */
	public void setDetails(Login details) {
		this.details = details;
	}


	@Override
	public Login getModel() {
		// TODO Auto-generated method stub
		return details;
	}

}
