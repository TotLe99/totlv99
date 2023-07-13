<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/6/2023
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="editE" method="post">
        <input name="id" value="${employee.id}" hidden="hidden"><br>
        <input name="name" value="${employee.name}"><br>
        <input name="img" value="${employee.img}"><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
