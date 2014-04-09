/**
 * 
 */
package edu.iiitb.model;

/**
 * @author PrashantN
 *
 */
public class CartProduct {
	
	private int productId;
	private int quantity;
	
	public CartProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartProduct(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
