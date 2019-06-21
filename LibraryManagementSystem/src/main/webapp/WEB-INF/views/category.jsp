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
<h2>Please Type Book Category:</h2>
<table>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<h4>Please type your name!</h4>
<form:form method="post" action="${pageContext.request.contextPath}/create_category.htm" commandName="category">
<form:hidden path="id"/>
<tr><td>Name: </td><td><form:input path="name" type="text"/></td></tr>
<tr><td>Description:</td><td> <form:input path="description" type="text"/></td></tr>
<tr><td></td><td><input type="submit" value="Save" /></td></tr>
</form:form>
</table>
</body>
</html>