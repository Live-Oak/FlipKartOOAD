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
		    		}
		    	else
		    		{
		    			$("#productList").empty().show();
		    			$.each(data.products, function(count,product) { 
		    				$("#productList").append("<div style='border:1px solid;float:left;width:100%;' pid='"+product.prodtctID+
		    					"'><img src='"+product.image+"' height='80px' width='80px' style='float:left' />"+
		    					"<div style='float:left;'>"+product.productName+"</div>"+
		    					"<div style='float:left;'>"+product.quantity+"</div>"+
		    					"<div style='float:left;'>"+product.price+"</div>"+
		    					"<div style='float:left;'><a>remove</a></div>"+
		    					" </div>");
		    			});
		    		}
		     }});	
    	
	});
	
	
	
	

});
	
	
	

