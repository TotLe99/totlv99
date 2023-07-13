import javax.jws.soap.SOAPBinding;
import javax.xml.namespace.QName;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductManager productManager = new ProductManager();
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    productManager.displayProduct();
                    break;
                case 2:
                    productManager.addProduct();
                    break;
                case 3:
                    productManager.updateProduct();
                    break;
                case 4:
                    productManager.deleteProduct();
                    break;
                case 5:
                    int choice5;
                    do {
                        System.out.println("1. và 2. Hiển thị");
                        System.out.println("3. Quay lại.");
                        System.out.print("Chọn chức năng: ");
                        choice5 = Integer.parseInt(sc.nextLine());
                        switch (choice5) {
                            case 1:
                            case 2:
                                productManager.sortUpProduct();
                                break;
                        }
                    } while (choice5 != 3);
                    break;
                case 6:
                    productManager.searchAllMaxPrice();
                    break;
                case 7:
                    //Đọc file
                    break;
                case 8:
                    //Lưu file
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập lại!");
            }
        } while (choice != 0);
    }
}
