package Object;

import java.io.Serializable;
import java.util.*;

public class Employee implements Serializable {
    private String id;
    private String name;
    private int age;
    private double salary;
    private int workday = 0;

    public Employee() {
    }

    public Employee(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Employee(String id, String name, int age, double salary, int workday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workday = workday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkday() {
        return workday;
    }

    public void setWorkday(int workday) {
        this.workday = workday;
    }

    @Override
    public String toString() {
        return "Mã '" + id +
                "' | Tên '" + name + '\'' +
                "| Tuổi '" + age +
                "' | Ngày Làm '" + workday +
                '\'';
    }
}
