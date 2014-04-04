<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.welcome {
		background-color:#DDFFDD;
		border:1px solid #009900;
		width:190px;
	}
	.welcome li{ 
		list-style: none; 
	}
	</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="asset/CSS/bootstrap.css" rel="stylesheet">
<link href="asset/CSS/Index.css" rel="stylesheet">
<link rel="stylesheet" href="asset/CSS/jquery-ui.css">
<link href="asset/CSS/starter-template.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">

<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
<script src="asset/JavaScripts/bootstrap.min.js"></script>
<script src="asset/JavaScripts/jquery.dataTables.min.js"></script>





</head>
<body>
	<center>
		<s:if test="hasActionMessages()">
		<div class="welcome">
      		<s:actionmessage/>
  		 </div>
	</s:if>
	
	</center>
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<table id="example" class="display" width="100%">
			<thead>
				<tr>
					<th>Product-Image</th>
					<th>Product-Name</th>
					<th>Quantity</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<s:iterator value="request">

					<tr>
						<td><img alt="not found"
							src="<s:property value="productImage"/>" height="80"
							width="60"></td>
						<td><s:property value="productName" />  </td>
						<td>&nbsp;&nbsp;&nbsp; <s:property value="orderQty" />
						</td>
						<td><a href="approveProductReuest?productId=<s:property value="productId"/>&customerId=<s:property value="customerId"/>&purchaseQty=<s:property value="orderQty"/>"> <font
								color="blue"> Approve </font></a></td>
					</tr>

				</s:iterator>
			</tbody>
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