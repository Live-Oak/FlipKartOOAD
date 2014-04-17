package edu.iiitb.action;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.SignupModel;
import edu.iiitb.util.SendMailSSL;


public class SignupAction extends ActionSupport implements ModelDriven<SignupModel>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		String message;
		SignupModel userData = new SignupModel();
		DBHandlerForUser dbHandler = new DBHandlerForUser();
		
	/*	public void validate()
		{
			
/*			try
			{
				// Dont use else in  validate()
				if(dbHandler.chkForEmailIDAlreadyExists(userData.getEmail()))
					addFieldError("userId", "UserId already exists");
				/*else 
					addActionMessage("Registration successful");*/
	/*		}catch(SQLException e)
			{
				System.out.println(" Exception at validate() in RegisterUserAction.java ");
				e.printStackTrace();
			}
			
		}
		*/
		public void setMessage(String message)
		{
			this.message=message;
		}
		public String getMessage()
		{
			return message;
		}
		
		/*public String Validate() throws SQLException
		{
			boolean check;
			System.out.println(userData.getEmail());
					check = dbHandler.chkForEmailIDAlreadyExists(userData.getEmail());
					if (check) 
					{
						message = "Email already present";
						
					}
					else
					{
						
					}
				
			return "success";

		}

*/
public String execute() throws SQLException
		{
			if(dbHandler.chkForEmailIDAlreadyExists(userData.getEmail()))
			{
				message = "Email already present";
				
			}
			try {
				System.out.println(userData.getPincode());
				dbHandler.SignupUserinDB(userData);
				SendMailSSL.sendEmail(userData.getEmail(),userData.getFirstName());
				return "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error execute() of SignupUserAction.java ");
				e.printStackTrace();
				return "error";
			}
		
		}

		
		/**
		 * @return the userData
		 */
		public SignupModel getUserData() {
			return userData;
		}

		/**
		 * @param userData the userData to set
		 */
		public void setUserData(SignupModel userData) {
			this.userData = userData;
		}

		@Override
		public SignupModel getModel() {
			// TODO Auto-generated method stub
			return userData;
		}

	}


