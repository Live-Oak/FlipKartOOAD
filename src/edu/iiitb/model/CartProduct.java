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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProduct other = (CartProduct) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
