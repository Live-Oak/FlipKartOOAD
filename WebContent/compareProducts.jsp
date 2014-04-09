<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
   
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="asset/CSS/CompareProducts.css" rel="stylesheet">	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compare Products</title>
<link href="asset/CSS/Index.css" rel="stylesheet">
	<link href="asset/CSS/starter-template.css" rel="stylesheet">
		<link href="asset/CSS/CompareProducts.css" rel="stylesheet">
	
	<!-- Bootstrap core CSS -->
	<link href="asset/CSS/bootstrap.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
	
	<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
	<script src="asset/JavaScripts/bootstrap.min.js"></script>
	<script src="asset/JavaScripts/jquery-1.9.1.js"></script>
	<script src="asset/JavaScripts/jquery-ui.js"></script>
	
	
<script>
	$(document).ready(function()
	{
	      $("#close").click(function(){
	    	  
	    	  alert("hello");
	    	  $(".show_product").hide();
	    	  $(".show_chose_product").show();
	    	  
	      });
	      
	      $("#dropdown").change(function(event) 
	    	{
	    	  var nameofproduct;
	    	  myparent = $(event.target).parent();
	    	  var obj = $(this);
	    	  nameofproduct=$("#dropdown option:selected").text();
	    	    alert(nameofproduct);
	    		$.ajax({
	    		    type: 'POST',	    
	    		    url:'retrieveProduct?productname=' + nameofproduct ,
	    		    success: function(data){
	    		    	var parentdiv=myparent.attr('class');
	    		    				alert(data.productname);
	    		    				alert(data.count);
	    		    				$.each(data.productInfoAdded, function(count,productcompare) 
	    						    		{ 	
	    		    							alert(parentdiv);
	    		    							
	    						    			product_id_to_send=productcompare.productId;
	    						    			obj.hide();
	    					    				obj.parent().append("<div style='height:50px;' class='col-md-2' class='border'>"+"<center>"+
	    					    						"<div class='remove'><a style='color:black;'>&#215</a></div><br>"+		
	    							    				"<img src='"+productcompare.image+"' height='60px' width='60px' style='float:left' /><br>"+		    												    				
	    					    						"<div class='productName'>"+productcompare.productName+"</div>"+
	    					    						
	    					    				"</center>"+"</div>");	
	    					    				
	    					    				$('.hello').append("<h1>hello</h1>");
	    					    			});
	    						    		
	    		    }});	

	    	});
	});
</script>

</head>
<body>
<strong>Compare Products</strong>
	<div class="container">
		<div class="col-md-1 "></div>
		<div class="col-md-2">
					<div class="border">
						<center>
							<br><br><br>
							<p>You can add upto 4 items for comparison</p>	
							<br><br><br><br><br><br>
							<hr>
							<p>Price</p>
							<hr>
							<p>Availability</p>
							<hr>
							<p>Warranty</p>
							<hr>
						</center>						
				 	</div> 
		</div>

<div class="col-md-8 background">
	<%@ page import="edu.iiitb.model.*" %>
		<s:iterator value="productinfo">
				<div class="col-md-3">
						<div class="border">
							<div class="show_product">
<!-- 								<a class="close-reveal-modal" id="close">&#215;</a> -->
								<br>
								<center>
										<img src="<s:property value="image"/>" alt="<s:property value="productID"/>" height="140px" width="auto" >
										<br><br><br>
									
								<div class="giveMeEllipsis">
										<font size="4" color="black"><s:property value="productName"/></font><br>
								</div>
								<hr>
								<strong>
									<font size="4px" color="#BB0000">
										Rs. <s:property value="price"/><br>
									</font>
								</strong>	
								<hr>
								This item has manufacturer warranty of <s:property value="warranty"/> years.<br>
								<hr>
						
								<br><br><br>
							</center>
							</div>
						</div>
					</div>
			</s:iterator>
									<!-- If 3 products to compare -->
										<%int count =2; %>	
										<%
											if(count==3) {
											%>
											<div class="col-md-3">
												<div class="border">
												<br>
												<div class="show_chose_product">
												<center>
													<strong>Add to compare</strong>
													<br><br><br><br><br><br><br><br><br>
														<div>
																<div class="mainselection">
															     <select id="dropdown2">
															     		<option value="Add Product">Add Product</option>
															     	<s:iterator value="categoryproducts">
																  		<option value="<s:property/>"><s:property/></option>
																  	</s:iterator>
																</select>   
																</div>
														</div>					
													<br><br><br><br><br><br><br><br><br><br>								
												</center>
												</div>
											</div>
											</div>
											<%}
											 else
											{%>
												<div class="col-md-3">
													<div class="border">
													<br>
													<center>
														<strong>Add to compare</strong>
														<div>
														<br><br><br><br><br><br><br><br><br><br><br>
																<div class="mainselection">
															     <select id="dropdown1">
															     		<option value="Add Product">Add Product</option>
															     	<s:iterator value="categoryproducts">
																  		<option value="<s:property/>"><s:property/></option>
																  	</s:iterator>
																</select>   
																</div>
														</div>
														<br><br><br><br><br><br><br><br><br>
													</center>
												</div>
												</div>
												<div class="col-md-3">
													<div class="border">
													<br>
													<center>
														<strong>Add to compare</strong>
														
														<br><br><br><br><br><br><br><br><br><br><br>
																<div class="mainselection">
															     <select id="dropdown">
															     		<option value="Add Product">Add Product</option>
															     	<s:iterator value="categoryproducts">
																  		<option value="<s:property/>"><s:property/></option>
																  	</s:iterator>
																</select>   
																</div>
														<br><br><br><br><br><br><br><br><br>
														
													</center>
												</div>
												</div>	
											<%}%>
										
			</div>
	<div class="col-md-1 "></div>
		
</div>


</body>
</html>



