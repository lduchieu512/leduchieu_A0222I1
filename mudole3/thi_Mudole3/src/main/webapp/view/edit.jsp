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
    <h1>Quản lý mặt bằng</h1>
    <h2><a href="/quanlys">Danh sách mặt bằng</a></h2>
</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption> Edit Mặt bằng </caption>
            <c:if test="${quanlys!= null}">
                <input type="hidden" name="id" value="${quanlys.id}" />
            </c:if>
            <tr>
                <th>Tên mặt bằng</th>
                <td>
                    <input type="text" name="maMB" id="maMB" size="50" value="${quanlys.getMa_mat_bang()}">
                </td>
            </tr>
            <tr>
                <th>Diện tích </th>
                <td>
                    <input type="number" name="dienTich" id="dienTich" size="50" value="${quanlys.getDien_tich()}">
                </td>
            </tr>
            <tr>
                <th>Trạng thái</th>
                <td>
                    <select name="trangThai">
                        <c:forEach var="trangthai"  items="${trangThai}">
                            <option value="${trangthai.id}">${trangthai.loai_trang_thai}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Tầng</th>
                <td>
                    <input type="number" name="tang" id="tang" size="50"value="${quanlys.getTang()}">
                </td>
            </tr>
            <tr>
                <th>Văn phòng</th>
                <td>
                    <select name="vanPhong">
                        <c:forEach var="vanphong"  items="${vanPhong}">
                            <option value="${vanphong.id}">${vanphong.loai_van_phong}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Mô tả</th>
                <td>
                    <input type="number" name="moTa" id="moTa" size="50" value="${quanlys.getMo_ta()}">
                </td>
            </tr>
            <tr>
                <th>Giá cho thuê</th>
                <td>
                    <input type="number" name="giaChoThue" id="giaChoThue" size="50" value="${quanlys.getGia_cho_thue()}">
                </td>
            </tr>
            <tr>
                <th>Ngày bắt đầu</th>
                <td>
                    <input type="text" name="ngayBatDau" id="ngayBatDau" size="50" value="${quanlys.getNgay_bat_dau()}">
                </td>
            </tr>
            <tr>
                <th>Ngày kết thúc</th>
                <td>
                    <input type="text" name="ngayKetThuc" id="ngayKetThuc" size="50" value="${quanlys.getNgay_ket_thuc()}">
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
