package Btap_UseArrayListAndLinkedList.LinkedList;

public class Product {
    private static int count = 0;
    private int id;
    private String name;
    private double price;

    public Product() {
        this.id = ++count;
    }

    public Product(String name, double price) {
        this.id = ++count;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                '}';
    }
}
