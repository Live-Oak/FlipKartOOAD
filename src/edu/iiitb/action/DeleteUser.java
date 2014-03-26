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
	
	int id;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String execute()
	{
		DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
		try {
			dbHandler.deleteUserFromDB(getId());
			addActionMessage("User Has Been Deleted Successfully");
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
	}

}
