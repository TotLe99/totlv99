package Btap_UseArrayListAndLinkedList.ArrayList;

import java.math.BigDecimal;

public class Product {
    private static int count = 0;
    private int id;
    private String name;
    private double prince;

    public Product() {
        this.id = ++count;
    }

    public Product(String name, double prince) {
        this.id = ++count;
        this.name = name;
        this.prince = prince;
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

    public double getPrince() {
        return prince;
    }

    public void setPrince(double prince) {
        this.prince = prince;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", prince = " + prince +
                '}';
    }
}
