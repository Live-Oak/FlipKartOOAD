<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Shopping India-Shop online for Books, Mobile Phone, Digital Cameras, Watches and More at Flipkart.com</title>
<link rel="icon" type="/favicon.png" href="asset/Images/flipkartlogo.png"> 

<!-- Custom styles for this template -->
<link href="asset/CSS/Index.css" rel="stylesheet">
<link href="asset/CSS/headerstyle.css" rel="stylesheet">
<link href="asset/CSS/starter-template.css" rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="asset/CSS/bootstrap.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="asset/CSS/bootstrap-theme.min.css" rel="stylesheet">

<script src="asset/JavaScripts/jquery-2.0.3.js"></script>
<script src="asset/JavaScripts/bootstrap.min.js"></script>
<script src="asset/JavaScripts/drophover.js"></script>
<link rel="stylesheet" href="asset/CSS/reveal.css">	
<link rel="stylesheet" href="asset/CSS/jquery-ui.css">
<link rel="stylesheet" href="asset/CSS/cart.css">	
<script type="text/javascript" src="asset/JavaScripts/jquery-ui.js"></script> 
<script type="text/javascript" src="asset/JavaScripts/jquery.reveal.js"></script>
<script src="asset/JavaScripts/cart.js"></script>
    
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
 
    	  
		  /* This is the function that will get executed after the DOM is fully loaded */
		  function bind_func() 
		  {			  
		    $( "#DOB").datepicker({dateFormat: 'yy-mm-dd'});
		  }	
		
	</script>


<!-- ------------------------Feedback------------------------- -->
	
	
	<style type="text/css">
	
	  *{margin:0px;padding:0px;}
      #suggestPost
      {
        background:transparent url(asset/Images/suggest-post.png) no-repeat scroll 0px 0px;
        height:170px;
        position:fixed;
        top:300px;
        width:40px;
        right:0px;
        margine-right:0px;
        padding-right:0px;
      }
      div#suggestPost:hover
      {
        background-position: 0px 0px;
      }
      #suggestPost a
      {
        display:block;
        height:170px;
        width:40px;
      }
	      
      #funkystyling {
    background: white url(asset/Images/search.jpg) left no-repeat;
    padding-left: 17px;
}
    </style>
	
	
