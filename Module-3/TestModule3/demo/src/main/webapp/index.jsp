<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <title>Student</title>
</head>
<body>
<div class="container">
    <div class="student-table">
        <table class="table table-hover">
            <tr>
                <th>
                    <a href="/create">
                        <button type="button" class="btn btn-primary">Add</button>
                    </a>
                </th>
                <th>
                    <input type="text" name="search" placeholder="Search">
                    <button type="button" class="btn btn-info">Search</button>
                </th>
            </tr>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>DateOfBirth</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
<%--                <th>Classroom</th>--%>
                <th>Action</th>
                <th></th>
            </tr>

            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.dateOfBirth}</td>
                    <td>${student.email}</td>
                    <td>${student.address}</td>
                    <td>${student.phone}</td>
<%--                    <td>${student.getClasses()}</td>--%>
                    <td>
                        <a href="/edit?id=${student.id}" class="btn btn-success">Edit</a>
                    </td>
                    <td>
                        <a href="/delete?id=${student.id}" class="btn btn-warning">Delete</a>
                    </td>
                </tr>
            </c:forEach></table>
    </div>
</div>
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>