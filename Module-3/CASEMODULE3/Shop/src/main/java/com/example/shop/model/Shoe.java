package com.example.shop.model;

public class Shoe {
    private int id;
    private int image_id;
    private String name;
    private String description;
    private String time;
    private float price;

    public Shoe(int image_id, String name, String description, String time, float price) {
        this.image_id = image_id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.price = price;

    }
    public Shoe(int id, int image_id, String name, String description, String time, float price) {
        this.id = id;
        this.image_id = image_id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
