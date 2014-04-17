package edu.iiitb.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import edu.iiitb.model.CompareProductsModel;
import edu.iiitb.model.CompareCartProduct;

public class DBHandlerforComparison
{
	public static DBConnectivity db=new DBConnectivity();
	
	public static ArrayList<CompareProductsModel> getProducts(int productId) throws SQLException 
	{
		Connection con = db.createConnection();
		ArrayList<CompareProductsModel> products = new ArrayList<CompareProductsModel>(); 
		String query = "select p.productId,p.productName,p.image,p.price,p.categoryId from ProductInfo p where p.productId = '" + productId + "'";
		ResultSet rs=db.executeQuery(query, con);
		while(rs.next())
		{
			products.add(new CompareProductsModel(rs.getInt("productId"),rs.getString("productName"),rs.getString("image"),rs.getInt("price"),rs.getString("categoryId")));
		}
		
		db.closeConnection(con);
		return products;
	}

	public static ArrayList<CompareProductsModel> getProductsFromCompareCart(ArrayList<CompareCartProduct> cartProducts) throws SQLException 
			{
		// TODO Auto-generated method stub
		Connection con = db.createConnection();
		ArrayList<CompareProductsModel> products = new ArrayList<CompareProductsModel>(); 
		for(CompareCartProduct p : cartProducts)
		{
			String query = "select productId,productName,image,price,categoryId from  ProductInfo where productID = "+p.getProductId()+";";
			ResultSet rs=db.executeQuery(query, con);
			while(rs.next())
			{
				products.add(new CompareProductsModel(rs.getInt("productId"),rs.getString("productName"),rs.getString("image"),rs.getInt("price"),rs.getString("categoryId")));
			}
		}
		
		db.closeConnection(con);
		return products;

			}
}
