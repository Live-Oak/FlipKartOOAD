
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Menu</title>
	<link rel="icon" type="/favicon.png" href="asset/Images/flipkartlogo.png">
	<!-- Custom styles for this template -->
	<link href="asset/CSS/Index.css" rel="stylesheet">
	<link rel="stylesheet" href="asset/CSS/jquery-ui.css">
	<link href="asset/CSS/starter-template.css" rel="stylesheet">
<!-- 	<link rel="stylesheet" href="asset/CSS/login.css"> -->
<link rel="stylesheet" href="asset/CSS/reveal.css">	
	
	<!-- Bootstrap core CSS -->
	<link href="asset/CSS/bootstrap.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
	<link href="asset/CSS/cart.css" rel="stylesheet">
	<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
	<script src="asset/JavaScripts/bootstrap.min.js"></script>
	<script src="asset/JavaScripts/jquery-ui.js"></script>
	<script src="asset/JavaScripts/drophover.js"></script>
	<script src="asset/JavaScripts/jquery.reveal.js"></script>
	<script src="asset/JavaScripts/cart.js"></script>
	
	
	
	<style type="text/css">
	  #funkystyling {
    background: white url(asset/Images/search.jpg) left no-repeat;
    padding-left: 27px;
	}
    </style>
    
<script type="text/javascript">
<!--
// Form validation code will come here.
function validate()
{
 
   if( document.form_signup.password.value != document.form_signup.reenter_password.value )
   {
     alert( "Paaswords entered do not match!!" );
     document.form_signup.password.focus() ;
     return false;
   }
}

</script>
    
<script type="text/javascript">
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


</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#forgot_password_button").click(function()
			{
		$.ajax({
		    type: 'POST',	    
		    url:'forgot_password_validation ?email=' + $("#email_forgot").val() ,
		    success: function(data){
		    	$("#check_email_forgot").html(data.message);
		    	var status=$("#check_email_forgot").html();
		    	if(status=="available")
		    		{
					$("#forgot_password_form").submit();		    			
		    		}
		    	else
		    		{
		    			$("#check_email_forgot").html("Invalid email Id");
		    		}
		     }});	
	});
});


</script>

<script type="text/javascript">
$(document).ready(function(){
	$("#create_account").click(function()
			{
    	
		var status=$("#notify").html();
		if(status=="Enjoy Flipkart User Experience")
		{
			
			$("#form_signup").submit();
		}
		else
		{
			$("#notify").html("Please check Email id availabilty");
		}
			
	});
	
});

</script>
<script type="text/javascript">
$(document).ready(function(){
	$("p").click(function()
			{
		$.ajax({
		    type: 'POST',	    
		    url:'useravailable?email='+$("#email").val(),
		    success: function(data){
		    	
		    	$("#notify").html(data.message);
		     }});	
	});
});


</script>

<script type="text/javascript">
	$(document).ready(function(){
		var categoryid=1;
		var temp;
			$.ajax({
			    type: 'POST',	    
			    url:'getCatagories?category=' + categoryid,
			    success: function(data){
			    	$.each(data.categoryModel1, function(count, stock) {
			    		temp += '<li ><a href="getSearchresult?categoryname='+stock.categoryName+'">'+stock.categoryName+'</a></li> <li class="divider" role="presentation"></li>';
			    	});
			    	$("#electronics").html(temp);
			     }
			});
		});
</script> 

<script type="text/javascript">
	$(document).ready(function(){
		var categoryid=12;
		var temp;
			$.ajax({
			    type: 'POST',	    
			    url:'getCatagories?category=' + categoryid,
			    success: function(data){
			    	$.each(data.categoryModel2, function(count, stock) {
			    		temp += '<li ><a href="getSearchresult?categoryname=Men '+stock.categoryName+'">'+stock.categoryName+'</a></li> <li class="divider" role="presentation"></li>';
			    	});
			    	$("#men").html(temp);
			     }
			});
		});
</script> 
	
