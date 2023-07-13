package Btap_QLyNhanVien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerNVpartime managerNVpartime = new ManagerNVpartime();
        ManagerNVfulltime managerNVfulltime = new ManagerNVfulltime();

        while (true) {
            System.out.println("1. Hiển thị all Nhân Viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Tính Lương của nhân viên");
            System.out.println("4. Xoá nhân viên");
            System.out.println("5. Sửa thông tin");
            System.out.println("6. Tìm kiếm tên NV");
            System.out.println("7. Sắp xếp theo tuổi");
            System.out.println("8. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhân viên Partime");
                    managerNVpartime.showNVpartime();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Nhân viên Fulltime");
                    managerNVfulltime.showNVfulltime();
                    break;
                case 2:
                    System.out.println("1. Nhân viên Partime");
                    System.out.println("2. Nhân viên Fulltime");
                    int choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
                            managerNVpartime.addNVpartime();
                            break;
                        case 2:
                            managerNVfulltime.addNVfulltime();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Nhân viên Partime");
                    System.out.println("2. Nhân viên Fulltime");
                    int choice3 = Integer.parseInt(sc.nextLine());
                    switch (choice3) {
                        case 1:
                            managerNVpartime.tinhLuongNVpartime();
                            break;
                        case 2:
                            managerNVfulltime.tinhLuongNVfulltime();
                            break;
                    }
                    break;
                case 4:
                    //xoá
                    System.out.println("1. Nhân viên Partime");
                    System.out.println("2. Nhân viên Fulltime");
                    int choice4 = Integer.parseInt(sc.nextLine());
                    switch (choice4) {
                        case 1:
                            managerNVpartime.deleteNVpartime();
                            break;
                        case 2:
                            managerNVfulltime.deleteNVfulltime();
                            break;
                    }
                    break;
                case 5:
                    System.out.println("1. Nhân viên Partime");
                    System.out.println("2. Nhân viên Fulltime");
                    int choice5 = Integer.parseInt(sc.nextLine());
                    switch (choice5) {
                        case 1:
                            managerNVpartime.editNVpartime();
                            break;
                        case 2:
                            managerNVfulltime.editNVfulltime();
                            break;
                    }
                    break;
                case 6:
                    System.out.println("1. Nhân viên Partime");
                    System.out.println("2. Nhân viên Fulltime");
                    int choice6 = Integer.parseInt(sc.nextLine());
                    switch (choice6) {
                        case 1:
                            managerNVpartime.searchNVpartime();
                            break;
                        case 2:

                            managerNVfulltime.searchNVfulltime();
                    }
                    break;
                case 7:
                    //Sắp xếp theo tuổi
                    System.out.println("1. Nhân viên Partime");
                    System.out.println("2. Nhân viên Fulltime");
                    int choice7 = Integer.parseInt(sc.nextLine());
                    switch (choice7) {
                        case 1:
                            managerNVpartime.xepTheoSNNVpartime();
                            break;
                        case 2:
                            managerNVfulltime.xepTheoSNNVfulltime();
                    }
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}
