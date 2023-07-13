<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer</title>
    <meta charset="utf-8">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Họ Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>${customer.address}</td>
                <td><img src="${customer.img}" width="500px" height="500px"></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>