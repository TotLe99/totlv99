<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/7/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form action="/create" method="post">
 <label>ID</label><br>
 <input type="text" name="id"><br>
 <label>Name</label><br>
  <input type="text" name="name"><br>
  <label>Email</label><br>
  <input type="text" name="email"><br>
  <label>Date Of Birth</label><br>
  <input type="text" name="dateofbirth"><br>
  <label>Address</label><br>
  <input type="text" name="address"><br>
  <label>Phone</label><br>
  <input type="text" name="phone"><br>
  <label>Class</label><br>
  <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
