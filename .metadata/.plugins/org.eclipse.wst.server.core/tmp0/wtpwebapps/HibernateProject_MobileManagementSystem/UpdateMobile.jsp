<%@page import="com.jsp.ads.entity.Mobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="updateMobile.css">

</head>
<body>
	<% Mobile mobile = (Mobile)request.getAttribute("mobile"); %>
	
	<div class="container">
		
		<h1>Update Mobile Details</h1>
		<div class="menu">
	<form action="saveUpdateMobile" method="post">
		<input type="text" value="<%= mobile.getMobileId() %>" name="mobileId"  readonly="true"><br>
		<input type="text" value="<%= mobile.getMobileModel() %>" name="mobileModel" ><br>
		<input type="text" value="<%= mobile.getMobileBrand()%>" name="mobileBrand" ><br>
		<input type="text" value="<%= mobile.getMobileRam()%>" name="mobileRam" ><br>
		<input type="text" value="<%= mobile.getMobileRom() %>" name="mobileRom" ><br>
		<input type="number" value="<%= mobile.getMobilePrice()%>" name="mobilePrice" ><br>
		<input type="submit" value="Update">
	</form>
	</div>
	</div>
</body>
</html>