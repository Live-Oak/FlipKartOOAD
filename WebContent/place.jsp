<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  
  <script src="asset/JavaScripts/jquery-2.0.3.js"></script>
  
 


<script>
$(document).ready(function(){
  
	$("#pwd").hide();

});
</script>

<script>
$(document).ready(function(){
  
	$("#panel1").show();

});
</script>


<script>
$(document).ready(function(){
  
	$("#editOrder").hide();

});

</script>

<script>
$(document).ready(function(){
  
	$("#editEmailid").hide();

});
</script>

<script>
$(document).ready(function(){
  
	$("#editAddress").hide();

});
</script>


<script>
$(document).ready(function(){
  $("#show").click(function(){
    $("#pwd").toggle();
  });
});
</script>



<script> 
/*$(document).ready(function(){
  $("#flip1").click(function(){
    $("#panel1").slideDown();
    
  });
});*/
</script>


<script> 
$(document).ready(function(){
  $("#nextAddressPage").click(function(){
	  $("#panel2").slideDown();
	  $("#panel1").slideUp();
	  $("#editEmailid").show();
	  
  });
  $("#confirmOrder").click(function(){
	  
	  window.location = "http://localhost:8080/FlipKart/";
	  
  });
});
</script>


<script> 
/*$(document).ready(function(){
  $("#flip2").click(function(){
    $("#panel2").slideDown();
    

  });
});*/
</script>


<script> 
$(document).ready(function(){
  $("#nextOrderPage").click(function(){
	  $("#panel2").slideUp();
	  $("#panel3").slideDown();
	  $("#editAddress").show();
  	  $("#editEmailid").show();
  });
});
</script>

<script> 
$(document).ready(function(){
  $("#nextPaymentPage").click(function(){
    $("#panel4").slideDown();
    $("#panel3").slideUp();
    $("#editOrder").show();
	  $("#editEmailid").show();
	  $("#editAddress").show();

  });
});
</script>
<script> 
$(document).ready(function(){
  $("#nextReceiptPage").click(function(){
	  $("#editOrder").hide(); 
	  $("#editAddress").hide();
	  $("#editEmailid").hide();
    $("#panel4").slideUp();

  });
});
</script>


<script> 
$(document).ready(function(){
  $("#editEmailid").click(function(){
	  $("#editOrder").hide(); 
	  $("#editAddress").hide();
	  $("#editEmailid").hide();
	  $("#panel1").slideDown();
    $("#panel2").slideUp();
    $("#panel3").slideUp();
    $("#panel4").slideUp();

  });
});
</script>

<script> 
$(document).ready(function(){
  $("#editAddress").click(function(){
	  $("#editOrder").hide(); 
	  $("#editEmailid").hide();
	  $("#editAddress").hide();
	  $("#panel2").slideDown();
    $("#panel1").slideUp();
    $("#panel3").slideUp();
    $("#panel4").slideUp();

  });});
  
 </script>
 
 
  <script> 
  $(document).ready(function(){
    $("#editOrder").click(function(){
  	  $("#editOrder").hide(); 
  	  $("#editEmailid").hide();
  	  $("#editAddress").hide();
  	  $("#panel3").slideDown();
      $("#panel1").slideUp();
      $("#panel2").slideUp();
      $("#panel4").slideUp();

    });
});
</script>


<script>
  $(function() {
    $( "#receipt" ).dialog();
  });
  </script>


 
<style type="text/css"> 

.mytext1
{
width: 272px;height: 38px;
}

.mylabel1{
width: 112px;height: 19px; font-size:large;

}



.mysubmit1{
 color:white;
 border:1px orange solid; 
 width:234px; 
 height:40px;
 font-size:large;
  background-color:orange;
}



.myscreenSize{
color:Black;
 border:1px white solid; 
 width:1024px; 
 height:500px;
 float:"center";
left:150px;

position:absolute;

}

.mytext2
{
width: 272px;height: 38px;
left:350px;

position:absolute;
}
.mylabel2{
width: 200px;height:150px;

 font-size:large;
 left:1px;


position:absolute;
}
.mysubmit2{
 color:white;
 border:1px orange solid; 
 width:234px; 
 height:40px;
 font-size:large;
  background-color:orange;
  left:350px;

position:absolute;
}
.mysubmit3{
 color:White;
 border:1px white solid; 
 width:100px; 
 height:25px;
  background-color:orange;
 float:right;
}



#panel1,#flip1
{
padding:5px;
text-align:center;
background-color:cyan;
border:solid 1px #c3c3c3;
}
#panel1
{
padding:50px;
background-color:white;
display:none;
}
#panel2,#flip2
{
padding:5px;
text-align:center;
background-color:cyan;
border:solid 1px #c3c3c3;
}
#panel2
{
padding:50px;
background-color:white;
display:none;
}

#panel3,#flip3
{
padding:5px;
text-align:center;
background-color:cyan;
border:solid 1px #c3c3c3;
}
#panel3
{
padding:50px;
background-color:white;
display:none;
}
#panel4,#flip4
{
padding:5px;
text-align:center;
background-color:cyan;/* #b0ead9 */
}
#panel4
{
padding:50px;
background-color:white;
display:none;
}
</style>
</head>
<body>
<div id="screenSize" class="myscreenSize">
<div id="flip1" align="left">
<label class="mylabel" >1.EMAIL ID</label>
<input type="submit" id="editEmailid"value="Edit Email"  class="mysubmit3" >
</div>

<div id="panel1"><label class="mylabel1"  >Email Address*</label>
<br>
<input type ="text" name="email" class="mytext1" >
<br>
<br>
<input id="show" type ="checkbox" name="registeredUser" >
<label class="mylabel1"  >I have a Flipkart account</label>
<br>
<div id="pwd"><br><label class="mylabel1"  >Password*</label>
	<br>
	<input  type ="text" name="password" class="mytext1">
</div>
<br>
<input id="nextAddressPage"type="submit" value="CONTINUE" align="middle"  class="mysubmit1">
</div>




<div id="flip2">
<label class="mylabel" >2.DELIVERY ADDRESS</label>

<input type="submit" id="editAddress"value="Edit Address"  class="mysubmit3" >
</div>
<div id="panel2"><div>
<form action="addressDetails">
<label class="mylabel2"  >Name</label> 
<input type="text" name="name" class="mytext2"><br><br><br><br>
<label class="mylabel2"  >Pincode</label>
<input type="text" name="pincode" class="mytext2" required><br><br><br><br>
<label class="mylabel2"  >Address</label>
<input type="text" name="address" class="mytext2" required="required"><br><br><br><br>
<label class="mylabel2"  >Landmark</label>
<input type="text" name="landmark" class="mytext2"><br><br><br><br>
<label class="mylabel2"  >Phone</label><input type="text" name="phone" class="mytext2"><br><br><br><br>
</form>
</div>
<input type="submit" id="nextOrderPage"value="SAVE & CONTINUE" align="middle" class="mysubmit2" ></div>



<div id="flip3"><label class="mylabel" >3.ORDER SUMMARY</label>
<input type="submit" id="editOrder"value="Edit Order"  class="mysubmit3" >
</div>
<div id="panel3">

<input type="submit" id="nextPaymentPage"value="CONTINUE" align="middle" class="mysubmit2" >
</div>




<div id="flip4"><label class="mylabel" >4.PAYMENT METHOD</label>

</div>
<div id="panel4">
<input type="submit" id="confirmOrder"value="CONFIRM ORDER" align="middle" class="mysubmit2" >
</div>





</div>
</body>
</html>