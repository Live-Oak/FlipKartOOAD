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
		<link href="asset/CSS/CompareProducts.css" rel="stylesheet">
	
	<!-- Bootstrap core CSS -->
	<link href="asset/CSS/bootstrap.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
	
	<script src="asset/JavaScripts/jquery-1.9.1.js"></script>
	<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
	<script src="asset/JavaScripts/bootstrap.min.js"></script>
	<script src="asset/JavaScripts/jquery-1.9.1.js"></script>
	
	
	<%-- <script type="text/javascript">
	$(document).ready(function(){
		$("#name of checkbox").change(function()
				{
			$.ajax({
			    type: 'POST',	    
			    url:'update_product_list?value=' + ("#checkbox_id").is(':checked') + '&productname=' + $("#collect the value from session or from url").val(),
			    success: function(data){
			    	update the result on the page
			     }});	
		});
	});


	</script> --%>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".addtocompare").change(function(event)
				{
		$(".addtocompare").is(':checked');
		//alert(event.target.id);					Specifies id of the target 
		var maxAllowed = 4;	
		//alert($(event.target).attr("pid"));				Specifies pid 
		var pId = $(event.target).attr("pid");
		alert(pId);
		$("#comparecart").show();
		var cnt = $("input[name='compare']:checked").length;
			      if (cnt > maxAllowed)
			      {
			         $(this).prop("checked", "");
			         alert('Select maximum ' + maxAllowed );
			     }
			       
		
			      $.ajax({
					    type: 'GET',
					    contentType: "application/x-www-form-urlencoded; charset=utf-8",
					    data : {
					    	productId : pId
					    },
					    url:'getProductToCompare',
					    success: function(data){
					    	if(data.count == 0 || data.count == undefined)
				    		{
				    			
				    			$("#compare_button").attr("disabled", true);
				    		}
					    	else
					    	{
					    		alert(data.count);
					    		$("#list").empty();
					    		$("#comparecart").show();
					    		$.each(data.products, function(count,product) { 
				    				$("#list").append("<div style='height:100px;border : 1px solid gray;padding:10px'>"+
				    						"<img src='"+product.image+"' height='80px' width='80px' style='float:left' />"+
				    						"<div class='productName'>"+product.productName+"</div>"+
				    						"<div class='remove'><a style='color:black;'>remove</a></div>"+
				    				"</div>");	
					    		});
					    	}
					     }});	
			});
		$('input:checkbox').removeAttr('checked');
		
	});
		</script>


	<script type="text/javascript">
	$(document).ready(function(){
		$("#close_compare").click(function(){
			$("#comparecart").hide();
			$('.addtocompare').prop('checked', false); 
		});
	});
	</script>
</head>
<body>
	<div class="container">
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
	
	<div class="col-md-8 background">
			<b> Showing all the products in the category </b><br><br>
			
			<s:iterator value="productinfo">
				<div class="col-md-4">
						<div class="border">
								<br>
								<center>
								<s:if test="%{availableQuantity == 0}">
									<a href="#">
										<img src="<s:property value="image"/>" alt="<s:property value="productID"/>" height="140px" width="auto" ><br>
										<img src="asset/Images/outofstock.jpg" alt="outofstock" height="40px">
									</a>
								</s:if>
								<s:if test="%{availableQuantity != 0}">
									<s:if test="%{availableQuantity >= minimumQuantity}">
										<s:if test="%{offer==0}">
											<a href="getProductDetail?productID=<s:property value="productID"/>">
												<img src="<s:property value="image"/>" alt="<s:property value="productID"/>" height="140px" width="auto" >
												<br><br><br>
											</a>
										</s:if>
										<s:if test="%{offer>0}">
											<a href="getProductDetail?productID=<s:property value="productID"/>">
												<img src="<s:property value="image"/>" alt="<s:property value="productID"/>" height="140px" width="auto" ><br>
												<img src="asset/Images/offer.jpg" alt="offer" height="40px" >
												
											</a>
										</s:if>
									</s:if>
									<s:if test="%{availableQuantity < minimumQuantity}">
											<a href="#">
												<img src="<s:property value="image"/>" alt="<s:property value="productID"/>" height="140px" width="auto" ><br>
												<img src="asset/Images/outofstock.jpg" alt="outofstock" height="40px">
											</a>
									</s:if>
								</s:if>
								<div class="giveMeEllipsis">
								<a href="getProductDetail?productID=<s:property value="productID"/>">
									<font size="4" color="black"><s:property value="productName"/></font><br>
								</a>
								</div>
								<hr>
								<s:if test="%{offer==0}">
									<font size="5px" color="#76553B">
										Rs. <s:property value="price"/><br>
									</font>
								</s:if>
								<s:if test="%{offer>0}">
									<font size="5px" color="#76553B">
									Rs. ${price-offer}
									</font>
								</s:if>
								<hr>
								This item has manufacturer warranty of <s:property value="warranty"/> years.<br>
								<hr>
								<s:if test="%{availableQuantity == 0}">
								<input type="checkbox" disabled >Add To Compare</input>
								</s:if>
								<s:elseif test="%{availableQuantity < minimumQuantity}">
								<input type="checkbox" disabled >Add To Compare</input>
								</s:elseif>
								<s:else>
									<input type="checkbox" id="productID" class="addtocompare" name="compare" pid="<s:property value="productID"/> "/>Add To Compare</input>
								</s:else>
								<hr>
						
								<br><br><br>
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

	</div>
<<<<<<< HEAD
<div id="comparecart">Compare Products
<a class="close-reveal-modal" id="close_compare">&#215;</a>
				<div id="list">
				
				
				</div>
<input type = "button" id="compare_button" class="compare_button" value="Compare"/>
</div>
				
=======
	<br>			
>>>>>>> branch 'master' of https://github.com/Live-Oak/FlipKartProject.git
</body>
</html>
