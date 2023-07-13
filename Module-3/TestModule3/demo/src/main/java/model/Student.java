package model;

import java.time.LocalDate;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String address;
    private String phone;
    private List<Class> classes;

    public Student(int id, String name, LocalDate dateOfBirth, String email, String address, String phone) {
    }

    public Student(int id, String name, String dateOfBirth, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Student(int id, String name, String dateOfBirth, String email, String address, String phone, List<Class> classes) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classes = classes;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
