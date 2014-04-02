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
import edu.iiitb.model.User;
import edu.iiitb.util.SendMailSSL;

public class LoginAction extends ActionSupport implements ModelDriven<Login>, SessionAware
{

	/**
	 * 
	 */
	private Map<String, Object> session;

	private static final long serialVersionUID = 4685471000633757714L;
	Login details = new Login();
	DBHandlerForUser dbHandler = new DBHandlerForUser();
	private String message;

	public Map getSession() {
		return session;
	}
	public void setSession(Map<String , Object> session) 
	{
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
		String compare;
		
		try
		{
/*			System.out.println(details.getEmail()+details.getPassword());
			role=dbHandler.chkForEmailID_PasswordAlreadyExists(details.getEmail(),details.getPassword());
			System.out.println(role);		
			/*if(role.equals("admin"))
						return "admin";*/
					/*if(role.equals("user"))
					{*/
						User l = (User)session.get("user");
						System.out.println("session"+l);
						if(l!=null)
						{
							System.out.println("yahan se uthaya");
							String fname=dbHandler.getfName(details.getEmail());
							System.out.println(fname);
							session.put("fname",fname);
							return "user";
						}
						else
						{
							compare=dbHandler.chkForEmailID_PasswordAlreadyExists(details.getEmail(),details.getPassword());
							if(compare.equals("invalid"))
							{
								return "error";
							}
							else
							{
								User l1=new User(details.getEmail(),details.getPassword());
								System.out.println(details.getEmail()+details.getPassword());
								System.out.println("session "+l1.getEmail()+l1.getPassword());
								session.put("user",l1);
								System.out.println("session"+l1);
								System.out.println("hfhjgjhghjghghgvghv");
								try
								{
									if(compare.equals("user"))
									{
										String fname=dbHandler.getfName(details.getEmail());
										System.out.println(fname);
										session.put("fname",fname);
										return "user";
									}
									else if(compare.equals("admin"))
									{
										return "admin";
									}
									else
									{
										return "seller";
									}
								}
								catch(Exception e)
								{
									System.out.println(e);
									return "error";
								}
							}
						}
					//}
					/*else
						return "seller";*/
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
