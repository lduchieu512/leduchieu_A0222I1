<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/7/2022
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2><a href="/products?action=products">List All Product</a></h2>
</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption> Edit Product </caption>
            <c:if test="${product!= null}">
                <input type="hidden" name="id" value="${product.getId()}" />
            </c:if>
            <tr>
                <th>Product name</th>
                <td>
                    <input type="text" name="name" id="name" size="50" value="${product.getName()}">
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="number" name="price" id="price" size="50" value="${product.getPrice()}">
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td><input type="number" name="quantity" id="quantity" size="50" value="${product.getQuantity()}"></td>

            </tr>
            <tr>
                <th>Color</th>
                <td>
                    <input type="text" name="color" id="color" size="50"value="${product.getColor()}">
                </td>
            </tr>
            <tr>
                <th>Description</th>
                <td>
                    <input type="text" name="description" id="description" size="50" value="${product.getDescription()}">
                </td>
            <tr>
                <th>Category</th>
                <td>
                    <%--                    <input type="text" name="category" id="category" size="50">--%>
                    <select name="category">
                        <c:forEach var="category"  items="${category}">
                            <option value="${category.getId()}">${category.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