<script type="text/javascript">
	$(document).ready(function(){
		var categoryid=13;
		var temp;
			$.ajax({
			    type: 'POST',	    
			    url:'getCatagories?category=' + categoryid,
			    success: function(data){
			    	$.each(data.categoryModel3, function(count, stock) {
			    		temp += '<li ><a href="getSearchresult?categoryname=Women '+stock.categoryName+'">'+stock.categoryName+'</a></li> <li class="divider" role="presentation"></li>';
			    	});
			    	$("#women").html(temp);
			     }
			});
		});
</script>    

<script type="text/javascript">
	$(document).ready(function(){
		var categoryid=14;
		var temp;
			$.ajax({
			    type: 'POST',	    
			    url:'getCatagories?category=' + categoryid,
			    success: function(data){
			    	$.each(data.categoryModel4, function(count, stock) {
			    		temp += '<li ><a href="getSearchresult?categoryname='+stock.categoryName+'">'+stock.categoryName+'</a></li> <li class="divider" role="presentation"></li>';
			    	});
			    	$("#baby").html(temp);
			     }
			});
		});
</script>    

<script type="text/javascript">
	$(document).ready(function(){
		var categoryid=3;
		var temp;
			$.ajax({
			    type: 'POST',	    
			    url:'getCatagories?category=' + categoryid,
			    success: function(data){
			    	$.each(data.categoryModel5, function(count, stock) {
			    		temp += '<li ><a href="getSearchresult?categoryname='+stock.categoryName+'">'+stock.categoryName+'</a></li> <li class="divider" role="presentation"></li>';
			    	});
			    	$("#books").html(temp);
			     }
			});
		});
</script>     
 
<script type="text/javascript">
	$(document).ready(function(){
		var categoryid=34;
		var temp;
			$.ajax({
			    type: 'POST',	    
			    url:'getCatagories?category=' + categoryid,
			    success: function(data){
			    	$.each(data.categoryModel6, function(count, stock) {
			    		temp += '<li ><a href="getSearchresult?categoryname='+stock.categoryName+'">'+stock.categoryName+'</a></li> <li class="divider" role="presentation"></li>';
			    	});
			    	$("#home").html(temp);
			     }
			});
		});
</script>    

<script type="text/javascript">
	$(document).ready(function(){
		var categoryid=41;
		var temp;
			$.ajax({
			    type: 'POST',	    
			    url:'getCatagories?category=' + categoryid,
			    success: function(data){
			    	$.each(data.categoryModel7, function(count, stock) {
			    		temp += '<li ><a href="getSearchresult?categoryname='+stock.categoryName+'">'+stock.categoryName+'</a></li> <li class="divider" role="presentation"></li>';
			    	});
			    	$("#more").html(temp);
			     }
			});
		});
</script>    

</head>

<body>
 <%@ page import="com.opensymphony.xwork2.ActionContext,com.opensymphony.xwork2.util.ValueStack,javax.servlet.http.HttpSession" %>
 
<%@ page import="edu.iiitb.model.*" %>
    <script type="text/javascript">
		
	</script>
	
<!-- The first layer with logo and search -->

	<div class="navbar-fixed-top">
	<div class="col-md-2"></div>
		<div class="col-md-2">
			<a href="index.jsp" >	<img alt="flipkart" src="asset/Images/flipkart.png" height="45px" width="150px"> 
				<br> <font color="white" size="1.5px">&nbsp;&nbsp;&nbsp;&nbsp;The Online Megastore</font> </a>
		</div>

			<div class="container">
				<form action="Browseresult"  method="post">
					<div class="col-md-5">	
						<br>
						  <input type="text" name="keyword" class="form-control" id="funkystyling" placeholder="   Search for a product category or brand"> 
						</div>
					<div class="col-md-1">
						<%
						if(session.getAttribute("user") == null)
						{
						%>
							<a href="#" class="big-link Close" data-reveal-id="myModal1">Signup</a><br>
						<%
						}else
						{
						%>
							<%Login l = new Login();%>
							
				<li style="list-style-type:none" class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">Hi <%= session.getValue("fname")%>!<span class="caret"></span></a>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
									
										<li><a href="Personal-info">Account</a></li>
										<li class="divider" role="presentation"></li>
										<li><a href="#">Orders</a></li>
										<li class="divider" role="presentation"></li>
										<li><a href="logout">Logout</a></li>
									
							</ul>
						</li>
						<%
						}
						%>
						<button type="submit" class="btn btn-warning" >SEARCH</button>
					</div>
				</form>
				
				<div class="col-md-2">
					
					<%
						if(session.getAttribute("user") == null)
						{
					%>
					<a href="#" class="big-link Close" data-reveal-id="myModal">Login</a><br>					
					<%
						}else
						{
					%>
					
					<a href="logout" class="big-link Close">Logout</a><br>
					<%
						}
					%>
					<a data-reveal-id="cartModel"><button id="cartButton" type="submit" class="btn btn-primary" > <img src="asset/Images/cart.png" alt="cart" height="20px" width="30px;" style="float:left;"> <div id="productCount" style="float:left;"> CART (0) </div> </button></a>
				</div>
				
			</div>
	</div>
		
