<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Body Browse</title>
	<!-- Custom styles for this template -->
	<!-- Custom styles for this template -->
	<link href="asset/CSS/Index.css" rel="stylesheet">
	<link href="asset/CSS/starter-template.css" rel="stylesheet">
	
	<!-- Bootstrap core CSS -->
	<link href="asset/CSS/bootstrap.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
	
	<script src="asset/JavaScripts/jquery-1.9.1.js"></script>
	<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
	<script src="asset/JavaScripts/bootstrap.min.js"></script>
	
	<%-- <script type="text/javascript">
	$(document).ready(function(){
		$("#login_button").click(function()
				{
			$.ajax({
			    type: 'POST',	    
			    url:'check_login_password ?email=' + $("#emaill").val() + '&password=' + $("#passwordl").val(),
			    success: function(data){
			    	$("#check_email_password").html(data.message);
			    	var status=$("#check_email_password").html();
			    	if(status=="available")
			    		{
						$("#form_login").submit();		    			
			    		}
			    	else
			    		{
			    			$("#check_email_password").html("Invalid email or password");
			    		}
			     }});	
		});
	});


	</script> --%>
	
	
</head>
<body>
		<div class="col-md-1 "></div>
		<div class="col-md-3 ">
			<div class="background">
				<br>
				<h4><b>BROWSE</b></h4>
				<hr noshade>
				<h5><b>REFINE</b></h5>
				<hr>
				<h5>Price</h5>
				<hr>
				<form>
					<input type="checkbox" name="checkbox" value="" id="2000"> Rs. 2000 and Below<br>
					<input type="checkbox" name="checkbox" value="" id="2001,5000"> Rs. 2001 - Rs. 5000<br>
					<input type="checkbox" name="checkbox" value="" id="5001,10000"> Rs. 5001 - Rs. 10000<br>
					<input type="checkbox" name="checkbox" value="" id="10001,18000"> Rs. 10001 - Rs. 18000<br>
					<input type="checkbox" name="checkbox" value="" id="18001,25000"> Rs. 18001 - Rs. 25000<br>
					<input type="checkbox" name="checkbox" value="" id="25001,35000"> Rs. 25001 - Rs. 35000<br>
					<input type="checkbox" name="checkbox" value="" id="35000+"> Rs. 35001 and Above
				</form> 
				<hr>
				<h5>Company Name</h5>
				<hr>
				<form>
					<s:iterator value="companyList">
					<input type="checkbox" name="checkbox" value="" id="<s:property />"> <s:property /><br>
					</s:iterator>
				</form> 
				<br><br><br>
			</div>
		</div>
	
	<div class="col-md-7 background">
			<b> Showing all the products in the category </b><br><br>
			<s:iterator value="productinfo">
				<div class="col-md-4">
						<div class="border">
							<center>
								<br>
								<a href="getProductDetail?productID=<s:property value="productID"/>">
									<img src="<s:property value="image"/>" alt="<s:property value="productID"/>" height="140px" width="auto"><br><br>
								</a>
								<div class="giveMeEllipsis">
								<a href="getProductDetail?productID=<s:property value="productID"/>">
									<font size="4" color="black"><s:property value="productName"/></font><br>
								</a>
								</div>
								<hr>
								Rs. <s:property value="price"/><br>
								<hr>
								This item has manufacturer warranty of <s:property value="warranty"/> years.<br>
								<hr>
								<input type="checkbox" name="addtocompare" value=""> Add to compare<br>
								<!--<s:property value="categoryID"/><br>
								<s:property value="price"/><br>
								<s:property value="offer"/><br>
								<s:property value="description"/><br>
								<s:property value="brand"/><br>-->
							</center>
						</div><br>
					</div>
			</s:iterator>
	</div>
	<div class="col-md-1 "></div>
	
</body>
</html>