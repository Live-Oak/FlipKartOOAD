/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.config.Config;
import edu.iiitb.database.DBHandlerForAdmin;
import edu.iiitb.model.UserEntry;
import edu.iiitb.util.SendMailSSL;

/**
 * @author paras
 *
 */
public class RegisterUserAction extends ActionSupport implements ModelDriven<UserEntry>{

	UserEntry userData = new UserEntry();
	DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
	
	public void validate()
	{
		
		try
		{
			// Dont use else in  validate()
			if(dbHandler.chkForEmailIDAlreadyExists(userData.getEmail()))
				addFieldError("userId", "UserId already exists");
			/*else 
				addActionMessage("Registration successful");*/
		}catch(SQLException e)
		{
			System.out.println(" Exception at validate() in RegisterUserAction.java ");
			e.printStackTrace();
		}
		
	}
	
	
	public String execute()
	{
		
		try {
			dbHandler.registerUserinDB(userData);
			SendMailSSL.sendEmail(userData.getEmail(),userData.getFirstName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error execute() of RegisterUserAction.java ");
			e.printStackTrace();
			return "error";
		}
		addActionMessage("Registration successful. Message has been sent to your email id");
		return "success";
	}

	
	/**
	 * @return the userData
	 */
	public UserEntry getUserData() {
		return userData;
	}

	/**
	 * @param userData the userData to set
	 */
	public void setUserData(UserEntry userData) {
		this.userData = userData;
	}

	@Override
	public UserEntry getModel() {
		// TODO Auto-generated method stub
		return userData;
	}

}
