/**
 * 
 */
package edu.iiitb.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu.iiitb.model.CategoryModel;
import edu.iiitb.model.ProductInfo;
import edu.iiitb.model.UserEntry;

/**
 * @author paras
 *
 */
public class DBHandlerForAdmin {

	/**
	 * Write All DB query for admin inside this class
	 * @throws SQLException 
	 *
	 */
	DBConnectivity db=new DBConnectivity();
	Connection con = db.createConnection();
	
	public boolean chkForIDAlreadyExists(int id) throws SQLException
	{
		String query="select userId from UserCredantials";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			if(rs.getInt("userId")==id)
				return true;
		}
		return false;
	}
	
	public boolean registerUserinDB(UserEntry user) throws SQLException
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(new java.util.Date());
		String[] splitedDate=user.getDate().split("T");
		String query="INSERT INTO UserCredantials(`userId`,`firstName`,`lastName`,`role`,`dateOfBirth`,`addressLine1`,`addressLine2`,`city`,`country`,`pinCode`,`email`,`phoneNumber`,`dateOfRegistration`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prep =con.prepareStatement(query);
		prep.setInt(1, user.getUserId());
		prep.setString(2, user.getFirstName());
		prep.setString(3, user.getLastName());
		prep.setString(4, user.getRole());
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
		
		if(user.getRole().equals("Seller"))
		{
			String queryForSeller="INSERT INTO Seller(`userId`,`description`) VALUES(?,?)";
			PreparedStatement prepForSeller =con.prepareStatement(queryForSeller);
			prepForSeller.setInt(1, user.getUserId());
			prepForSeller.setString(2, user.getSellerDescription());
			prepForSeller.execute();
		}
		
		return true;
	}

	public void fetchUserID(ArrayList<String> userID) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "select userId from UserCredantials";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			userID.add(Integer.toString(rs.getInt("userId")));
		}
	}
	
	public void deleteUserFromDB(int id) throws SQLException
	{
		String query = "DELETE FROM UserCredantials WHERE  userId = "+id+"";
		Statement st=(Statement) con.createStatement();
		st.executeUpdate(query);
		
	}
	
	public boolean chkForCategoryIDAlreadyExists(String categoryId) throws SQLException
	{
		String query="select categoryId from Category";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			if(rs.getString("categoryId").equals(categoryId))
				return true;
		}
		return false;
	}

	public void addCategoryinDB(CategoryModel categoryInfo) throws SQLException {
		// TODO Auto-generated method stub
		String query="INSERT INTO Category(`categoryId`,`categoryName`) VALUES(?,?)";
		PreparedStatement prep =con.prepareStatement(query);
		prep.setString(1, categoryInfo.getCategoryId());
		prep.setString(2, categoryInfo.getCategoryName());
		prep.execute();
	}

	public void fetchCategoryID(ArrayList<String> categoryId) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "select categoryId from Category";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			categoryId.add(rs.getString("categoryId"));
		}
	}

	public void fetchSubCategoryId(ArrayList<String> subCategoryId,
			String categoryId) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select categoryId from Category";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			if(!rs.getString("categoryId").equals(categoryId))
				subCategoryId.add(rs.getString("categoryId"));
		}
	}

	public void insetCategoryRelationship(String id, String id2) throws SQLException {
		// TODO Auto-generated method stub
		
		String query="INSERT INTO CategoryRelation(`categoryId`,`subCategoryId`) VALUES(?,?)";
		PreparedStatement prep =con.prepareStatement(query);
		prep.setString(1, id);
		prep.setString(2, id2);
		prep.execute();
		
	}
	
	public boolean chkForProductIDAlreadyExists(int id) throws SQLException
	{
		String query="select productId from ProductInfo";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			if(rs.getInt("productId")==id)
				return true;
		}
		return false;
	}
	
	public ArrayList<Integer> getAllCategoryIDs() throws SQLException
	{
		ArrayList<Integer> categoryList = new ArrayList<Integer>();
		String query = "Select categoryId from Category";
		ResultSet rs = db.executeQuery(query, con);
		while(rs.next())
		{
			categoryList.add(rs.getInt(1));
		}
		return categoryList;
	}
	
	public void registerProduct(ProductInfo prod) throws SQLException
	{
		
		
		int productid = prod.getProductID();
		//System.out.println("Image(inserting) :" + prod.getImage());
		String query = "Insert into ProductInfo(`productId`,`productName`,`price`,`image`,`offer`" +
				",`categoryId`,`keywords`,`description`,`brand`,`warranty`) " +
				" values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmnt = con.prepareStatement(query);
		stmnt.setInt(1,prod.getProductID());
		stmnt.setString(2, prod.getProductName());
		stmnt.setFloat(3, prod.getPrice());
		stmnt.setBlob(4, prod.getImage());
		stmnt.setInt(5, prod.getOffer());
		stmnt.setString(6,prod.getCategoryID());
		stmnt.setString(7,prod.getKeywords());
		stmnt.setString(8,prod.getDescription());
		stmnt.setString(9,prod.getBrand());
		stmnt.setInt(10,prod.getWarranty());
		stmnt.execute();	
	}
	
}
