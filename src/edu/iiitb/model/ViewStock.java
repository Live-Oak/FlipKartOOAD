/**
 * 
 */
package edu.iiitb.model;

/**
 * @author paras
 *
 */
public class ViewStock {

	int productId , availableQty , minimumQty , orderQty , sellerId;
	String sellerName , productName , productImagePath ,statusImage;
	
	/**
	 * @return the statusImage
	 */
	public String getStatusImage() {
		return statusImage;
	}
	/**
	 * @param statusImage the statusImage to set
	 */
	public void setStatusImage(String statusImage) {
		this.statusImage = statusImage;
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
	 * @return the availableQty
	 */
	public int getAvailableQty() {
		return availableQty;
	}
	/**
	 * @param availableQty the availableQty to set
	 */
	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}
	/**
	 * @return the minimumQty
	 */
	public int getMinimumQty() {
		return minimumQty;
	}
	/**
	 * @param minimumQty the minimumQty to set
	 */
	public void setMinimumQty(int minimumQty) {
		this.minimumQty = minimumQty;
	}
	
	/**
	 * @return the orderQty
	 */
	public int getOrderQty() {
		return orderQty;
	}
	/**
	 * @param orderQty the orderQty to set
	 */
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	/**
	 * @return the sellerId
	 */
	public int getSellerId() {
		return sellerId;
	}
	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	/**
	 * @return the sellerName
	 */
	public String getSellerName() {
		return sellerName;
	}
	/**
	 * @param sellerName the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productImagePath
	 */
	public String getProductImagePath() {
		return productImagePath;
	}
	/**
	 * @param productImagePath the productImagePath to set
	 */
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	
	
}
