<%@page import="javax.persistence.metamodel.SetAttribute"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.jsp.ads.entity.Mobile"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="displayAllMobile.css">

</head>
<body>
	
	
	<div>
		<table>
			<thead>
				<tr>
					<th>Mobile Id</th>
					<th>Model</th>
					<th>Brand</th>
					<th>RAM</th>
					<th>ROM</th>
					<th>Price</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			
			<tbody>
				<% Iterator<Mobile> it = (Iterator<Mobile>)request.getAttribute("mobileList");
				while(it.hasNext()) {
				 Mobile m = it.next();%>
				<tr>
					<td><%= m.getMobileId() %></td>
					<td><%= m.getMobileModel() %></td>
					<td><%= m.getMobileBrand() %></td>
					<td><%= m.getMobileRam() %></td>
					<td><%= m.getMobileRom() %></td>
					<td><%= m.getMobilePrice() %></td>
					<td><a href="updateMobile?mobileId=<%=m.getMobileId()%>">UPDATE</a></td>
					<td><a href="deleteMobile?mobileId=<%=m.getMobileId()%>">DELETE</a></td>
				</tr>
				<% }%>
			</tbody>
		</table>
	</div>
</body>
</html>