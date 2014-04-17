package edu.iiitb.action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import edu.iiitb.database.DBHandlerForUser;

public class ValidateEmailPassword extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1730670036276364518L;
private String email;
String message;
private Map session;
private String password;
DBHandlerForUser dbHandler = new DBHandlerForUser();

public String getEmail() 
{
	return email;
}

public void setEmail(String email) 
{
	this.email = email;
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

public Map getSession() {
	return session;
}

/**
 * @param session
 *            the session to set
 */
public void setSession(Map session) {
	this.session = session;
}




public String Validate() throws SQLException
{
	String compare;
	compare=dbHandler.chkForEmailID_PasswordAlreadyExists(getEmail(),getPassword());
	if(compare.equals("invalid"))
	{
		System.out.println(getEmail());
		message = "notavailable";
	}
	else
	{
		message="available";
	}
	System.out.println(message);

	return "success";

}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
