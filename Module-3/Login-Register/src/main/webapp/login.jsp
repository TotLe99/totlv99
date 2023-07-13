<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="CSS/login.css">
</head>

<body class="container-juice">
<div class="wrapper">
    <span class="icon-close"><i class='bx bx-x'></i></span>

    <div class="form-box login">
        <h2>Tài Khoản</h2>
        <form action="login" method="post">
            <div class="input-box">
                <span class="icon-login"><i class='bx bxs-envelope'></i></span>
                <input name="user" dirname="" id="username-login" type="text" required>
                <label>Tên đăng nhập/Email</label>
            </div>
            <div class="input-box">
                <span class="icon-login"><i class='bx bxs-lock-alt'></i></span>
                <input name="password" id="password-login" type="password" required>
                <label>Mật khẩu</label>
            </div>
            <div class="remember-forgot">
                <label><input type="checkbox">Lưu tài khoản</label>
                <a href="#">Quên mật khẩu?</a>
            </div>
            <div>
                <button onclick="Login()" type="submit" class="btn-login">Đăng Nhập</button>
            </div>
            <div class="login-register">
                <p>Bạn chưa có tài khoản? <a href="#" class="register-link">Đăng ký</a></p>
            </div>
        </form>
    </div>

    <div class="form-box register">
        <h2>Tạo Tài Khoản Mới</h2>
        <form action="register" method="post">
            <div class="input-box">
                <span class="icon-login"><i class='bx bxs-user-plus'></i></span>
                <input name="user" id="username-register" type="text" required>
                <label>Tên tài khoản</label>
            </div>
            <div class="input-box">
                <span class="icon-login"><i class='bx bxs-envelope'></i></span>
                <input name="email" id="email-register" type="email" required>
                <label>Email</label>
            </div>
            <div class="input-box">
                <span class="icon-login"><i class='bx bxs-lock-alt'></i></span>
                <input name="password" id="password-register" type="password" required>
                <label>Mật khẩu</label>
            </div>
            <div class="remember-forgot">
                <label><input type="checkbox">Tôi đồng ý với các Điều khoản & Điều kiện</label>
            </div>
            <div>
                <button type="submit" class="btn-login" onclick="Register()">Đăng Ký</button>
            </div>
            <div class="login-register">
                <p>Bạn đã có tài khoản? <a href="#" class="login-link">Đăng nhập</a></p>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script src="JS/js.js"></script>