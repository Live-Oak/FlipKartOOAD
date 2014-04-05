package edu.iiitb.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import edu.iiitb.config.Config;

public class DBConnectivity {

	public Connection createConnection()
	{
		Config.loadProperties();
		Connection con=null;
		try {
			Class.forName(Config.DBDRIVER);
			con=(Connection) DriverManager.getConnection(Config.DBURL+Config.DBNAME,Config.DBUSER,Config.DBPASSWORD);
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Exception in createConnection() inside DBConnectivity.java ");
			e.printStackTrace();
		}
		return con;
		
	}
	public ResultSet executeQuery(String query, Connection con)
	{		
	
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in executeQuery() inside DBConnectivity.java ");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void closeConnection(Connection con) throws SQLException
	{
		con.close();
	}
}