<!-- -------------------------------------------------------------------- -->	

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
					  <input type="text" name="friendId" class="form-control" id="funkystyling" placeholder="   Search for a product category or brand"> 
					</div>
				<div class="col-md-1">
					<a href="#" class="big-link" data-reveal-id="myModal1">Signup</a><br>
					<button type="submit" class="btn btn-warning" >SEARCH</button>
				</div>
				
				<div class="col-md-2" >
					<a href="#" class="big-link" data-reveal-id="myModal">Login</a><br>
					<button id="cartButton" type="submit" class="btn btn-primary" > <img src="asset/Images/cart.png" alt="cart" height="20px" width="30px">  CART (0) </button>
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
	
	<!-- Carousel -->
	
	<div class="col-md-2 "></div>
	
	<div class="col-md-7">
			<div>
				<center>
					<div id="myCarousel" class="carousel slide">
						<!-- Indicators -->
						 <ol class="carousel-indicators">
					        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
					        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
					        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
					        <li data-target="#myCarousel" data-slide-to="3" class=""></li>
					      </ol>
						<div class="carousel-inner">
							<div class="item">
								<img src="asset/Images/1.jpg" alt="First slide"
									style="height: 350px; width: 100%; display: block;">
							</div>
							<div class="item active">
								<img src="asset/Images/2.jpg" alt="Second slide"
									style="height: 350px; width: 100%; display: block;">
							</div>
							<div class="item">
								<img src="asset/Images/3.jpg" alt="Third slide"
									style="height: 350px; width: 100%; display: block;">
							</div>
							<div class="item">
								<img src="asset/Images/4.jpg" alt="Third slide"
									style="height: 350px; width: 100%; display: block;">
							</div>
						</div>
						
						 <div style="text-align:center;">
						 	  <div class="col-md-3">
						 	  	<button type="button" class="btn slide-one">HOLI SALE <br> EXTRA 25% & 35% OFF</button>
						      </div>
						      <div class="col-md-3">
						      	<button type="button" class="btn slide-two">EXTRA 25% & 35% OFF <br> ON MENS WEAR</button>
						      </div>
						      <div class="col-md-3">
						        <button type="button" class="btn slide-three">EXTRA RUPEES 1,599 & <br> 10% DISCOUNT</button>
  							  </div>
  							  <div class="col-md-3">
						        <button type="button" class="btn slide-four">EXTRA RUPEES 1,599 <br> & 10% DISCOUNT</button>
  							  </div>
  						 </div>
						<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> 
						<a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-left"></span></a>
					</div>
				</center>
				<br> <br>
			</div>
		</div>
		
		<!-- Side of the page -->
	<div class="col-md-2">
			<div class="border">
			<center> 
				  <h5> <b> SHOP.</b> </h5>  
				  <h5> <b> ANYTIME.ANYWHERE. </b> </h5> 
				  <h6> with the Flipkart Mobile App </h6> 
				  <a href="apppage"> 
				  <img src="asset/Images/leftsmall.png" alt="anytime anywhere" height="120px" width="200px">
				  </a>
				  <h6> GET THE APP </h6>
			  </center>
			 </div>
			 <br>
			 <div class="border">
			<center> 
				 <h6> <b> EXCLUSIVELY ON FLIPKART </b> </h6> 
				 <a href="motopage">
				<img src="asset/Images/smalladdbottom.jpg" alt="exclusive on flipkart" height="130px" width="160px">
			</a> </center>
			</div>
		</div> 
		
	<div class="col-md-1">
	
			<br><br><br><br><br><br><br><br><br><br><br>
			
			<div id="suggestPost"><a href="#" ></a></div>
	</div>	
			
		<!-- Data on the page -->
		<br>
		<br>
		<div class="col-md-2"></div>
		
		<div class="col-md-7">
			
		<div class="container">
				<div class="row">
						ELECTRONICS
				</div>
	<!-- ----------------------------------------------------------------- -->
			
		 <div class="scroll-pane ui-widget ui-widget-header ui-corner-all">
			  <div id="slider" class="scroll-content">
			   <div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/mobile.jpg" alt="mobile" height="90px" width="90px"><br>
				</a>
				<h6> Mobile </h6>
			   </div>
				    
			    <div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/laptop.jpg" alt="laptop" height="90px" width="90px"><br>
				</a>
				<h6> Laptop </h6>
			   </div>
			   
			   <div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/tablet.png" alt="tablet" height="90px" width="90px"><br>
				</a>
				<h6> Tablet </h6>
			   </div>
			   
			  	<div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/camera.jpg" alt="camera" height="90px" width="90px"><br>
				</a>
				<h6> Camera </h6>
			   </div>
			   
			  	<div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/mobileaccessories.jpg" alt="mobileaccessories" height="80px" width="90px"><br>
				</a>
				<h6> Mobile Accessories </h6>
			   </div>
			   
			   <div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/laptopaccessories.jpg" alt="Laptopaccessories" height="80px" width="90px"><br>
				</a>
				<h6> Laptop Accessories </h6>
			   </div>
			   
			   <div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/audio&video.jpg" alt="audio&video" height="90px" width="90px"><br>
				</a>
				<h6> Audio & Video </h6>
			   </div>
			   
			   <div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/gamingconsoles.jpg" alt="gamingconsoles" height="80px" width="90px"><br>
				</a>
				<h6> Gaming Consoles </h6>
			   </div>
			   
			   <div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/personal.jpg" alt="personal" height="80px" width="90px"><br>
				</a>
				<h6> Personal Appliances </h6>
			   </div>
			    
				<div class="scroll-content-item ui-widget-header border">
			  	<a href="#">
				    	<img src="asset/Images/healthcare.jpg" alt="healthcare" height="80px" width="90px"><br>
				</a>
				<h6> Healthcare Devices </h6>
			   </div>
			   
			  <div class="scroll-bar-wrap ui-widget-content ui-corner-bottom">
			    <div class="scroll-bar"></div>
			  </div>
			</div>
		</div>
			
			<!-- ------------------------------------------------------------------- -->
			
			
				<div class="col-md-3">
					<br>
					<div class="border">
						<img src="asset/Images/ipads.jpg" alt="ipad" height="230px" width="145px" >
					</div>
					<br>
				</div>
				
				<div class="col-md-6">
					<br>
					<div class="border">
						<img src="asset/Images/router.jpg" alt="router" height="230px" width="350px">
					</div>
					<br>
				</div>
				
				<div class="col-md-3">
					<br>
					<div class="border">
						<img src="asset/Images/homeappliance.jpg" alt="homeappliance" height="230px" >
					</div>
					<br>
				</div>
				
			</div>
			
		
			<div class="container">
				<div class="row">
						FASHION
				</div>
			</div>
			
			<div class="container">
				<div class="row">
						BOOKS
				</div>	
			</div>
			
			<div class="container">
				<div class="row">
						ALL OTHER STORE
				</div>
			</div>
			
		</div>
		
		<div class="col-md-2">
			<br><br>
			<div class="border">
				<center> <h6> <i> DEAL OF THE DAY </i></h6>
				<a href="dealoftheday">
				<img src="asset/Images/dealoftheday1.jpg" alt="dealoftheday1" height="60px" width="60px">
				<img src="asset/Images/dealoftheday.jpg" alt="dealoftheday" height="80px" width="80px">
				</a>
				<h6> <b> Apple Ipod shuffle (2GB) </b></h6></center>
			</div>
			<br><br>
			
			<div class="border">
				<center> <h6> <i>  REALLY ALL YOU WANT INSTANTLY </i></h6>
				<h6> Download and read Ebooks Instantly. Read Ebboks across your mobile, tablets or computers.</h6>
				<a href="ebooks">
				<img src="asset/Images/flipkartbook.png" alt="FLIPKART" height="100px" width="150px">
				</a>
				</center>
			</div>
			
			<br><br><br>
			<div class="border">
				<center> <h6> <i> SEND GIFTS </i></h6>
				<h6> Last minute gifting is now only a few click away!
				 Send e-gift vouchers to your loved ones instantly.
				</h6>
				<img src="asset/Images/GIFTS.jpg" alt="Gifts" height="100px" width="150px">
				<button class="btn btn-danger" type="button">SEND E-GIFT VOUCHER</button>
			
				</center>
		
			</div>
		</div>
		
		<!--  Footer of the page -->
	
		<div class="col-md-2"></div>
		
		<div class="col-md-2">
			<table>
				<tr> <th> Help </th> </tr>
				<tr> <td> Payments </td> </tr>
				<tr> <td> Saved Cards </td> </tr>
				<tr> <td> Shipping </td> </tr>
				<tr> <td> Cancellation & Returns </td> </tr>
				<tr> <td> FAQ </td> </tr>
			</table>
		</div>
		
		<div class="col-md-2">
			<table>
				<tr> <th> FLIPKART </th> </tr>
				<tr> <td> Contact Us </td> </tr>
				<tr> <td> About Us </td> </tr>
				<tr> <td> Careers </td> </tr>
				<tr> <td> Blog </td> </tr>
				<tr> <td> Press </td> </tr>
			</table>
		</div>
		
		<div class="col-md-2">
			<table>
				<tr> <th> FLIPKART EBOOKS </th> </tr>
				<tr> <td> eBooks Quick Start Guide </td> </tr>
				<tr> <td> eBooks FAQ </td> </tr>
				<tr> <td> eBooks App </td> </tr>
			</table>
		</div>
		
		<div class="col-md-3">
			<table>
				<tr> <th> MISC </th> </tr>
				<tr> <td> Online Shopping </td> </tr>
				<tr> <td> Affilliate </td> </tr>
				<tr> <td> e-Gift Voucher </td> </tr>
				<tr> <td> Flipkart lite </td> </tr>
			</table>
		</div>
		
		<div class="col-md-1"></div>
	
	
		<script>
   $(function(){
      // Cycles the carousel to a particular frame 
      $(".slide-one").click(function(){
         $("#myCarousel").carousel(0);
      });
      $(".slide-two").click(function(){
         $("#myCarousel").carousel(1);
      });
      $(".slide-three").click(function(){
         $("#myCarousel").carousel(2);
      });
      $(".slide-four").click(function(){
          $("#myCarousel").carousel(3);
       });
   });
