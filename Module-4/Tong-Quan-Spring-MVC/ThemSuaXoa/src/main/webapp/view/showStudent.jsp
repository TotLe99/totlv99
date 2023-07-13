<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/7/2023
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Info Student</h2>
    <a href="/createStudent" class="btn btn-success">Add</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Image</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${student}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td><img src="${s.img}" height="250" width="300"></td>
            <td><a href="/editStudent?id=${s.id}" class="btn btn-info">Edit</a></td>
            <td><a href="/deleteStudent?id=${s.id}" class="btn btn-danger">Delete</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

