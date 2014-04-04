/**
 * 
 */
package edu.iiitb.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.database.DBHandlerForCart;
import edu.iiitb.model.CartModel;

/**
 * @author PrashantN
 *
 */
public class CartManager extends ActionSupport{
	
	private int userid;
	private int productId;
	private int quantity;
	private ArrayList<CartModel> products;
	
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

	public String addToCart()
	{
		int uid = 4;
		
		try {
			DBHandlerForCart.addToCart(uid,productId,quantity);
		} catch (Exception e) {
			System.out.println("unable to add product to cart..!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	
}
