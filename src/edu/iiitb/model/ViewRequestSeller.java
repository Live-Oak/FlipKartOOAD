/**
 * 
 */
package edu.iiitb.model;

/**
 * @author paras
 *
 */
public class ViewRequestSeller {

	int customerId , productId ,  orderQty ;  
	String customerName ,productName , productImage;
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	 * @return the productImage
	 */
	public String getProductImage() {
		return productImage;
	}
	/**
	 * @param productImage the productImage to set
	 */
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	
}
