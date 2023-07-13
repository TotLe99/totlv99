package Btap_UseArrayListAndLinkedList.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerProduct managerProduct = new ManagerProduct();
        int choice;
        do {
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xoá");
            System.out.println("4. Hiển thị");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Sắp xếp theo giá");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    managerProduct.addProduct();
                    break;
                case 2:
                    managerProduct.editProduct();
                    break;
                case 3:
                    managerProduct.deleteProduct();
                    break;
                case 4:
                    managerProduct.displayProduct();
                    break;
                case 5:
                    managerProduct.search();
                    break;
                case 6:
                    managerProduct.sortProduct();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhp lại!");
            }
        } while (choice != 0);

    }
}
