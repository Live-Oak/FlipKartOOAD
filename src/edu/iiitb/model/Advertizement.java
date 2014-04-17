package edu.iiitb.model;

import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;

public class Advertizement {

	private int productId;
	private String photo, type;
	private String advType;
	File myFile;
	String myFileFileName,myFileContentType,productID;
	private Timestamp timeStamp;
	private String caption;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the advType
	 */
	public String getAdvType() {
		return advType;
	}
	/**
	 * @param advType the advType to set
	 */
	public void setAdvType(String advType) {
		this.advType = advType;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(String productID) {
		String[] idName = productID.split("_");
		this.productID = idName[0];
	}
	

	/**
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the myFile
	 */
	public File getMyFile() {
		return myFile;
	}
	/**
	 * @param myFile the myFile to set
	 */
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	/**
	 * @return the myFileFileName
	 */
	public String getMyFileFileName() {
		return myFileFileName;
	}
	/**
	 * @param myFileFileName the myFileFileName to set
	 */
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	/**
	 * @return the myFileContentType
	 */
	public String getMyFileContentType() {
		return myFileContentType;
	}
	/**
	 * @param myFileContentType the myFileContentType to set
	 */
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	
}
