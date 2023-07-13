<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form action="converter.jsp" method="post">
    <label>Rate: </label>
    <input type="text" name="rate" value="23000"><br>
    <label>USD: </label>
    <input type="text" name="usd" value="0"><br>
    <button type="submit" id="submid">Converter</button>
</form>
</body>
</html>