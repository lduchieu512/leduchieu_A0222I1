<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/5/2022
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<center>
<h1>Quản lý mặt bằng</h1>
<h2><a href="/quanlys?action=quanlys">Danh sách mặt bằng</a></h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption> Thêm mới</caption>
            <tr>
                <th>Mã mặt bằng: </th>
                <td>
                    <input type="text" name="maMB" id="maMB" size="50">
                </td>
            </tr>
            <tr>
                <th>Diện Tích: </th>
                <td>
                    <input type="number" name="dienTich" id="dienTich" size="50">
                </td>
            </tr>
            <tr>
                <th>Trạng thái: </th>
                <td>
                    <select name="trangThai">
                        <c:forEach var="trangThai"  items="${trang_thaiList}">
                            <option value="${trangThai.id}">${trangThai.loai_trang_thai}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Tầng : </th>
                <td>
                    <input type="number" name="tang" id="tang" size="50">
                </td>
            </tr>
            <tr>
                <th>Loại Văn Phòng : </th>
                <td>
                    <select name="vanPhong">
                        <c:forEach var="vanPhong"  items="${van_phongList}">
                            <option value="${vanPhong.id}">${vanPhong.loai_van_phong}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Mô tả</th>
                <td>
                    <input type="text" name="moTa" id="moTa" size="50">
                </td>
            </tr>
            <tr>
                <th>Giá cho thuê</th>
                <td>
                    <input type="number" name="giaChoThue" id="giaChoThue" size="50">
                </td>
            </tr>
            <tr>
                <th>Ngày bắt đầu</th>
                <td>
                    <input type="date" name="ngayBatDau" id="ngayBatDau" size="50">
                </td>
            </tr>
            <tr>
                <th>Ngày kết thúc</th>
                <td>
                    <input type="date" name="ngayKetThuc" id="ngayKetThuc" size="50">
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