</script>

<style>
  .scroll-pane { overflow: auto; width: 99%; float:left; }
  .scroll-content { width: 1200px; float: left; }
  .scroll-content-item { width: 100px; height: 120px; float: left; margin: 10px; font-size: 3em; line-height: 96px; text-align: center; }
  .scroll-bar-wrap { clear: left; padding: 0 4px 0 2px; margin: 0 -1px -1px -1px; }
  .scroll-bar-wrap .ui-slider { background: none; border:0; height: 2em; margin: 0 auto;  }
  .scroll-bar-wrap .ui-handle-helper-parent { position: relative; width: 100%; height: 100%; margin: 0 auto; }
  .scroll-bar-wrap .ui-slider-handle { top:.2em; height: 1.5em; }
  .scroll-bar-wrap .ui-slider-handle .ui-icon { margin: -8px auto 0; position: relative; top: 50%; }
  </style>
  <script>
  $(function() {
    //scrollpane parts
    var scrollPane = $( ".scroll-pane" ),
      scrollContent = $( ".scroll-content" );
 
    //build slider
    var scrollbar = $( ".scroll-bar" ).slider({
      slide: function( event, ui ) {
        if ( scrollContent.width() > scrollPane.width() ) {
          scrollContent.css( "margin-left", Math.round(
            ui.value / 100 * ( scrollPane.width() - scrollContent.width() )
          ) + "px" );
        } else {
          scrollContent.css( "margin-left", 0 );
        }
      }
    });
 
    //append icon to handle
    var handleHelper = scrollbar.find( ".ui-slider-handle" )
    .mousedown(function() {
      scrollbar.width( handleHelper.width() );
    })
    .mouseup(function() {
      scrollbar.width( "100%" );
    })
    .append( "<span class='ui-icon ui-icon-grip-dotted-vertical'></span>" )
    .wrap( "<div class='ui-handle-helper-parent'></div>" ).parent();
 
    //change overflow to hidden now that slider handles the scrolling
    scrollPane.css( "overflow", "hidden" );
 
    //size scrollbar and handle proportionally to scroll distance
    function sizeScrollbar() {
      var remainder = scrollContent.width() - scrollPane.width();
      var proportion = remainder / scrollContent.width();
      var handleSize = scrollPane.width() - ( proportion * scrollPane.width() );
      scrollbar.find( ".ui-slider-handle" ).css({
        width: handleSize,
        "margin-left": -handleSize / 2
      });
      handleHelper.width( "" ).width( scrollbar.width() - handleSize );
    }
 
    //reset slider value based on scroll content position
    function resetValue() {
      var remainder = scrollPane.width() - scrollContent.width();
      var leftVal = scrollContent.css( "margin-left" ) === "auto" ? 0 :
        parseInt( scrollContent.css( "margin-left" ) );
      var percentage = Math.round( leftVal / remainder * 100 );
      scrollbar.slider( "value", percentage );
    }
 
    //if the slider is 100% and window gets larger, reveal content
    function reflowContent() {
        var showing = scrollContent.width() + parseInt( scrollContent.css( "margin-left" ), 10 );
        var gap = scrollPane.width() - showing;
        if ( gap > 0 ) {
          scrollContent.css( "margin-left", parseInt( scrollContent.css( "margin-left" ), 10 ) + gap );
        }
    }
 
    //change handle position on window resize
    $( window ).resize(function() {
      resetValue();
      sizeScrollbar();
      reflowContent();
    });
    //init scrollbar size
    setTimeout( sizeScrollbar, 10 );//safari wants a timeout
  });
  </script>
  
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
  
  
  
