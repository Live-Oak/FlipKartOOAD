<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript" src="asset/JavaScripts/jquery-1.4.4.min.js"></script> 
<script type="text/javascript" src="asset/JavaScripts/jquery-1.6.min.js"></script>
<script type="text/javascript" src="asset/JavaScripts/jquery.reveal.js"></script>
<script type="text/javascript" src="asset/JavaScripts/jquery-ui.js"></script> 
	
	<!-- Bootstrap core CSS -->
	<link href="asset/CSS/bootstrap.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">
	
	<script src="asset/JavaScripts/jquery-1.9.1.js"></script>
	<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
	<script src="asset/JavaScripts/bootstrap.min.js"></script>
	<script src="asset/JavaScripts/drophover.js"></script>
	
	<style type="text/css">
	  #funkystyling {
    background: white url(asset/Images/search.jpg) left no-repeat;
    padding-left: 17px;
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
    
    
    
</head>

<body>
    <script type="text/javascript">
		$(document).ready(	  
		  /* This is the function that will get executed after the DOM is fully loaded */
		  function () 
		  {			  
		    $( "#DOB").datepicker({dateFormat: 'yy-mm-dd'});
		  }	
		);
	</script>
	
<!-- The first layer with logo and search -->

	<div class="navbar-fixed-top">
	<div class="col-md-2"></div>
		<div class="col-md-2">
				<img alt="flipkart" src="asset/Images/flipkart.png" height="45px" width="150px">
				<br> <font color="white" size="1.5px">&nbsp;&nbsp;&nbsp;&nbsp;The Online Megastore</font>
		</div>

			<div class="container">
				<div class="col-md-5">	
					<br>
					  <input type="text" name="friendId" class="form-control" id="funkystyling" placeholder="   Search for a product category or brand"> 
					</div>
				<div class="col-md-1">
					<a href="#" class="big-link" data-reveal-id="myModal1">Signup</a><br>
					<button type="submit" class="btn btn-warning" >SEARCH</button>
				</div>
				
				<div class="col-md-2">
					<a href="#" class="big-link" data-reveal-id="myModal">Login</a><br>					
					<button type="submit" class="btn btn-primary" > <img src="asset/Images/cart.png" alt="cart" height="20px" width="30px">  CART</button>
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
				
				<div class="navbar-collapse collapse navbar-ex1-collapse">
					<ul class="nav nav-pills">
						<li><a href="#">ELECTRONICS<span class="caret"></span></a></li>
						<li><a href="#">MEN <span class="caret"></span></a></li>
						<li><a href="#">WOMEN<span class="caret"></span></a></li>
						<li><a href="#">BABY & KIDS<span class="caret"></span></a></li>
						<li><a href="#">BOOKS & MEDIA <span class="caret"></span></a></li>
						<li><a href="#">HOME & KITCHEN <span class="caret"></span></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">MORE STORE <span class="caret"></span></a>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" role="menu">
								<li><a href="#">SPORTS & FITNESS </a></li>
								<li class="divider" role="presentation"></li>
								<li><a href="#">TEAM SPORTS</a></li>
								<li><a href="#">INDOOR GAMES</a></li>
								<li><a href="#">OTHER SPORTS</a></li>
								<li><a href="#">FITNESS</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	

<div id="myModal" class="reveal-modal">
		
		        <h2 align="center">Login</h2>
		      	<hr>

		<br>
		<form id="form_login" action="login" method="post">
			<input type="text" class="textbox" name="name" placeholder="Email Adderess" required autofocus><br><br>
			<input type="password" class="textbox" name="pwd" placeholder="Enter Password" required><br><br><br>
			<button type="submit" class="css_button">LOGIN</button>
		</form>
<br>
		<div class="forgot_password">
		    <p>FORGOT YOUR PASSWORD?</p>
				<form class="forgot_password_form" action="#">
	           			<input type="email" class="textbox" name="email" size="18" placeholder="E-mail address" />
	            		<button type="submit" class="css_button" >SUBMIT</button>
	    			</form>
		</div>
<a class="Signup big-link Close" data-reveal-id="myModal1">New User?</a>	
<a class="close_button Close">&#215;</a>		
</div>

<div id="myModal1" class="reveal-modal">
		
		        <h2 align="center">Sign Up</h2>
		      	<hr>
		<br>
		<form name="form_signup" onsubmit="return(validate());">
			<input type="text" class="textbox" placeholder="Enter Username" required autofocus><br>
			<input type="text" class="textbox" placeholder="Enter First Name" required><br>
			<input type="text" class="textbox" placeholder="Enter Last Name" required><br>
			<input type="text" id="DOB" name="DOB" class="textbox" placeholder="Enter Date of Birth"  required><br><br>

			<input type="password" class="textbox" name="password" placeholder="Enter Password" required><br>
			<input type="password" class="textbox" name="reenter_password" placeholder="Re-Enter Password" required><br><br>
		        
			<textarea rows="2" cols="18" name="address1" class="textbox" placeholder="Enter Address 1" required></textarea><br>
			<textarea rows="2" cols="18" name="address2" class="textbox" placeholder="Enter Address 1" required></textarea><br>
			<input type="text" id="city" class="textbox" placeholder="Enter City"  required><br>
			<input type="text" id="country" class="textbox" placeholder="Enter Country"  required><br>
			<input type="number" id="pincode" class="textbox" placeholder="Enter Pincode"  required onkeypress="return IsNumeric(event);" ondrop="return false;" onpaste="return false;">
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
			<input type="email" id="email" class="textbox" placeholder="Enter e-mail"  required><br>
			<input type="text" id="phone" class="textbox" placeholder="Enter Phone no"  required><br><br>
			<button type="submit" id="create_account">SIGN UP NOW!</button>
			<button type="reset" id="create_account">RESET!</button><br>
			<a href="#" class="Signup big-link Close" data-reveal-id="myModal">Already a user?</a>	
		</form>
			<a class="close_button Close">&#215;</a>
	</div>











</body>
</html>