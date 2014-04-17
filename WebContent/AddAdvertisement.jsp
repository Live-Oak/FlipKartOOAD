<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>
	<i> <h3 align="center"> Please Fill the Details .... </h3> </i>
	<div align="center">
	
		<form action="inserAdvertisement" method="post" enctype="multipart/form-data">
			<h3> Product- ID :: 
			<select id="dropDown" name="productID">
				<s:iterator value="productId">
					 <option>  <s:property /> </option> 
				 </s:iterator>
			 </select><br> </h3>
		
			Image ::	<input type="file" name="myFile" required="true"><br>
			
			<br>
			Caption :: 
			<input type="text" name="caption" required="true"/>
			
			<br>
			Advertisement_Type :: 
			<select id="dropDown2" name="advType">
				<option value="carousel">Carousel</option>
				<option value="general">General</option>
				<option value="dealoftheday">DealOfTheDay</option>
				<option value="sidebar">Sidebar</option>
			</select>
			
			<br>
			
			
				<input type="submit" value="Insert"/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			<input type="reset" name="Reset"/>
		
		</form>
		
	</div>
</h4>
</body>
</html>