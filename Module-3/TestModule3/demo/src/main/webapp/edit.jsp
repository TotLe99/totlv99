<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/7/2023
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>edit</title>
</head>
<body>
<form action="/edit" method="post">
    <label></label><br>
    <input name="id" value="${student.id}" hidden="hidden"><br>
    <label>Name</label><br>
    <input name="name" value="${student.name}"><br>
    <label>Date Of Birth</label><br>
    <input name="dateofbirth" value="${student.dateOfBirth}"><br>
    <label>Email</label><br>
    <input name="email" value="${student.email}"><br>
    <label>Address</label><br>
    <input name="address" value="${student.address}"><br>
    <label>Phone</label><br>
    <input name="phone" value="${student.phone}"><br>
<%--    <label>Class</label><br>--%>
<%--    <select class="form-control" id="sel1">--%>
<%--        <option value="${student.getClasses()}">C03</option>--%>
<%--        <option value="${student.getClasses()}">C04</option>--%>
<%--    </select>--%>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
