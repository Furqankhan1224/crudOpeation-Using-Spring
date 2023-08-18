<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="./base.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">S.NO</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${product }" var="p">
    <tr>
      <th scope="row">TECHONLY${p.id }</th>
      <td>${p.name }</td>
      <td>${p.description }</td>
      <td class="font-weight-bold">&#x20B9; ${p.price }</td>
      <td><a href="delete/${p.id }"><i class="fas fa-trash text-danger" style="font-size: 30px;"></i></a>
      <a href="update/${p.id }"><i class="fas fa-pen-nib text-primary"style="font-size: 30px;" ></i></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
`
<div class="container text-center">
<a href="add-product" class="btn btn-outline-success">Add Product</a>

</div>



</body>
</html>