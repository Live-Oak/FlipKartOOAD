<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Menu</title>
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
	<script src="asset/JavaScripts/drophover.js"></script>
</head>

<body>
	
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
					<input type="text" name="friendId" class="form-control" placeholder="Search">
				</div>
				<div class="col-md-1">
				<br>
					<button type="submit" class="btn btn-warning"> SEARCH</button>
				</div>
				
				<div class="col-md-2">
				<br>
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
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse navbar-ex1-collapse">
					<ul class="nav nav-pills">
						<li><a href="#">ELECTRONICS <span class="caret"></span></a></li>
						<li><a href="#">MEN <span class="caret"></span></a></li>
						<li><a href="#">WOMEN <span class="caret"></span></a></li>
						<li><a href="#">BABY & KIDS <span class="caret"></span></a></li>
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

</body>
</html>