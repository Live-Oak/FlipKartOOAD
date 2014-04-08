<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
   
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compare Products</title>
</head>
<body>
<strong>Compare Products</strong>
	<div class="container">
		<div class="col-md-1 "></div>
		<div class="col-md-2 ">
			<div class="background">
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			</div>
		</div>

<div class="col-md-8 background">
	<%@ page import="edu.iiitb.model.*" %>
		<s:iterator value="productinfo">
				<div class="col-md-3">
						<div class="border">
								<br>
								<center>
										<img src="<s:property value="image"/>" alt="<s:property value="productID"/>" height="140px" width="auto" >
										<br><br><br>
									
								<div class="giveMeEllipsis">
										<font size="4" color="black"><s:property value="productName"/></font><br>
								</div>
								<hr>
									<font size="5px" color="#76553B">
										Rs. <s:property value="price"/><br>
									</font>
								<hr>
								This item has manufacturer warranty of <s:property value="warranty"/> years.<br>
								<hr>
						
								<br><br><br>
							</center>
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
												<center>
													<strong>Add to compare</strong>
													<br><br><br><br><br><br><br><br><br>
														<div>
															<select>
															  <option value="<s:property value="productName"/>"><s:property value="productName"/></option>
															  <option value="saab">Saab</option>
															  <option value="mercedes">Mercedes</option>
															  <option value="audi">Audi</option>
															</select>
															<s:select label="Choose products to compare"
														        headerKey="-1" headerValue="Select Product"
														        list="categoryproducts"
														        name="yourCity"
														        value="defaultCity" />															 	
														</div>					
													<br><br><br><br><br><br><br><br><br><br>								
												</center>
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

															     <select>
															     	<s:iterator value="categoryproducts">
																  		<option value="<s:property/>"><s:property/></option>
																  	</s:iterator>
																</select>   
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
														<div>
														<br><br><br><br><br><br><br>
															<select>
															  <option value="volvo">Volvo</option>
															  <option value="saab">Saab</option>
															  <option value="mercedes">Mercedes</option>
															  <option value="audi">Audi</option>
															</select> 	
														<br><br><br><br><br><br><br>	
														</div>
													</center>
												</div>
												</div>	
											<%}%>
										
			</div>
	<div class="col-md-1 "></div>
		
</div>

</body>
</html>



