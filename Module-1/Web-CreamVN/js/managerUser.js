// let users = JSON.parse(localStorage.getItem('users'));
let users = [
    {
        username: "phuocmai",
        email: "phuocmai@gmail.com",
        password: "123456"
    }
];
if (users === null) {
    users = [];
}

function checkUserName(name) {
    for (let i = 0; i < users.length; i++) {
        if (users[i].username === name) {
            return false;
        }
    }
    return true;
}

function checkUser(username, email, password) {
    console.log(username, password)
    for (let i = 0; i < users.length; i++) {
        if ((users[i].username === username || users[i].email === username) && users[i].password === password) {
            return true;
        }
    }
    return false;
}

function Login() {
    let username = document.getElementById('username-login').value;
    let password = document.getElementById('password-login').value;
    if (checkUser(username, username, password)) {
        location.href = 'index.html';
        alert('Đăng nhập thành công!');
    } else {
        alert('Tài khoản không chính xác');
    }
}

function Register() {
    let username = document.getElementById('username-register').value;
    let email = document.getElementById('email-register').value;
    let password = document.getElementById('password-register').value;

    if (username === '' || email === '' || password === '') {
        alert('Vui lòng nhập đủ thông tin');
    } else if (!checkUserName(username)) {
        alert("Trùng tên Đăng Nhập");
    } else {
        let user = new User(username, email, password);
        users.push(user);
        alert("Đăng ký thành công!");
    }

    localStorage.setItem('users', JSON.stringify(users));
}