/**
 * 
 */
package edu.iiitb.model;


public class CompareCartProduct {
	
	private int productId;
	
	public CompareCartProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompareCartProduct(int productId) {
		super();
		this.productId = productId;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompareCartProduct other = (CompareCartProduct) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

	
	
	
	
}
