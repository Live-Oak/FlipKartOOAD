/**
 * 
 */
package edu.iiitb.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import edu.iiitb.model.CartModel;
import edu.iiitb.model.ProductInfo;

/**
 * @author PrashantN
 *
 */
public class DBHandlerForCart {
	
	public static DBConnectivity db=new DBConnectivity();
	
	
	public static void addToCart(int uid,int productId,int quantity) throws Exception
	{
		Connection con = db.createConnection();
		String query="INSERT INTO Cart(userId,productId,quantity) VALUES (?,?,?);";
		PreparedStatement prep =con.prepareStatement(query);	
		prep.setInt(1,uid);
		prep.setInt(2,productId);
		prep.setInt(3,quantity);
		prep.execute();
		db.closeConnection(con);
	}
	
	public static ArrayList<CartModel> getProducts(int uid) throws SQLException
	{
		Connection con = db.createConnection();
		ArrayList<CartModel> products = new ArrayList<CartModel>(); 
		String query = "select p.productId,p.productName,p.image,p.price,c.quantity from Cart c inner join ProductInfo p where c.userId = "+uid+" and c.productId = p.productID;";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			products.add(new CartModel(rs.getInt("productId"),rs.getString("productName"),rs.getString("image"),rs.getInt("price"),rs.getInt("quantity")));
		}
		db.closeConnection(con);
		return products;
	}
	
	

}
