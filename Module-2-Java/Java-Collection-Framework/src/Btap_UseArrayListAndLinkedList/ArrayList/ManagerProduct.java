package Btap_UseArrayListAndLinkedList.ArrayList;

import java.util.*;

public class ManagerProduct {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> products;

    public ManagerProduct() {
        products = new ArrayList<>();
    }

    public void addProduct() {
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap gia:");
        double price = Double.parseDouble(sc.nextLine());

        Product product = new Product(name, price);
        products.add(product);
        System.out.println("\nThem thanh cong!");
    }

    public void editProduct() {
        System.out.print("Nhap ID: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean check = false;
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.print("Nhập tên mới: ");
                String name = sc.nextLine();
                System.out.print("Nhập giá mới: ");
                double price = Double.parseDouble(sc.nextLine());

                product.setName(name);
                product.setPrince(price);
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
            if (product.getId() == id) {
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

    public void searchProduct() {
        System.out.print("Nhập tên: ");
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
                return Double.compare(o1.getPrince(), o2.getPrince());
            }
        });
        System.out.println("Sản phẩm sắp xếp theo Giá:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
