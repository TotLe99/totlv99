package com.example.shop.model;

public class ShoeDetail {
    private int id;
    private int shoe_id;
    private int color_id;
    private int size_id;
    private int quantity;

    public ShoeDetail(int shoe_id, int color_id, int size_id, int quantity) {
        this.shoe_id = shoe_id;
        this.color_id = color_id;
        this.size_id = size_id;
        this.quantity = quantity;
    }

    public ShoeDetail(int id, int shoe_id, int color_id, int size_id, int quantity) {
        this.id = id;
        this.shoe_id = shoe_id;
        this.color_id = color_id;
        this.size_id = size_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(int shoe_id) {
        this.shoe_id = shoe_id;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
