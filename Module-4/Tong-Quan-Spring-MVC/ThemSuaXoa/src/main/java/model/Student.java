package model;

public class Student {
    private static int countID = 1;
    private int id;
    private String name;
    private String img;

    public Student() {
        this.id = countID++;
    }

    public Student(String name, String img) {
        this.id = countID++;
        this.name = name;
        this.img = img;
    }

    public static int getCountID() {
        return countID;
    }

    public static void setCountID(int countID) {
        Student.countID = countID;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
