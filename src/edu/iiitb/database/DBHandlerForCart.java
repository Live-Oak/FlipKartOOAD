/**
 * 
 */
package edu.iiitb.database;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

/**
 * @author PrashantN
 *
 */
public class DBHandlerForCart {
	
	public static DBConnectivity db=new DBConnectivity();
	public static Connection con = db.createConnection();
	
	public static void addToCart(int uid,int productId,int quantity) throws Exception
	{
		String query="INSERT INTO cart(userId,productId,quantity) VALUES (?,?,?);";
		PreparedStatement prep =con.prepareStatement(query);	
		prep.setInt(1,uid);
		prep.setInt(2,productId);
		prep.setInt(3,quantity);
		prep.execute();
	}
	
	

}
