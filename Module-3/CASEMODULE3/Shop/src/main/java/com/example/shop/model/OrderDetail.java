package com.example.shop.model;

public class OrderDetail {
    private int id;
    private int order_id;
    private int shoedetail_id;
    private int quantity_buy;

    public OrderDetail(int order_id, int shoedetail_id, int quantity_buy) {
        this.order_id = order_id;
        this.shoedetail_id = shoedetail_id;
        this.quantity_buy = quantity_buy;
    }

    public OrderDetail(int id, int order_id, int shoedetail_id, int quantity_buy) {
        this.id = id;
        this.order_id = order_id;
        this.shoedetail_id = shoedetail_id;
        this.quantity_buy = quantity_buy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getShoedetail_id() {
        return shoedetail_id;
    }

    public void setShoedetail_id(int shoedetail_id) {
        this.shoedetail_id = shoedetail_id;
    }

    public int getQuantity_buy() {
        return quantity_buy;
    }

    public void setQuantity_buy(int quantity_buy) {
        this.quantity_buy = quantity_buy;
    }
}
