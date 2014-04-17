/**
 * 
 */
package edu.iiitb.model;

import java.io.File;

/**
 * @author paras
 *
 */
public class CategoryModel {

	String categoryId,categoryName,categoryImage;
	File myFile;
	String myFileFileName , myFileContentType ;

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
