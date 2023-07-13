const ROLE_ADMIN = 1;
const ROLE_USER = 2;


class User {
    username;
    password;
    avatar;
    role = ROLE_USER;

    constructor(username, password, avatar) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }
}