package edu.iiitb.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.util.SendMailSSL;

public class ForgotPasswordAction extends ActionSupport
{
	
private String email;
private String password;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DBHandlerForUser dbHandler = new DBHandlerForUser();
	
	public String execute() throws SQLException
	{	
		String password;
		System.out.println(getEmail());
		if(dbHandler.chkForEmailIDAlreadyExists(getEmail()))
		{
			System.out.println("skdhnkvhnkjvn");
			password=dbHandler.getPasswordformDB(getEmail());
			System.out.println(password);

			SendMailSSL.sendPassword(getEmail(),password);
			return "success";

		}
			else
		{
				System.out.println("hello");
				return "invalid";

		}
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
