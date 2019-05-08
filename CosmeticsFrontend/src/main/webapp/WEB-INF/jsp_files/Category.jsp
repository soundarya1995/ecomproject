<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Category</title>
</head>
<body>
<%@include file="Header.jsp"%>
<h3 align="center">Add Category</h3>
<form method="post" action="<c:url value="/addCategory"/>">
<table>
<tr>
<td>Category name</td>
<td><input type="text" name="categoryName"/></td>
</tr>
<tr>
<td>Category Description</td>
<td><input type="text" name="categoryDesc"/></td>
</tr>
<tr>
<td colspan="2">
<center><input type="submit" value="ADD"/>
<input type="reset" value="RESET"/></center>
</td>
</tr>
</table>
</form>
<table>
 <tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
       </tr>
	<c:forEach items="${listCategories}" var="category">
		<tr>
			<td>${category.categoryId}</td>
			<td>${category.categoryName}</td>
			<td>${category.categoryDesc}</td>
			<td><a href="<c:url value="/editCategory/${category.categoryId}"/>">EDIT</a>/
				<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">DELETE</a>
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>