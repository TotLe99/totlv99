import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        InforVaccination inforVaccination = new InforVaccination();
        int choice;
        while (true) {
            System.out.println("---- QUẢN LÝ TIÊM CHỦNG ----");
            System.out.println("1. Hiển thị Khách Hàng");
            System.out.println("2. Thêm Khách Hàng");
            System.out.println("3. Tiêm Vaccine");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    inforVaccination.displayNameOfCustomer();
                    int choice1;
                    do {
                        System.out.println("---- Thông tin Khách Hàng ----");
                        System.out.println("1. Xem thông tin");
                        System.out.println("2. Quay lai");
                        System.out.print("Lựa chọn: ");
                        choice1 = Integer.parseInt(sc.nextLine());

                        switch (choice1) {
                            case 1:
                                inforVaccination.displayInjectVaccineForCustomer();
                                break;
                        }
                    } while (choice1 != 2);
                    break;
                case 2:
                    inforVaccination.addCustomer();
                    break;
                case 3:
                    inforVaccination.injectVaccineForCustomer();
                    break;
                case 4:
                    System.out.println("---- Kết thúc chương trình ----");
                    return;
                default:
                    System.out.println("Vui lòng nhập lại");
                    break;
            }
        }
    }

}

