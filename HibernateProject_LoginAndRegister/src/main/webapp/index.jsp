<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	 	<div>
	 		<h1>Register User</h1>
	 	</div>
		<form action="registerUser" method="post">
			<input type="text" placeholder="Enter Your Full Name: " name="userName" required><br>
			<input type="email" placeholder="Enter Your Email: " name="userMail" required> <br>
			<input type="password" placeholder="Enter Password: " name="userPassword" required> <br>
			<input type="submit" value="Register"> 
			<a href="login.jsp">Login</a>
		</form>
	</div>
</body>
</html>