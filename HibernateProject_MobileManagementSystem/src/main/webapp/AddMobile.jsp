<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="addMobile.css">
</head>
<body>
	<div class="container">
		<h1>Add New Mobile</h1>
	<div class="menu">
	<form action="addNewMobile" method="post">
		<input type="text" placeholder="Enter Mobile Model" name="mobileModel" required><br>
		<input type="text" placeholder="Enter Mobile Brand" name="mobileBrand" required><br>
		<input type="text" placeholder="Enter Mobile RAM" name="mobileRam" required><br>
		<input type="text" placeholder="Enter Mobile ROM" name="mobileRom" required><br>
		<input type="number" placeholder="Enter Mobile Price" name="mobilePrice" required><br>
		<input type="submit" value="ADD Mobile">
	</form>
	</div>
	</div>
</body>
</html>