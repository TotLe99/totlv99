package com.example.shop.model.view;


public class ViewShoeDetail {
    private int id;
    private String name;
    private float price;
    private String url;
    private String code;
    private int size;
    private int quantity_buy;

    public ViewShoeDetail() {
    }

    public ViewShoeDetail(int id, String name, float price, String url, String code, int size, int quantity_buy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.code = code;
        this.size = size;
        this.quantity_buy = quantity_buy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity_buy() {
        return quantity_buy;
    }

    public void setQuantity_buy(int quantity_buy) {
        this.quantity_buy = quantity_buy;
    }
}
