<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table,td,th{
	border:1px solid black;
}
table{
	border-collapse:collapse;
	width:100%;
}
th{
	height:50px;
}
<title>Insert title here</title>
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<h2>Category:</h2>
<table>
	<thead>
		<tr>
		<th>No</th>
		<th>Name</th>
		<th>Description</th>
		<th>DELETE</th>
		<th>UPDATE</th>
		
		</tr>
	</thead>
	<tbody>
	<c:forEach var="emp" items="${categoryList }" varStatus="row">
		<tr>
		<td>${row.count }</td>
		<td>${emp.name }</td>
		<td>${emp.description }</td>
		<td><a href="<c:url value='/deleteCategory/${emp.id}'/>">Delete</a></td>
		<td><a href="<c:url value='/updateCategory/${emp.id}'/>">Update</a> </td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>