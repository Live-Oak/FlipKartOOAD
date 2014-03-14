<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		
		<s:form action="registerUser" method="post">
		
	<h3>	User ID ::	</h3><s:textfield name="userID" requiredLabel="true"/><br>
	<h3>	FirstName ::	</h3><s:textfield name="firstName" requiredLabel="true"/><br>
	<h3>	LastName ::	</h3><s:textfield name="lastName" requiredLabel="true"/><br>
	<h3>
		<s:combobox label="Select a Role" 
			headerKey="-1" headerValue="--- Select ---"
			list="#{'1':'Seller', '2':'Admin', '3':'User'}" 
			name="yourRole" />
	</h3> <br>
	<h3> <sx:datetimepicker name="date" label="Date (dd-MMM-yyyy)" 
			displayFormat="dd-MMM-yyyy" value="todayDate" />  </h3>
	<h3>	User ID ::	</h3><s:textfield name="userID" requiredLabel="true"/><br>
	<h3>	User ID ::	</h3><s:textfield name="userID" requiredLabel="true"/><br>
	<h3>	User ID ::	</h3><s:textfield name="userID" requiredLabel="true"/><br>	
		</s:form>
	
	
	</div>

</body>
</html>