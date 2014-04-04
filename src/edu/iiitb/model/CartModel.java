/**
 * 
 */
package edu.iiitb.model;

/**
 * @author PrashantN
 *
 */
public class CartModel {
	
	private int productId;
	private int quantity;
	
	
	public CartModel(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartModel [productId=" + productId + ", quantity=" + quantity
				+ "]";
	}
}
