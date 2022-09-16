<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/5/2022
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center >
<h1>Use Management</h1>
    <h2>
        <a href="/products?action=create">Add new Product</a>
        <form action="/products" method="post">
            <label>Search Name: </label>
            <input type="search" name="seaech" size="25">
            <input type="submit" value="Submit">
        </form>
    </h2>
</center>

<div align="center" class="c">
    <h1>Quản lý mặt bằng</h1>

    <table cellpadding="8"  id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Quantity</td>
            <td>Color</td>
            <td>Description</td>
            <td>Category</td>
            <td>Actions</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.color}</td>
                <td>${product.description}</td>

                <c:forEach var="category" items="${categoryList}">
                    <c:if test="${category.id==product.category_id}">
                        <td>${category.name}</td>
                    </c:if>
                </c:forEach>

                <td>
                    <a href="/products?action=edit&id=${product.id}">Edit</a>
                    <a href="/products?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"> </script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script >
    $(document).ready(function () {
    $('#example').DataTable();
    });
</script>
</html>
