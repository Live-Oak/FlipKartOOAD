package edu.iiitb.action;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONPopulator;
import org.apache.struts2.json.JSONUtil;

import sun.security.provider.PolicyParser.GrantEntry;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import edu.iiitb.database.DBHandlerForCart;
import edu.iiitb.database.DBHandlerForUser;
import edu.iiitb.model.*;

public class placeOrderUserSessionCheck extends ActionSupport implements SessionAware
{
	private float grandTotal;
	
	private HttpServletResponse servletResponse;
	private HttpServletRequest servletRequest;

	custometAddressDetail addressDetails = new custometAddressDetail();
	private Map session;
	
	ArrayList<customerCartDetail> cartDetailsList = new ArrayList<customerCartDetail>();
	
	public float getGrandTotal() 
	{
		return grandTotal;
	}
	public void setGrandTotal(float grandTotal) 
	{
		this.grandTotal = grandTotal;
	}
	
	public ArrayList<customerCartDetail> getCartDetailsList() 
	{
		return cartDetailsList;
	}
	public void setCartDetailsList(ArrayList<customerCartDetail> cartDetailsList) 
	{
		this.cartDetailsList = cartDetailsList;
	}
	public custometAddressDetail getAddressDetails() 
	{
		return addressDetails;
	}
	public void setCustomerAddress(custometAddressDetail addressDetails) 
	{
		this.addressDetails = addressDetails;
	}
		
	public Map getSession()
	{
		return session;
	}
	public void setSession(Map session) 
	{
		this.session = session;
	}

	public String execute() throws SQLException, JSONException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IntrospectionException
	{	
		User user;				
		if ( session.containsKey("user") )			
		{
			user = (User) session.get("user");
			DBHandlerForUser db = new DBHandlerForUser();
			addressDetails.setEmail(user.getEmail());	
			addressDetails = db.getUserAddressDetail(addressDetails.getEmail());		
			cartDetailsList = db.getCartTableDetail(addressDetails.getEmail());		
			for (customerCartDetail cart : cartDetailsList) 
			{						
				grandTotal =  grandTotal + Float.parseFloat( cart.getSubTotal() );					
			}
			System.out.println("Table GrandTotal = Rs." + grandTotal);
		}	
		else
		{			
			String content = null;
			DBHandlerForUser db = new DBHandlerForUser();
			boolean cookieFound = false;
			System.out.println("I got lucky here 1 ;)");
			for (Cookie c : servletRequest.getCookies()) 
			{
				System.out.println("I got lucky here 2 ;)");
				if (c.getName().equals("cart")) 
				{
					System.out.println("I got lucky here 2 ;)");
					content = c.getValue();
					ArrayList<customerCartDetail> cartDetails = new ArrayList<customerCartDetail>();
					 JSONPopulator pop = new JSONPopulator();
					Map< ?, ?> map = (Map< ?, ?>)	JSONUtil
							.deserialize(content);
					 pop.populateObject(cartDetails, map);
					
					cartDetailsList = db.getCartCokkiesDetail(cartDetails);
					cookieFound = true;
					break;
				}
				for (customerCartDetail cart : cartDetailsList) 
				{						
					grandTotal =  grandTotal + Float.parseFloat( cart.getSubTotal() );					
				}
				System.out.println("Cokies GrandTotal = Rs." + grandTotal);			
			}
			
		}
		return "success";
	}
}