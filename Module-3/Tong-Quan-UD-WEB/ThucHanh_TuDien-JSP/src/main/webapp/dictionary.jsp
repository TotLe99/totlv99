<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/6/2023
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
  Map<String, String> dic = new HashMap<>();
%>

<%
  dic.put("book", "quyen sach");
  dic.put("hello", "xin chao");

  String search = request.getParameter("search");
  String result = dic.get(search);
  PrintWriter writer = response.getWriter();
  if (result != null) {
    writer.println("Word: " + search);
    writer.println("<br>Result: " + result);
  } else {
    writer.println("Not found");
  }
%>
</body>
</html>
