/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.Login;
import edu.iiitb.util.SendMailSSL;

/**
 * @author paras
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<Login>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4685471000633757714L;
	Login details = new Login();
	DBHandlerForUser dbHandler = new DBHandlerForUser();

	public String execute()
	{
		String role;
		try
		{
			role=dbHandler.chkForEmailID_PasswordAlreadyExists(details.getEmail(),details.getPassword());
					if(role.equals("invalid"))
					{
						System.out.println(role);
						return "invalid";
					}
					else if(role.equals("admin"))
						return "admin";
					else if(role.equals("user"))
						return "user";
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
