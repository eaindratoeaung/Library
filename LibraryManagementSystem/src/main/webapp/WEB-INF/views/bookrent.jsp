<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table{
	border-collapse:collapse;
}
table,td,th{
	border:1px solid black;
}
<title>Insert title here</title>
</style>
</head>
<body>
<h2>Book Rent:</h2>
<table>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<form:form method="post" action="${pageContext.request.contextPath}/bookrent_list.htm" commandName="bookrent">
<form:hidden path="id"/>
<tr><td>Qty:</td><td> <form:input path="qty" type="text"/></td></tr>
<tr><td>DateTime:</td><td>     <form:input type="date" path="rentdate" /> </td></tr> 
<tr><td>Book:</td> <td><form:select path="bookId">    <form:options items="${bookList}" itemValue="id" itemLabel="name"/>  
</form:select></td></tr>
<tr><td>Student:</td> <td><form:select path="studentId">    <form:options items="${studentList}" itemValue="id" itemLabel="name"/>  
</form:select></td></tr>

<br>

<tr><td> </td><td><input type="submit" value="SaveOrUpdate" /></td></tr>
</form:form>
</table>

</body>
</html>