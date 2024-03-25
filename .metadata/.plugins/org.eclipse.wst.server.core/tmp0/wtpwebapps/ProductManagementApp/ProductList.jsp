<%@page import="com.sathya.servlet.ProductDao" 
import="java.util.Base64"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Product List</title>
<!-- BootStrap CDN Link to get the support of BootStrap -->
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<h1 class="text-success text-center">List of Available Products</h1>
<a href="add-product.html" class="btn btn-success">Save Product</a>
<br>
<input type="text" placeholder="Search">
<div>
<c:if test="${saveResult==1}">
<h2 class="text-success text-center">Data inserted Successfully</h2>
</c:if>
</div>
<div>
<c:if test="${deleteResult==1}">
<h2 class="text-danger text-center">Data deleted Successfully</h2>
</c:if>
</div>
<div>
<c:if test="${deleteResult==0}">
<h2 class="text-danger text-center">Data deletion fail</h2>
</c:if>
</div>

<div>
<c:if test="${updateResult==1}">
<h2 class="text-success text-center">Data Updated Successfully</h2>
</c:if>
</div>
<div>
<c:if test="${updateResult==0}">
<h2 class="text-danger text-center">Data Updation fail</h2>
</c:if>
</div>


<table class="table table-bordered table-stripped">
<thead class="thead-dark">
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Product Cost</th>
<th>Brand</th>
<th>Made In</th>
<th>Manufactured Date</th>
<th>Expiry Date</th>
<th>Image</th>
<th>Audio</th>
<th>Video</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
<tr>
<td>${product.proId}</td>
<td>${product.proName}</td>
<td>${product.proPrice}</td>
<td>${product.proBrand}</td>
<td>${product.proMadeIn}</td>
<td>${product.proMfgDate}</td>
<td>${product.proExpDate}</td>
<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="product Image" style="max-width:100px; max-height:100px;">
</td>
<td><audio controls style="width: 200px;"><source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"></audio></td>

<td><video width="160" height="120" controls><source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}"></video></td>
<td>
<a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">Delete</a>
<a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId}">Edit</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>