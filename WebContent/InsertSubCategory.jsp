<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="asset/JavaScripts/jquery.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#dropDown").change(function(){
			
			var strUser = $("#dropDown").val();
			$.ajax({
				
				 type: 'POST',
				    url:'fetchSubCategoryId?categoryId='+strUser,
				    success: function(data){
				    	$("#dropDown2").empty();
				    	$.each(data.subCategoryId, function(count,subCategoryId) { 
				    	
				    	$("#dropDown2").append("<option>"+subCategoryId+"</option>");
				    	
				    	});
				    
				
				    }
				
			});
			
		});
	});

</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form method="get" action="insertCategoryRelation">
	
		<h3> Category- ID :: 
			<select id="dropDown" name="id">
					<option> --Select-- </option>
				<s:iterator value="categoryId">
					 <option>  <s:property /> </option> 
				 </s:iterator>
			 </select><br> </h3>
			 
		<h3>	Sub-Category- ID :: 
			<select id="dropDown2" name="id2">
				
			</select>
			 </h3>
			 
			 
		<h3>	 <input type="submit" class="btn btn-primary" value="Submit"/>  </h3>
		
		
	</form>
	</div>
</body>
</html>