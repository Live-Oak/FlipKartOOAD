<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
	.welcome {
		background-color:#DDFFDD;
		border:1px solid #009900;
		width:220px;
	}
	.welcome li{ 
		list-style: none; 
	}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<s:if test="hasActionMessages()">
		<div class="welcome">
      		<s:actionmessage/>
  		 </div>
	
	</s:if>
	<br><br>
		<img src ="asset/Images/admin.jpg">
</center>
</body>
</html>