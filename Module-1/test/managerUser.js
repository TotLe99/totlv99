//Lấy dữ liệu từ localStorage;
let users = JSON.parse(localStorage.getItem("users"));
if (users === null) {
    users = [];
}


function register() {
    let username = document.getElementById("username2").value;
    let password = document.getElementById("password2").value;
    let avatar = document.getElementById("avatar").value;
    if (username === '' || password === '' || avatar === '') {
        alert("cần nhập đủ thông tin");
    } else if (!checkUserName(username)) {
        alert("Trùng username");
    } else {
        let user = new User(username, password, avatar);
        users.push(user);
        alert("đăng ký thành công");

        // Đẩy dữ liệu lên localStorage
        localStorage.setItem("users", JSON.stringify(users));

        location.href = 'Login.html';
    }
}


function checkUserName(name) {
    for (let i = 0; i < users.length; i++) {
        if (users[i].username === name) {
            return false;
        }
    }
    return true;
}

function checkUser(username, password) {
    for (let i = 0; i < users.length; i++) {
        if (users[i].username === username && users[i].password === password) {
            return true;
        }
    }
    return false;
}


function login() {
    users = JSON.parse(localStorage.getItem("users"));
    let username = document.getElementById("username1").value;
    let password = document.getElementById("password1").value;
    if (checkUser(username, password)) {
        location.href = 'Admin.html';
    } else {
        alert("Tài khoản không chính xác");
    }
}