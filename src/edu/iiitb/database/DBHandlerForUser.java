	package edu.iiitb.database;

	import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

	import com.mysql.jdbc.Connection;

	import edu.iiitb.model.Advertizement;
import edu.iiitb.model.CategoryModel;
import edu.iiitb.model.ProductInfo;
import edu.iiitb.model.SignupModel;
import edu.iiitb.model.UserEntry;

	/**
	 * @author paras
	 *
	 */
public class DBHandlerForUser {

	/**
	 * 
	 */
		DBConnectivity db=new DBConnectivity();
		Connection con = db.createConnection();
		
		public boolean chkForEmailIDAlreadyExists(String email) throws SQLException
		{
			String query="select email from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
					return true;
			}
			return false;
		}
		
		public boolean SignupUserinDB(SignupModel user) throws SQLException
		{	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String date = sdf.format(new java.util.Date());
			System.out.println(date);
			System.out.println(user.getDate());
			String[] splitedDate=user.getDate().split("T");
			String query="INSERT INTO UserCredantials(`firstName`,`lastName`,`password`,`role`,`dateOfBirth`,`addressLine1`,`addressLine2`,`city`,`country`,`pinCode`,`email`,`phoneNumber`,`dateOfRegistration`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prep =con.prepareStatement(query);
			
			prep.setString(1, user.getFirstName());
			prep.setString(2, user.getLastName());
			prep.setString(3, user.getPassword());
			prep.setString(4, "user");
			prep.setString(5, splitedDate[0]);
			prep.setString(6, user.getAddress1());
			prep.setString(7, user.getAddress2());
			prep.setString(8, user.getCity());
			prep.setString(9, user.getCountry());
			prep.setInt(10, user.getPinCode());
			prep.setString(11, user.getEmail());
			prep.setString(12, user.getPhonenumber());
			prep.setString(13, date );
			prep.execute();
			
			
			return true;
		}

		public String chkForEmailID_PasswordAlreadyExists(String email,
				String password) throws SQLException 
		{
			String role=null;
			String query="select email,password,role from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			System.out.println(email+password);
			while(rs.next())
			{
				if(rs.getString("email").equals(email)&&rs.getString("password").equals(password))
					role=rs.getString("role");
			}
			System.out.println(role);
			if (role==null)
			{
				System.out.println(role);
				return "invalid";
			}
			return role;
				
		}

		public String getPasswordformDB(String email) throws SQLException 
		{
			// TODO Auto-generated method stub
			String query="select email,password from UserCredantials";
			ResultSet rs=db.executeQuery(query, con);
			String password=null;
			while(rs.next())
			{
				if(rs.getString("email").equals(email))
				{
					password=rs.getString("password");
			
				}
			}
			return password;
		
		}	
		
		
}

