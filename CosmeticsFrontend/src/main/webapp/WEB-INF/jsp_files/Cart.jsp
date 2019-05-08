<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Cart</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<h3 align="center">Add Cart</h3>
Hai ${cart.username}
<table>
<tr>
<td>Product Image</td>
<td>Product Name</td>
<td>Product Price</td>
<td>Quantity</td>
<td>Operation</td>
</tr>
<c:forEach items="${listCarts}" var="cart">
<tr>
<form method="post" action="<c:url value="/updatecart/${cart.cartId}"/>">
<td><img src="<c:url value="C:/Users/Soundarya/eclipse-workspace/CosmeticsFrontend/src/main/resources/images/${cart.productId}.jpg"/>" width="75px" height="75px"></td>
<c:if test="${Cart.cartId==cart.cartId}">
${alert}
</c:if>
<td>${cart.productName}</td>
<td>${cart.total}</td>
<td><input name="quantity" id="sel" value="${cart.quantity}"></td>
<td><button type="submit">Check price</button></td>
<td><a href="<c:url value="/deletecart/${cart.cartId}"/>"><span class="glyphicon glyphicon-remove"></span></a></td>
</form>
</tr>
</c:forEach>
<tr>
<td></td>
<td>GrandTotal<td>
<td>${grandtotal}</td>
<td></td>
</tr>
<tr>
<td><a href="<c:url value="/confirmorder"/>" class="btn btn-success">Proceed to Buy</a></td>
</tr>
</table>

</body>
</html>