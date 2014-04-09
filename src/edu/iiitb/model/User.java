package edu.iiitb.model;

public class User
{
	private String email;
	private String password;
	private String userId;
	private String role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
