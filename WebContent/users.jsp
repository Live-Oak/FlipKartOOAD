<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="asset/CSS/bootstrap.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
	
	<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
	<script src="asset/JavaScripts/bootstrap.min.js"></script>
	<script src="asset/JavaScripts/jquery.dataTables.min.js"></script>
</head>
<body>
	<h1 align="center"> Registered Users in Database </h1><br><br><br>
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<table id="example" class="display" width="100%" border="2">
			<thead>
			<tr> 
			    <th style="color:red"> User ID </th>
			    <th style="color:red"> First Name </th>
			    <th style="color:red"> Last Name </th>
			    <th style="color:red"> UserRole </th>
			    <th style="color:red"> Email - ID </th>
			    <th style="color:red"> Phone Number </th>
			</tr>
			</thead>
			<s:iterator value="user">
				<tr>
					
					<th>	<s:property value="userId"/>		</th>
					<th>	<s:property value="firstName"/>			</th>
					<th>	<s:property value="lastName"/>		</th>
					<th>	<s:property value="role"/>		</th>
					<th>	<s:property value="email"/>			</th>
					<th>	<s:property value="phonenumber"/>		</th>
				</tr>
			</s:iterator>
	</table>
	</div>
	<div class="col-md-2"></div>
	<script type="text/javascript">
    	$("document").ready(function() {
			$("#example").dataTable();
		});
    
    </script>
</body>
</html>