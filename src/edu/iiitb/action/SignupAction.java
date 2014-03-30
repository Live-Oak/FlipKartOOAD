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

	
		SignupModel userData = new SignupModel();
		DBHandlerForUser dbHandler = new DBHandlerForUser();
		
		public void validate()
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
		*/	
		}
		
		
		public String execute() throws SQLException
		{
			if(dbHandler.chkForEmailIDAlreadyExists(userData.getEmail()))
				return "invalid";
			
			try {
				dbHandler.SignupUserinDB(userData);
				SendMailSSL.sendEmail(userData.getEmail(),userData.getFirstName());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error execute() of RegisterUserAction.java ");
				e.printStackTrace();
				return "error";
			}
			return "success";
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

