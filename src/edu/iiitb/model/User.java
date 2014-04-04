package edu.iiitb.model;

public class User
{
	private String email;
	private String password;
	private String userId;
	public String getEmail() 
	{
		return email;
	}
	
	public User(String email, String password,String userId) 
	{
		super();
		this.email = email;
		this.password = password;
		this.userId = userId;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User()
	{
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
