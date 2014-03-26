package edu.iiitb.model;

import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;

public class Advertizement {

	private int productID;
	private InputStream image;
	private Timestamp timeStamp;
	
	File myFile;
	String myFileFileName,myFileContentType;
	
	
	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
	/**
	 * @return the image
	 */
	public InputStream getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(InputStream image) {
		this.image = image;
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
