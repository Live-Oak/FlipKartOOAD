package edu.iiitb.action;

import java.sql.SQLException;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mysql.jdbc.Field;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.mail.iap.Response;

import edu.iiitb.database.DBHandlerForAdmin;
import edu.iiitb.model.ProductInfo;

public class AdminAddProduct extends ActionSupport implements ModelDriven<ProductInfo> , SessionAware ,ServletRequestAware{

	
	DBHandlerForAdmin dbHandler = new DBHandlerForAdmin();
	ProductInfo prod = new ProductInfo();
	ArrayList<String> categoryId;
	HttpServletRequest servletRequest;
	
	
	private Map session;
	/**
	 * @return the session
	 */
	public Map getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	

	
	/**
	 * @return the servletRequest
	 */
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	/**
	 * @param servletRequest the servletRequest to set
	 */
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public ArrayList<String> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ArrayList<String> categoryId) {
		this.categoryId = categoryId;
	}

	public void validate()
	{
		categoryId = new ArrayList<String>();
		try
		{
			if(dbHandler.chkForProductIDAlreadyExists(prod.getProductID()))
			{
				dbHandler.fetchCategoryID(categoryId);
				addFieldError("productID", "");
				servletRequest.setAttribute("errorMessage", "PRODUCT ID already EXISTS !!!");
		
			}
				
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public String execute() 
	{
		
		String destPath = servletRequest.getSession().getServletContext().getRealPath("/");
		
		File destFile = new File(destPath,prod.getMyFileFileName());
		try {
			FileUtils.copyFile(prod.getMyFile(), destFile);
			FileInputStream inputStream = new FileInputStream(destFile);
			prod.setImage(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		try {
			
			dbHandler.registerProduct(prod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
			addActionMessage("Product registered successfully");
		
		return "success";
		
	}

	
	public ProductInfo getProd() {
		return prod;
	}

	public void setProd(ProductInfo prod) {
		this.prod = prod;
	}
	
	@Override
	public ProductInfo getModel() {
		// TODO Auto-generated method stub
		return prod;
	}



}
