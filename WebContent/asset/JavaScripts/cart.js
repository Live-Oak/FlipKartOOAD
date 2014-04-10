$(document).ready(function(){
	$("#buyNow").click(function(){
		var pId = $("#productId").attr("pid");
		var qty = 1;
		$.ajax({
		    type: 'POST',
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    data : {
		    	productId : pId,
		    	quantity : qty
		    },
		    url:'addProductToCart',
		    success: function(data){
		    	$("#cartButton").click();
		     }});	
	});
	
	
	$("#cartButton").click(function(){
		
		$("#emptyCart").hide();
    	
    	$.ajax({
		    type: 'GET',
		    url:'getProductsFromCart',
		    success: function(data){
		    	if(data.count == 0 || data.count == undefined)
		    		{
		    			$("#emptyCart").show();
		    			$("#continueShoppingBottom").hide();
		    			$("#placeOrder").hide();
		    			$("#totalCost").hide();
		    		}
		    	else
		    		{
		    			$("#productInfo").show();
		    			$("#list").empty();
		    			$("#productCount").html("CART ("+data.count+")");
		    			$("#cartHeader").html("CART ("+data.count+")");
		    			var totalcost = 0;
		    			$.each(data.products, function(count,product) { 
		    				subtotal = 0;
		    				subtotal = Number(product.quantity) * Number(product.price);
		    				totalcost += subtotal;
		    				$("#list").append("<div style='height:100px;border : 1px solid gray;padding:10px'>"+
		    						"<img src='"+product.image+"' height='80px' width='80px' style='float:left' />"+
		    						"<div class='productName'>"+product.productName+"</div>"+
		    						"<div class='qty'>"+product.quantity+"</div>"+
		    						"<div class='price'>"+product.price+"</div>"+
		    						"<div class='subtotal'>"+subtotal+"</div>"+
		    						"<div class='remove'><a style='color:black;'>remove</a></div>"+
		    				"</div>");
		    			});
		    			$("#totalCost").html("Total Cost : "+totalcost);
		    		}
		     }});	
    	
	});
	
	
	
	

});
	
	
	

