<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link href="asset/CSS/bootstrap.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
<script src="asset/JavaScripts/bootstrap.min.js"></script>
<script src="asset/JavaScripts/drophover.js"></script>
<script src="asset/JavaScripts/jquery-ui.js"></script>
</head>
<body>
	<div class="col-md-2"></div>
	<div class="col-md-8">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Product-Image</th>
				<th>Product-Name</th>
				<th>Seller-Name</th>
				<th>Min-Qty</th>
				<th>Avl-Qty</th>
				<th>Status</th>
				<th>Submit</th>
			</tr>
		</thead>

		<tbody>
			<s:iterator value="stockInfo">
			<form>
			<tr>
				<td> <img alt="not found" src="<s:property value="productImagePath"/>" height="80" width="50"> </td>
				<td> <s:property value="productName"/> </td>
				<td> <s:property value="sellerName"/> </td>
				<td> <s:property value="minimumQty"/> </td>
				<td> <s:property value="availableQty"/> </td>
				<td> <img alt="not found" src="<s:property value="statusImage"/>" height="65" width="65"> </td>
				<td> <input type="submit" class="btn btn-primary" value="OrderMore"/> </td>
			</tr>
			</form>
			
			</s:iterator>
		</tbody>
	</table>
	</div>
	<div class="col-md-2"></div>
</body>
</html>