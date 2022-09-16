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
<h1>Quản Lý </h1>
    <h2>
        <a href="/quanlys?action=create">Thêm mới</a>
        <form action="/quanlys?action=search" method="get">
            <label>Search Name: </label>
            <input hidden name="action" value="search">
            <input type="search" name="search" size="25">
            <input type="submit" value="Submit">
        </form>
    </h2>
</center>



<div align="center" class="container" style="width: 100%">
    <h1>Danh sách dự án</h1>
    <table cellpadding="8"  id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>

<%--            <td>ID</td>--%>
            <td>Mã mặt bằng</td>
            <td>Diện tích</td>
            <td>Trạng thái</td>
            <td>Tầng</td>
            <td>Loại văn phòng</td>
            <td>Mô tả</td>
            <td>Giá cho thuê</td>
            <td>ngày bắt đầu</td>
            <td>ngày kết thúc</td>
            <td>Sửa xoá</td>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="quanly" items="${quan_lyList}">
            <tr>
<%--                <td>${quanly.id}</td>--%>
                <td>${quanly.ma_mat_bang}</td>
                <td>${quanly.dien_tich}</td>
                <c:forEach var="trangthai" items="${trang_thaiList}">
                    <c:if test="${trangthai.id==quanly.trang_thai_id}">
                        <td>${trangthai.loai_trang_thai}</td>
                    </c:if>
                </c:forEach>
                <td>${quanly.tang}</td>
                <c:forEach var="vanphong" items="${van_phongList}">
                    <c:if test="${vanphong.id==quanly.van_phong_id}">
                        <td>${vanphong.loai_van_phong}</td>
                    </c:if>
                </c:forEach>
                <td>${quanly.mo_ta}</td>
                <td>${quanly.gia_cho_thue}</td>
                <td>${quanly.ngay_bat_dau}</td>
                <td>${quanly.ngay_ket_thuc}</td>
                <td>
                    <a href="/quanlys?action=edit&id=${quanly.id}">Edit</a>
                    <a href="/quanlys?action=delete&id=${quanly.id}">Delete</a>
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
