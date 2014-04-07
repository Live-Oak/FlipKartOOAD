package edu.iiitb.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import edu.iiitb.model.CompareProductsModel;

public class DBHandlerforComparison
{
	public static DBConnectivity db=new DBConnectivity();
	
	public static ArrayList<CompareProductsModel> getProducts(int productId) throws SQLException 
	{
		Connection con = db.createConnection();
		ArrayList<CompareProductsModel> products = new ArrayList<CompareProductsModel>(); 
		String query = "select p.productId,p.productName,p.image from ProductInfo p where p.productId = '" + productId + "'";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			System.out.println(rs.getInt("productId"));
			System.out.println(rs.getString("productName"));

			products.add(new CompareProductsModel(rs.getInt("productId"),rs.getString("productName"),rs.getString("image")));
		}
		db.closeConnection(con);
		return products;
	}

}
