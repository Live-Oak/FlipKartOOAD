package edu.iiitb.action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import edu.iiitb.database.DBHandlerForUser;

public class UserAvailabilityAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1730670036276364518L;
private String email;
String message;
private Map session;

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
	String email = (String) session.get("email");
	System.out.println("kdnvksndvknbdsvkbk");
	System.out.println(getEmail());
	System.out.println(email);
	if(dbHandler.chkForEmailIDAlreadyExists(getEmail()))
	{
		System.out.println(getEmail());
		message = "Email already present";
	}
		message="use it!!";
	return "success";

}
}
