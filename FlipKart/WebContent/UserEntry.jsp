<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sx:head />
</head>
<body>
<h4>
<i><h3 align="center"> Please Fill The Below Details</h3> </i>
	<div align="center">
		<form action="enterUserDeatils" method="post">
		
			<s:textfield  name="userId" required="true" placeholder="Enter User-id">User-ID ::</s:textfield><br>
			FirstName ::	<input type="text" name="firstName" required="true"  placeholder="Enter FirstName"><br>
			LastName ::	<input type="text" name="lastName" required="true"  placeholder="Enter LastName"><br>
			Role :: <s:combobox
						headerKey="-1" headerValue="--- Select ---"
						list="#{'Seller':'Seller', 'Admin':'Admin', 'User':'User'}" 
						name="role" /><br>
			DateOfBirth :: <sx:datetimepicker name="date" displayFormat="dd-MM-yyyy" />	<br>
			<s:textarea name="address1" required="true" cols="20" rows="3"  placeholder="Enter address line 1">AddressLine 1</s:textarea> <br>
			<s:textarea name="address2" cols="20" rows="3"  placeholder="Enter address line 2">AddressLine 2</s:textarea> <br>
			<s:textfield name="city" required="true" placeholder="City">City ::</s:textfield>  <br>
			<s:textfield name="country" required="true" placeholder="Country">Country ::</s:textfield> <br>
			<s:textfield name="pinCode" required="true" placeholder="PinCode">PinCode ::</s:textfield> <br>
			<s:textfield name="email" required="true" placeholder="E-Mail">E-mail ::</s:textfield> <br>
			<s:textfield name="phonenumber" required="true" placeholder="Enter PhoneNumber">PhoneNumber :: </s:textfield> <br>
				
		<br>	<input type="submit" value="Submit"/> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			<input type="reset" name="Reset"/>
		</form>
	</div>
</h4>
</body>
</html>