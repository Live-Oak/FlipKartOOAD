/**
 * 
 */
package edu.iiitb.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.apache.struts2.interceptor.CookieProvider;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForCart;
import edu.iiitb.model.CartModel;
import edu.iiitb.model.CookieBean;
import edu.iiitb.model.User;

/**
 * @author PrashantN
 *
 */
public class CartManager extends ActionSupport implements SessionAware,CookieProvider {
	
	private int userid;
	private int productId;
	private int quantity;
	private ArrayList<CartModel> products;
	private int count;
	private Map session;
	
	public CartManager() {
		
	} 
	
	public CartManager(int userid, int productId, int quantity,
			ArrayList<CartModel> products) {
		super();
		this.userid = userid;
		this.productId = productId;
		this.quantity = quantity;
		this.products = products;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the products
	 */
	public ArrayList<CartModel> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(ArrayList<CartModel> products) {
		this.products = products;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}


	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String addToCart()
	{
		User user = (User)session.get("user");
		
		try {
			DBHandlerForCart.addToCart(Integer.parseInt(user.getUserId().trim()),productId,quantity);
		} catch (Exception e) {
			System.out.println("unable to add product to cart..!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
		
		
	}
	
	public String getCartProducts()
	{
		User user = (User)session.get("user");
		try {
			products = DBHandlerForCart.getProducts(Integer.parseInt(user.getUserId().trim()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to fetch datat from cart...!!!");
			e.printStackTrace();
		}
		
		count = products.size();
		return "success";
	}

	@Override
	public Set<Cookie> getCookies() {
		// TODO Auto-generated method stub
		return null;
	}	

}
