<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="asset/CSS/bootstrap.css" rel="stylesheet">
<link href="asset/CSS/Index.css" rel="stylesheet">
<link rel="stylesheet" href="asset/CSS/jquery-ui.css">
<link href="asset/CSS/starter-template.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
<link rel="stylesheet" href="asset/CSS/reveal.css">
<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
<script src="asset/JavaScripts/bootstrap.min.js"></script>
<script src="asset/JavaScripts/jquery.dataTables.min.js"></script>
<script src="asset/JavaScripts/jquery.reveal.js"></script>

<script type="text/javascript">
<!--
	// Form validation code will come here.
	function validate() {

		if (document.form_stock.minimumQuantity.value > (document.form_stock.availableQuantity.value + document.form_stock.orderQuantity.value)) {
			alert("Still below Minimum Qty value .. Order more");
			document.form_stock.orderQuantity.focus();
			return false;
		}
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#create_account").click(function() {
			$("#form_stock").submit();
		});
	});
</script>


<script type="text/javascript">
	$("document").ready(function() {
		$("a").click(function() {

			var productID = $(this).attr("id");

			$.ajax({

				type : 'POST',
				url : 'stockForProduct?productId=' + productID,
				success : function(data) {

					$.each(data.stock, function(count, stock) {

						$("#pId").val(stock.productId);
						$("#sId").val(stock.sellerId);
						$("#pName").val(stock.productName);
						$("#sName").val(stock.sellerName);
						$("#mQty").val(stock.minimumQty);
						$("#aQty").val(stock.availableQty);
						$("#aQty").attr("disabled", "disabled");
					});

				}

			});

		});
	});
</script>
</head>
<body>
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<table id="example" class="display" width="100%">
			<thead>
				<tr>
					<th>Product-Image</th>
					<th>Product-Name</th>
					<th>Seller-Name</th>
					<th>Min-Qty</th>
					<th>Avl-Qty</th>
					<th>&nbsp;&nbsp;Status</th>
					<th>&nbsp;&nbsp;&nbsp; Submit</th>
				</tr>
			</thead>

			<tbody>
				<s:iterator value="stockInfo">

					<tr>
						<td><img alt="not found"
							src="<s:property value="productImagePath"/>" height="80"
							width="60"></td>
						<td><s:property value="productName" /></td>
						<td><s:property value="sellerName" /></td>
						<td>&nbsp;&nbsp;&nbsp; <s:property value="minimumQty" />
						</td>
						<td>&nbsp;&nbsp;&nbsp;<s:property value="availableQty" />
						</td>
						<td><img alt="not found"
							src="<s:property value="statusImage"/>" height="65" width="65">
						</td>
						<td><a id="<s:property value="productId"/>"
							class="big-link Close" data-reveal-id="myModal2"> <font
								color="blue">OrderMore </font></a></td>
					</tr>


				</s:iterator>
			</tbody>
		</table>
	</div>

	<div class="col-md-2"></div>

	<div id="myModal2" class="reveal-modal">

		<h2 align="center">Stock Update Form</h2>
		<hr>
		<br> <span id="error" style="color: Red; display: none">*Input
			digits(0-9)</span>
		<form id="form_stock" name="form_stock" action="requestStock"
			onsubmit="return(validate());" method="post">
			<input type="hidden" id="pId" name="productId" /> <input
				type="hidden" id="sId" name="sellerId" /> <br> Product Name
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				class="textbox" id="pName" name="firstName"
				placeholder="Product Name" required><br>
			<br> Seller Name
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" class="textbox" id="sName" name="sellerName"
				placeholder="Seller Name" required><br>
			<br> Minimum Quantity &nbsp;&nbsp; <input type="text"
				class="textbox" id="mQty" name="minimumQuantity"
				placeholder="Minimum Product Quantity" required
				onkeypress="return IsNumeric(event);" ondrop="return false;"
				onpaste="return false;"><br>
			<br> Available Quantity &nbsp;&nbsp; <input type="text"
				class="textbox" id="aQty" name="availableQuantity"
				placeholder="Available Product Quantity" required
				onkeypress="return IsNumeric(event);" ondrop="return false;"
				onpaste="return false;"><br>
			<br> Order Quantity &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="text" class="textbox" id="oQty" name="orderQuantity"
				placeholder="Ordered Quantity" required
				onkeypress="return IsNumeric(event);" ondrop="return false;"
				onpaste="return false;"> <br>
			<script type="text/javascript">
				var specialKeys = new Array();
				specialKeys.push(8); //Backspace
				function IsNumeric(e) {
					var keyCode = e.which ? e.which : e.keyCode
					var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys
							.indexOf(keyCode) != -1);
					document.getElementById("error").style.display = ret ? "none"
							: "inline";
					return ret;
				}
			</script>
			<br>
			<br>
			<button type="button" id="create_account">SIGN UP NOW!</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" id="create_account">RESET!</button>
			<br>
		</form>
		<a class="close_button Close">&#215;</a>
	</div>











	<script type="text/javascript">
		$("document").ready(function() {
			$("#example").dataTable();
		});
	</script>
</body>
</html>