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
	<h1 align="center"> Registered Products in Database </h1><br><br><br>
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<table id="example" class="display" width="100%" border="2">
			<thead>
			<tr> 
			    <th style="color:red"> Product ID </th>
			    <th style="color:red"> Product Name </th>
			    <th style="color:red"> Category ID </th>
			    <th style="color:red"> Description </th>
			    <th style="color:red"> Product Price </th>
			</tr>
			</thead>
			<s:iterator value="product">
				<tr>
					
					<th>	<s:property value="productID"/>		</th>
					<th>	<s:property value="productName"/>			</th>
					<th>	<s:property value="categoryID"/>		</th>
					<th>	<s:property value="description"/>		</th>
					<th>	<s:property value="price"/>			</th>
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