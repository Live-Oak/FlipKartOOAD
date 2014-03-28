/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.database.DBHandlerForAdmin;

/**
 * @author paras
 *
 */
public class FetchUserIDForDelete {

	// Used for ID_Role
	ArrayList<String> userID;
	
	/**
	 * @return the userID
	 */
	public ArrayList<String> getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(ArrayList<String> userID) {
		this.userID = userID;
	}

	public String execute()
	{
		userID =  new ArrayList<String>();
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try {
			dbHandler.fetchUserIdWithRole(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception at execute() of FetchUserIDForDelete.java ");
			e.printStackTrace();
			return "error";
		}
		return "success";
	}



	
	
	
}
