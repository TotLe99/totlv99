<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <meta charset="UTF-8">

</head>
<body>
<h1>Calculator</h1>
<form action="calculator" method="post">
    <label for="num1">Number 1:</label>
    <input type="number" id="num1" name="num1"><br>
    <label for="num2">Number 2:</label>
    <input type="number" id="num2" name="num2"><br>
    <label for="operator">Operator:</label>
    <select id="operator" name="operator">
        <option value="add">+</option>
        <option value="subtract">-</option>
        <option value="multiply">*</option>
        <option value="divide">/</option>
    </select><br>
    <input type="submit" value="Calculate">
</form>
</body>
</html>