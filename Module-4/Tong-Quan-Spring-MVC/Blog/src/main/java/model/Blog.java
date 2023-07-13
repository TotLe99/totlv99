package model;

import java.time.LocalDate;

public class Blog {
    private static int countID = 1;
    private int id;
    private String title;
    private String img;
    private LocalDate time = LocalDate.now();
    private String content;

    public Blog() {
        this.id = countID++;
    }

    public Blog(String title, String img, LocalDate time, String content) {
        this.id = countID++;
        this.title = title;
        this.img = img;
        this.time = time;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
