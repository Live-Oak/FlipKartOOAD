<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
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
	
		<form action="inserCategory" method="post">
			<s:textfield  name="categoryId" required="true" placeholder="Enter Category-id">Category-ID ::</s:textfield> <br>
			Category Name ::	<input type="text" name="categoryName" required="true"  placeholder="Enter CategoryName"><br>
			
			<br>	<input type="submit" value="Insert"/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			<input type="reset" name="Reset"/>
		
		</form>
		
	</div>
</h4>
</body>
</html>