<!-- The second layer with menu and dropdown -->
	<div class="navbar navbar-inverse">
		<div class="col-md-2"></div>
		
		<div class="col-md-10">
			<div class="container">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					</button>
				</div>
				
				<form action="Start_page" method="post" enctype="multipart/form-data">
				
				<div class="navbar-collapse collapse navbar-ex1-collapse">
					<ul class="nav nav-pills">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">ELECTRONICS<span class="caret"></span></a>
							<ul id="electronics" class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">MEN<span class="caret"></span></a>
							<ul id="men" class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">WOMEN<span class="caret"></span></a>
							<ul id="women" class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">BABY & KIDS<span class="caret"></span></a>
							<ul id="baby" class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">BOOKS & MEDIA<span class="caret"></span></a>
							<ul id="books" class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">HOME & KITCHEN<span class="caret"></span></a>
							<ul id="home" class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">MORE STORE<span class="caret"></span></a>
							<ul id="more" class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
							</ul>
						</li>
					</ul>
				</div>
				
				</form>
			</div>
		</div>
	</div>
	

<div id="myModal" class="reveal-modal">
		
		        <h2 align="center">Login</h2>
		      	<hr>

		<br>
		<form id="form_login" action="loginAction" method="post">
			<input type="email" class="textbox" id="emaill" name="email" placeholder="Email Adderess" required autofocus><br><br>
			<input type="password" class="textbox" name="password" id="passwordl" placeholder="Enter Password" required><br><br><br>
			<label id="check_email_password"></label>
			<button type="button" id="login_button" class="css_button">LOGIN</button>
		</form>
<br>
		<div class="forgot_password">
		    <p>FORGOT YOUR PASSWORD?</p>
				<form class="forgot_password_form" id="forgot_password_form" action="forgotpassword">
	           			<input type="email" class="textbox" id="email_forgot" name="email" size="18" placeholder="E-mail address" />
	            		<label id="check_email_forgot"></label>
	            		<button type="button" id="forgot_password_button" class="css_button" >SUBMIT</button>
	    			</form>
		</div>
<a class="Signup big-link Close" data-reveal-id="myModal1">New User?</a>	
<a class="close_button Close">&#215;</a>		
</div>

