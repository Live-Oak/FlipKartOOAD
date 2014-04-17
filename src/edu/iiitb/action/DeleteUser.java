/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForAdmin;

/**
 * @author paras
 *
 */
public class DeleteUser extends ActionSupport{
	
	String id;
	
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	public String execute()
	{
		// This array is used because in the dropDown list userId and Role are seprated by a '_'
		
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try {
			String[] idRole=getId().split("_");
			dbHandler.deleteUserFromDB(Integer.parseInt(idRole[0]));
			addActionMessage("User Has Been Deleted Successfully");
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
	}

}
