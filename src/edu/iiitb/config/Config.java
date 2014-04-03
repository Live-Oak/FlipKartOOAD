package edu.iiitb.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static String DBURL = null;
	public static String DBDRIVER = null;
	public static String DBNAME = null;
	public static String DBUSER = null;
	public static String DBPASSWORD = null;
	public static String EMAILID = null;
	public static String USERNAME = null;
	public static String MAILIDPASSWORD = null;
	public static String FILESTOREPATH = null;
	
	public static void loadProperties()
	{
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			
			input = Config.class.getClassLoader().getResourceAsStream("config.properties");
				// Load Property File
						prop.load(input);
			
				// get the property value and print it out
						DBURL = prop.getProperty("dburl");
						DBDRIVER = prop.getProperty("dbdriver");
						DBUSER = prop.getProperty("dbuser");
						DBPASSWORD = prop.getProperty("dbpassword");
						DBNAME = prop.getProperty("dbname");
						EMAILID = prop.getProperty("emailid");
						USERNAME = prop.getProperty("username");
						MAILIDPASSWORD = prop.getProperty("mailidpassword");
						FILESTOREPATH = prop.getProperty("filestorepath");
			
		} catch(Exception e)
		{
			System.out.println("Exception in Config.java "+e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
