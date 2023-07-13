package Btap_UseArrayListAndLinkedList.LinkedList;

import java.util.*;
import java.util.Scanner;

public class ManagerProduct {
    Scanner sc = new Scanner(System.in);
    private LinkedList<Product> products;

    public ManagerProduct() {
        products = new LinkedList<>();
    }

    public void addProduct() {
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá:");
        double price = Double.parseDouble(sc.nextLine());

        Product product = new Product(name, price);
        products.add(product);
        System.out.println("Thêm thành công");
    }

    public void editProduct() {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean check = false;
        for (Product product : products) {
            if (id == product.getId()) {
                System.out.println("Tên mới: ");
                String name = sc.nextLine();
                System.out.println("Giá mới: ");
                double price = Double.parseDouble(sc.nextLine());

                product.setName(name);
                product.setPrice(price);
                check = true;
                System.out.println("Sửa thành công!");
                break;
            }
        }
        if (!check) {
            System.out.println("Không có sản phẩm này!");
        }
    }

    public void deleteProduct() {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean check = false;
        for (Product product : products) {
            if (id == product.getId()) {
                products.remove(product);
                check = true;
                System.out.println("Xoá thành công!");
                break;
            }
        }
        if (!check) {
            System.out.println("Không có sản phẩm này!");
        }
    }

    public void displayProduct() {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void search() {
        System.out.print("Tên sản phẩm: ");
        String name = sc.nextLine();
        boolean check = false;
        for (Product product : products) {
            if (name.equals(product.getName())) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Không có sản phẩm này!");
        }
    }

    public void sortProduct() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        System.out.println("Sản phẩm sắp xếp theo giá:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
