<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product </title>
</head>
<body>
<form action="calculator" method="post">
    <label>Sản phẩm: </label>
    <input type="text" name="product"><br><br>
    <label>Giá niêm yết: </label>
    <input type="text" name="price"><br><br>
    <label>Tỷ lệ chiết khấu: </label>
    <input type="text" name="discount"><br><br>
    <input type="submit" id="calculator" value="Result">
</form>
</body>
</html>