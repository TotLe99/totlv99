package com.example.shop.model.view;

public class ViewShoe {
    private int id;
    private String name;
    private float price;
    private String url;

    public ViewShoe() {
    }

    public ViewShoe(int id, String name, float price, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
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
}
