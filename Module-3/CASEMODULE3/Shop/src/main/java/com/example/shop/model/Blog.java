package com.example.shop.model;

public class Blog {
    private int id;
    private int image_id;
    private String title;
    private String content;

    public Blog(int image_id, String title, String content) {
        this.image_id = image_id;
        this.title = title;
        this.content = content;
    }

    public Blog(int id, int image_id, String title, String content) {
        this.id = id;
        this.image_id = image_id;
        this.title = title;
        this.content = content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
