/**
 * 
 */
package edu.iiitb.model;

import java.util.ArrayList;

/**
 * @author PrashantN
 *
 */
public class CartCookie {
	
	private ArrayList<CartProduct> productList;

	public CartCookie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CartCookie(ArrayList<CartProduct> productList) {
		super();
		this.productList = productList;
	}



	public ArrayList<CartProduct> getProductList() {
		if(productList == null)
			productList = new ArrayList<CartProduct>();
		return productList;
	}

	public void setProductList(ArrayList<CartProduct> productList) {
		this.productList = productList;
	}

}