<div id="myModal1" class="reveal-modal">
		
		        <h2 align="center">Sign Up</h2>
		      	<hr>
		<br>
		<form id="form_signup" name="form_signup" action="signmeup" onsubmit="return(validate());" method="post">
			<input type="text" class="textbox" name="firstName" placeholder="Enter First Name" required><br>
			<input type="text" class="textbox" name="lastName" placeholder="Enter Last Name" required><br>
			<input type="text" id="DOB" name="date" class="textbox" placeholder="Enter Date of Birth"  required><br><br>

			<input type="password" class="textbox" name="password" placeholder="Enter Password" required><br>
			<input type="password" class="textbox" name="reenter_password" placeholder="Re-Enter Password" required><br><br>
		        
			<textarea rows="2" cols="18" name="address1" class="textbox" placeholder="Enter Address 1" required></textarea><br>
			<textarea rows="2" cols="18" name="address2" class="textbox" placeholder="Enter Address 1" required></textarea><br>
			<input type="text" id="city" name="city" class="textbox" placeholder="Enter City"  required><br>
			<input type="text" id="country" name="country" class="textbox" placeholder="Enter Country"  required><br>
			<input type="text" id="pincode" name="pincode" class="textbox" placeholder="Enter Pincode"  required onkeypress="return IsNumeric(event);" ondrop="return false;" onpaste="return false;">
			<span id="error" style="color: Red; display: none">*Input digits(0-9)</span>
			    <script type="text/javascript">
        			var specialKeys = new Array();
        			specialKeys.push(8); //Backspace
        			function IsNumeric(e) 
				{
        		    	var keyCode = e.which ? e.which : e.keyCode
            			var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            			document.getElementById("error").style.display = ret ? "none" : "inline";
            			return ret;
        			}
			    </script>
			<br><br>
			<input type="email" id="email" name="email" class="textbox" placeholder="Enter e-mail"  required><br>
			<p id="checking">Check for availability</p>
			<label id="notify"></label>
			<input type="text" id="phone" name="phonenumber" class="textbox" placeholder="Enter Phone no"  required onkeypress="return IsNumber(event);" ondrop="return false;" onpaste="return false;"><br><br>
			<span id="error_phone" style="color: Red; display: none">*Input digits(0-9)</span>
			    <script type="text/javascript">
        			var specialKeys = new Array();
        			specialKeys.push(8); //Backspace
        			function IsNumber(e) 
				{
        		    	var keyCode = e.which ? e.which : e.keyCode
            			var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            			document.getElementById("error_phone").style.display = ret ? "none" : "inline";
            			return ret;
        			}
			    </script>
			<button type="button" id="create_account">SIGN UP NOW!</button>
			<button type="reset" id="create_account">RESET!</button><br>
			<a href="#" class="Signup big-link Close" data-reveal-id="myModal">Already a user?</a>	
		</form>
			<a class="close_button Close">&#215;</a>
	</div>
	
	
	<div id="cartModel" class="cart-revealmodel" style="top: 100px; opacity: 1; visibility: hidden;z-index: 2001;">
		<div id="cartHeader" class="cart-header">CART(0)</div>
		<div class="cartContainer">
			<center>
			<div id="emptyCart" class="empty-cart">
				There are no items in this cart.<br><br>
				<button id="continueShopping" type="button" class="btn btn-primary Close" > CONTINUE SHOPPING </button>
			</div>
			<div id="productInfo" class="empty-cart">
				<div style="margin-bottom:50px;">
					<div style='float:left;width:80px;'>IMAGE</div>
		    		<div style='float:left;margin-left:20px;width:200px;'>ITEM</div>
		    		<div style='float:left;margin-left:20px;width:50px;'> QTY </div>
		    		<div style='float:left;margin-left:20px;width:120px;'>PRICE</div>
		    		<div style='float:left;margin-left:20px;width:120px;'>SUB-TOTAL</div>
		    		<div style='float:left;margin-left:20px;'></div>
				</div>
				<div id="list">
				
				
				</div>
				
			</div>
			</center>
		</div>
		<a class="close-reveal-modal Close">�</a>
		<div style="height:50px;">
			<div style="" id="totalCost" class="totalcost">Total Cost : 0</div>
		</div>
		<button id="continueShoppingBottom" type="button" class="btn btn-primary Close" style="float:left"> CONTINUE SHOPPING </button>
		<a href="placeOrderUserSessionCheck"><button id="placeOrder" type="button" class="btn btn-primary" style="float:right;" 
		>PLACE ORDER</button></a>
	</div>
  	<div class="reveal-modal-bg" style="display: none; cursor: pointer;z-index: 2000;"></div>

<script type="text/javascript">
$.ajax({
    type: 'GET',
    url:'getProductsFromCart',
    success: function(data){
    	if( data.count != undefined && data.count != 0  )
		{
    		$("#productCount").html("CART ("+data.count+")");
		}
    }
    });

</script>

</body>
</html>

