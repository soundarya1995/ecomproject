<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Header</title>
</head>
<body>
       <c:if test="${username=='Admin'}">
      <li><a href="<c:url value="/Category"/>" id="hom">Manage Category</a></li>
      <li><a href="<c:url value="/Supplier"/>" id="hom">Manage Supplier</a></li>
      <li><a href="<c:url value="/Product"/>" id="hom">Manage Product</a></li>
       <li><a href="<c:url value="/ProductDisplay"/>" id="hom">Product</a></li>
       <c:if test="${empty SuccessMessage}">
        <li><a href="<c:url value="/Register"/>" id="hom">Register</a></li>
        <li><a href="<c:url value="/login"/>" id="hom"> Login</a></li>
        </c:if>
      </c:if>
      <c:if test="${not empty SuccessMessage}">
      <li><a href="<c:url value="/Cart"/>" id="hom">Cart</a></li>
      </c:if>
   <c:if test="${not empty SuccessMessage}">
        <li>Hai ${username}</li>
        <li><a href="<c:url value="/perform_logout"/>" id="hom"> Logout</a></li>
        </c:if>
    
  

<a href="#"> Home</a>
 <a href="Register"> Register</a>
<a href="category"> Category</a>
<a href="supplier"> Supplier</a>
<a href="Product"> Product</a>
<a href="ProductDisplay"> Product Display</a>
<a href="Cart"> Cart</a>
</body>
</html>   