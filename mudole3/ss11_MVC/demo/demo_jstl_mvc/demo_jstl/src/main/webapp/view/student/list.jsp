<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1>Trang list student</h1>
<a href="/student?action=create">Them moi</a>
<table class="table table-dark">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Birthday</th>
        <th>Point</th>
        <th>Ranking</th>
        <th>Account</th>
        <th>Email</th>
        <th>Class ID</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.birthday}</td>
            <td>${student.point}</td>
            <c:choose>
                <c:when test="${student.point>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.point>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.point>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>

            <td>${student.account}</td>
            <td>${student.email}</td>
            <td>${student.classId}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
