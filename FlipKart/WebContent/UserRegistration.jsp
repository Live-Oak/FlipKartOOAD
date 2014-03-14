<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<sx:head/>
</head>
<body>
	<div align="center">
		
		<s:form action="registerUser" method="post" enctype="multipart/form-data">
		
	 <s:textfield name="userID" required="true"  placeholder="User-id"/>
	 <s:textfield name="firstName" required="true" placeholder="FirstName"/>
	 <s:textfield name="lastName" required="true" placeholder="LastName"/>
	
		<s:combobox label="Select a Role" 
			headerKey="-1" headerValue="--- Select ---"
			list="#{'1':'Seller', '2':'Admin', '3':'User'}" 
			name="yourRole" />
	
	<%-- <h3> <sx:datetimepicker name="date" label="Date (dd-MMM-yyyy)" 
			displayFormat="dd-MMM-yyyy" value="todayDate" />  </h3> --%>
	    <s:textarea name="address1" key="email.body" required="true" placeholder="AddressLine1" />
		<s:textarea name="address2" placeholder="AddressLine2"/>
		<s:textfield name="city" required="true" placeholder="City"/> 
		<s:textfield name="country" required="true" placeholder="Country"/>
		<s:textfield name="pincode" required="true" placeholder="PinCode"/>
		<s:textfield name="email" required="true" placeholder="E-Mail"/>
		<s:textfield name="phoneNumber" required="true" placeholder="PhoneNumber"/> 
	
	<s:submit name="Submit"/> 
	
		</s:form>
	
	
	</div>

</body>
</html>