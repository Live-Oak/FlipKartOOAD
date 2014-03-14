/**
 * 
 */
package edu.iiitb.config;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.ibatis.common.jdbc.ScriptRunner;

/**
 * @author paras
 *
 */
public class DBScriptExecute {

	/**
	 * create a database; drops it first if it exists
	 * 
	 * @param databaseName
	 */
	public static void createDatabase() {
		try {
			Statement stmt;
			Config.loadProperties();
			// Register the JDBC driver for MySQL.
			Class.forName(Config.DBDRIVER);

			// Get a connection to the database for a
			// user named root with a blank password.
			// This user is the default administrator
			// having full privileges to do anything.
			Connection con = DriverManager.getConnection(Config.DBURL,
					Config.DBUSER, Config.DBPASSWORD);
			
			ScriptRunner runner=new ScriptRunner(con, false, false);
			InputStreamReader reader = null;
			reader = new InputStreamReader(new FileInputStream("DBScripts/FlipkartDatabaseSchemaScriptV1.sql"));
			
			
			runner.runScript(reader);
			reader.close();
			
			/* To execute insert script
			 * 
			 * reader = new InputStreamReader(new FileInputStream("DBScripts/FlipkartInsertScript.sql"));
			runner.runScript(reader);
			
			reader.close();*/
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBScriptExecute.createDatabase();
	}
	
	
}
