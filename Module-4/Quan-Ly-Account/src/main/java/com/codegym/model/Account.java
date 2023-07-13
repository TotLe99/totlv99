package com.codegym.model;

import java.time.LocalDate;

public class Account {
    private static int countID = 1;
    private int id;
    private String user;
    private String password;
    private String avatar;
    private LocalDate birthday;

    public Account() {
        this.id = countID++;
    }

    public Account( String user, String password, String avatar, String birthday) {
        this.id = countID++;
        this.user = user;
        this.password = password;
        this.avatar = avatar;
        this.birthday = LocalDate.parse(birthday);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBirthday() {
        return birthday.toString();
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday);
    }
}
