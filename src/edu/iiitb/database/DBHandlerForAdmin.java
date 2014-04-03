/**
 * 
 */
package edu.iiitb.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu.iiitb.model.Advertizement;
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
	
	public boolean registerUserinDB(UserEntry user) throws SQLException
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(new java.util.Date());
		String[] splitedDate=user.getDate().split("T");
		String query="INSERT INTO UserCredantials(`firstName`,`lastName`,`password`,`role`,`dateOfBirth`,`addressLine1`,`addressLine2`,`city`,`country`,`pinCode`,`email`,`phoneNumber`,`dateOfRegistration`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prep =con.prepareStatement(query);
		
		prep.setString(1, user.getFirstName());
		prep.setString(2, user.getLastName());
		prep.setString(3, user.getPassword());
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
			try
			{
				int id = fetchUserIDIntForm(user.getEmail());
				String queryForSeller="INSERT INTO Seller(`userId`,`description`) VALUES(?,?)";
				PreparedStatement prepForSeller =con.prepareStatement(queryForSeller);
				prepForSeller.setInt(1, id);
				prepForSeller.setString(2, user.getSellerDescription());
				prepForSeller.execute();
			} catch(Exception e)
			{
				System.out.println("Exception at fetching id for Role seller");
			}
			
		}
		
		return true;
	}
	
	public void fetchUserIdWithRole(ArrayList<String> user) throws SQLException
	{
		String query = "select userId , role from UserCredantials";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			user.add(Integer.toString(rs.getInt("userId"))+"_"+rs.getString("role"));
		}
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
	
	public int fetchUserIDIntForm(String email) throws SQLException
	{
		String query = "select userId , email from UserCredantials";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			if(rs.getString("email").equals(email))
				return rs.getInt("userId");
		}
		return 0;
	}
	
	public void deleteUserFromDB(int id) throws SQLException
	{
		try
		{
			String query = "DELETE FROM UserCredantials WHERE  userId = "+id+"";
			Statement st=(Statement) con.createStatement();
			st.executeUpdate(query);
		} catch(SQLException e)
		{
			String query1 = "DELETE FROM Seller WHERE  userId = "+id+"";
			Statement st1=(Statement) con.createStatement();
			st1.executeUpdate(query1);
			String query2 = "DELETE FROM UserCredantials WHERE  userId = "+id+"";
			Statement st2=(Statement) con.createStatement();
			st2.executeUpdate(query2);
		}
		
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
		stmnt.setString(4, prod.getImage());
		stmnt.setInt(5, prod.getOffer());
		stmnt.setString(6,prod.getCategoryID());
		stmnt.setString(7,prod.getKeywords());
		stmnt.setString(8,prod.getDescription());
		stmnt.setString(9,prod.getBrand());
		stmnt.setInt(10,prod.getWarranty());
		stmnt.execute();	
	}
	
	public void addAdvertisement(Advertizement adv) throws SQLException
	{
		 java.util.Date date= new java.util.Date();
		 Timestamp time =  new Timestamp(date.getTime());
		String query = "Insert into Advertizement values(?,?,?)";
		PreparedStatement stmnt = con.prepareStatement(query);
		stmnt.setString(1,adv.getProductID());
		stmnt.setBlob(2, adv.getImage());
		stmnt.setTimestamp(3, time);
		stmnt.execute();
	}

	public void fetchProductID(ArrayList<String> productId) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "select productId from ProductInfo";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			productId.add(rs.getString("productId"));
		}
		
	}

	public void fetchCategoryName(ArrayList<String> categoryName) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "select categoryName from Category";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			categoryName.add(rs.getString("categoryName"));
		}
		
	}

	public boolean chkForCategoryNameAlreadyExists(String categoryName) throws SQLException {
		// TODO Auto-generated method stub
		String query="select categoryName from Category";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			if(rs.getString("categoryName").equals(categoryName))
				return true;
		}
		return false;
	}

	public void fetchProductName(ArrayList<String> pName) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select productName from ProductInfo";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			pName.add(rs.getString("productName"));
		}
	}

	public void viewUserData(ArrayList<UserEntry> user) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from UserCredantials";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			UserEntry entry = new UserEntry();
			entry.setUserId(rs.getInt("userId"));
			entry.setFirstName(rs.getString("firstName"));
			entry.setLastName(rs.getString("lastName"));
			entry.setRole(rs.getString("role"));
			entry.setEmail(rs.getString("email"));
			entry.setPhonenumber(rs.getString("phoneNumber"));
			entry.setCity(rs.getString("city"));
			user.add(entry);
		}
	}

	public void viewProductData(ArrayList<ProductInfo> product) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from ProductInfo";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			ProductInfo entry = new ProductInfo();
			entry.setProductID(rs.getInt("productId"));
			entry.setProductName(rs.getString("productName"));
			entry.setCategoryID(rs.getString("categoryId"));
			entry.setDescription(rs.getString("description"));
			entry.setPrice(rs.getFloat("price"));
			product.add(entry);
		}
	}

	public void viewCategoryData(ArrayList<CategoryModel> category) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from Category";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			CategoryModel entry = new CategoryModel();
			entry.setCategoryId(rs.getString("categoryId"));
			entry.setCategoryName(rs.getString("categoryName"));
			category.add(entry);
		}
	}

	public void viewSubCategoryData(ArrayList<CategoryModel> category) throws SQLException{
		// TODO Auto-generated method stub
		String query = "select * from Category";
		ArrayList<String> id = new ArrayList<String>();
		fetchDistinctSubCategoryID(id);
		ResultSet rs=db.executeQuery(query, con);
			while(rs.next())
			{
				if(id.contains(rs.getString("categoryId")))
				{
					CategoryModel entry = new CategoryModel();
					entry.setCategoryId(rs.getString("categoryId"));
					entry.setCategoryName(rs.getString("categoryName"));
					category.add(entry);
				}
			}
		
	}

	private void fetchDistinctSubCategoryID(ArrayList<String> id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT distinct(subCategoryId) FROM CategoryRelation";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			id.add(rs.getString(1));
		}
	}
	
	
	
}
