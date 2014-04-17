/**
 * 
 */
package edu.iiitb.model;

import java.util.ArrayList;

public class CompareCartCookie {
	
	private ArrayList<CompareCartProduct> productList;

	public CompareCartCookie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CompareCartCookie(ArrayList<CompareCartProduct> productList) {
		super();
		this.productList = productList;
	}



	public ArrayList<CompareCartProduct> getProductList() {
		if(productList == null)
			productList = new ArrayList<CompareCartProduct>();
		return productList;
	}

	public void setProductList(ArrayList<CompareCartProduct> productList) {
		this.productList = productList;
	}

}


