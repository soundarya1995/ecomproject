<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<title>Supplier</title>
</head>
<body>
<%@include file="Header.jsp" %>
<h3 align="center">Add Supplier</h3>
<form method="post" action="<c:url value="/addSupplier"/>">
<table>
<tr>
<td>Supplier name</td>
<td><input type="text" name="supplierName"/></td>
</tr>
<tr>
<td>Supplier Address</td>
<td><input type="text" name="supplierAddr"/></td>
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
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Addr</td>
		<td>Operation</td>
       </tr>
	<c:forEach items="${listSuppliers}" var="supplier">
		<tr>
			<td>${supplier.supplierId}</td>
			<td>${supplier.supplierName}</td>
			<td>${supplier.supplierAddr}</td>
			<td><a href="<c:url value="/editSupplier/${supplier.supplierId}"/>">EDIT</a>/
				<a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">DELETE</a>
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>