<div id="myModal1" class="reveal-modal" onload="bind_func()">
		
		        <h2 align="center">Sign Up</h2>
		      	<hr>
		<br>
		<form name="form_signup" onsubmit="return(validate());">
			<input type="text" class="textbox" placeholder="Enter Username" required autofocus><br>
			<input type="text" class="textbox" placeholder="Enter First Name" required><br>
			<input type="text" class="textbox" placeholder="Enter Last Name" required><br>
			<input type="text" id="DOB" name="DOB" class="textbox" placeholder="Enter Date"  required><br><br>

			<input type="password" class="textbox" name="password" placeholder="Enter Password" required><br>
			<input type="password" class="textbox" name="reenter_password" placeholder="Re-Enter Password" required><br><br>
		        
			<textarea rows="2" cols="18" name="address1" class="textbox" placeholder="Enter Address 1" required></textarea><br>
			<textarea rows="2" cols="18" name="address2" class="textbox" placeholder="Enter Address 2" required></textarea><br>
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
			<button type="submit" id="create_account" class="signin_link" onclick="phonenumber(document.form_signup.phone)">SIGN UP NOW!</button>
			<script type="text/javascript">
			function phonenumber(inputtxt)  
			{  
			  var phoneno = /^\d{10}$/;  
			  if(inputtxt.value.match(phoneno))  
			  {  
			      return true;  
			  }  
			  else  
			  {  
			     alert("Not a valid Phone Number");  
			     return false;  
			  }  
			  }  
        	</script>
			<button type="reset" id="create_account">RESET!</button><br>
				
		</form>

		<a  class="Signup big-link Close" data-reveal-id="myModal">Already a user?</a>
			<a class="close_button Close">&#215;</a>	
	</div>

  	<div id="cartModel" class="cart-revealmodel" style="top: 100px; opacity: 1; visibility: hidden;z-index: 2001;">
		<div id="cartHeader" class="cart-header">CART(0)</div>
		<div class="cartContainer">
			<center>
			<div id="emptyCart" class="empty-cart">
				There are no items in this cart.<br><br>
				<button id="continueShopping" type="button" class="btn btn-primary" > CONTINUE SHOPPING </button>
			</div>
			</center>
		</div>
		<a class="close-reveal-modal">×</a>
		<a href="http://localhost:8080/FlipKart/place.jsp"><button id="continueShopping" type="button" class="btn btn-primary" style="float:right;">PLACE ORDER</button></a>
	</div>
  	<div class="reveal-modal-bg" style="display: none; cursor: pointer;z-index: 2000;"></div>
  
  
  
</body>
</html>
