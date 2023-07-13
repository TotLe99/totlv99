package com.example.shop.model;

public class Order {
    private int id;
    private int user_id;
    private String date;
    private float total_amount;
    private int status_id;

    public Order(int user_id, String date, float total_amount, int status_id) {
        this.user_id = user_id;
        this.date = date;
        this.total_amount = total_amount;
        this.status_id = status_id;
    }

    public Order(int id, int user_id, String date, float total_amount, int status_id) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.total_amount = total_amount;
        this.status_id = status_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
