<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.manager.EmployeeManager" %>
<%@page import="com.example.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h2>LIST EMPLOYEE</h2>
    <a href="/createE" class="btn btn-success">Create Employee</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Image</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${employee}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td><img src="${emp.img}" width="200px" height="200px"></td>
                <td><a href="/editE?id=${emp.id}" class="btn btn-primary">Edit</a></td>
                <td><a href="/deleteE?id=${emp.id}" class="btn btn-dark">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>