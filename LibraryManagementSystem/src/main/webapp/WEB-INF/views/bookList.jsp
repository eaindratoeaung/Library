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

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<h2>Book Information!</h2>
<form><table boder=1>
	<thead>
		<tr>
		<th>No</th>
		<th>Name</th>
		<th>Author</th>
		<th>Isbn</th>
		<th>DELETE</th>
		<th>UPDATE</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="emp" items="${bookList }" varStatus="index">
		<tr>
		<td>${index.count }</td>
		<td>${emp.name }</td>
		<td>${emp.author }</td>
		<td>${emp.isbn }</td>
		<td><a href="<c:url value='/deleteBook/${emp.id}'/>">Delete</a></td>
		<td><a href="<c:url value='/updateBook/${emp.id}'/>">Update</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</form>
</body>
</html>