<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<title>UpdateProductPage</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<h3 align="center">Update Product</h3>
<form  method="post" action="<c:url value="/updateProduct"/>"enctype="multipart/form-data">
<table>
<tr>
<td>Select Category:</td>
<td><select name="categoryId">
<option value="" disabled selected>Select</option>
<c:forEach items="${listCategories}" var="category">
<option value="${category.categoryId}">${category.categoryName}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Select Supplier:</td>
<td><select  name="supplierId">
<option value="" disabled selected>Select</option>
<c:forEach items="${listSuppliers}" var="supplier">
<option value="${supplier.supplierId}">${supplier.supplierName}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Product ID</td>
<td><input type="text" name="productId" value="${product.productId}"></td>
</tr>
<tr>
<td>Product name</td>
<td><input type="text" name="productName" value="${product.productName}" /></td>
</tr>
<tr>
<td>Product Description</td>
<td><input type="text" name="productDesc" value="${product.productDesc}"/></td>
</tr>
<tr>
<td>Product Price</td>
<td><input type="text" name="price" value="${product.price}"/></td>
</tr>
<tr>
<td>Product Stock</td>
<td><input type="text" name="stock" value="${product.stock}"/></td>
</tr>
<tr>
<td>Product Image</td>
<td><input type="file" name="image" value="${product.productId}.jpg"/>" width="75px" height="75px"></td>
</tr>
<tr>
<td>Change Image</td>
<td><input type="file"accept="/resources/images/" name="pimage"/></td>
</tr>
<tr>
<td colspan="2">
<center>
<input type="submit" value="UPDATE"/>
<input type="reset" value="RESET"/></center>
</td>
</tr>
</table>
</form>
</body>
</html>