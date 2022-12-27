<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.hcl.to.User, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table class="table">
		<thead>
			<tr>
				<th scope="col">Username</th>
				<th scope="col">Complete Name</th>
				<th scope="col">Email</th>
				<th scope="col">Delete</th>
				<th scope="col">Update</th>
			</tr>
		</thead>
		<tbody>

			<% 
    List<User> userss = (List<User>)request.getAttribute("allusers"); 
    %>

			<%
    	for(int i = 0; i < userss.size(); i++) {
    %>

			<tr>
				<td><%=userss.get(i).getUsername() %></td>
				<td><%=userss.get(i).getName() %></td>
				<td><%=userss.get(i).getEmail() %></td>
				<td><a href = "/delete/<%=userss.get(i).getUsername() %>">delete</a></td>
				<td><a href = "/updatePage/<%=userss.get(i).getUsername() %>">update</a></td>
			</tr>

			<%} %>

		</tbody>
	</table>

</body>
</html>