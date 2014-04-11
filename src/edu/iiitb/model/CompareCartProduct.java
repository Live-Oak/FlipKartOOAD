/**
 * 
 */
package edu.iiitb.model;


public class CompareCartProduct {
	
	private int productId;
	private String category;
	public CompareCartProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompareCartProduct(int productId,String category) {
		super();
		this.productId = productId;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	
	
}
