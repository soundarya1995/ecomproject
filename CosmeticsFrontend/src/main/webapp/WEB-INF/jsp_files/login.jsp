
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
</head>
<body>
<form method="post" action="<c:url value="/perform_login"/>">
<%@ include file="Header.jsp"%>
<table>
<tr>
<td>User Name</td>
<td><input name="username"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="LOGIN"></td>
</tr>
</table>
</form>
</body>
</html>