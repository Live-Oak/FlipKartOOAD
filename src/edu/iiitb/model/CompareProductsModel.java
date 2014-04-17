/**
 * 
 */
package edu.iiitb.model;

public class CompareProductsModel {
	
	private int productId;
	private String productName;
	private String image;
	private int price;
	private String category;
	public CompareProductsModel(int productId, String productName, String image, int price, String category) 
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.image = image;
		this.price=price;
		this.category=category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() 
	{
		return "CartModel [productId=" + productId + ", productName="
				+ productName + ", image=" + image +  "]";
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	
}
