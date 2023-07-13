package com.example.shop.model;

public class Color {
    private int id;
    private String code;

    public Color(String code) {
        this.code = code;
    }

    public Color(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
