/**
 * 
 */
package edu.iiitb.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.model.Login;

/**
 * @author paras
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<Login>{

	Login details = new Login();
	
	public String execute()
	{
		return "admin";
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
