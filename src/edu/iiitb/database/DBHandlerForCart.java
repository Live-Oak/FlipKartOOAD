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
	
	public static ArrayList<CartModel> getProducts(int uid) throws SQLException
	{
		ArrayList<CartModel> products = new ArrayList<CartModel>(); 
		String query = "select p.productId,p.productName,p.image,p.price,c.quantity from cart c inner join productinfo p where c.userId = "+uid+" and c.productId = p.productID;";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			products.add(new CartModel(rs.getInt("productId"),rs.getString("productName"),rs.getString("image"),rs.getInt("price"),rs.getInt("quantity")));
		}
		return products;
	}
	
	

}
