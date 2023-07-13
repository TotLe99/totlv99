import Manager.AdministrativeManager;
import Manager.SalesManager;
import Manager.TechnicalManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AdministrativeManager administrativeManager = new AdministrativeManager();
        TechnicalManager technicalManager = new TechnicalManager();
        SalesManager salesManager = new SalesManager();

        int choice, choice2, choice3, choice4;

        while (true) {
            try {
                do {
                    System.out.println("\n---- QUẢN LÝ NHÂN VIÊN CÔNG TY ----");
                    System.out.println("1. Hiển thị");
                    System.out.println("2. Thêm Nhân viên");
                    System.out.println("3. Tính lương");
                    System.out.println("4. Điểm danh");
                    System.out.println("0. Thoát");
                    System.out.print("Lựa chọn: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("\n---- NHÂN VIÊN HÀNH CHÍNH ----");
                            administrativeManager.displayAdministrative();
                            System.out.println("\n---- NHÂN VIÊN KỸ THUẬT ----");
                            technicalManager.displayTechnical();
                            System.out.println("\n---- NHÂN VIÊN KINH DOANH ----");
                            salesManager.displaySales();
                            break;
                        case 2:
                            try {
                                do {
                                    System.out.println("\n---- THÊM NHÂN VIÊN ----");
                                    System.out.println("1. Nhân viên Hành Chính");
                                    System.out.println("2. Nhân viên Kỹ thuật");
                                    System.out.println("3. Nhân viên Kinh doanh");
                                    System.out.println("0. Quay lại");
                                    System.out.print("Lựa chọn: ");
                                    choice2 = Integer.parseInt(sc.nextLine());

                                    switch (choice2) {
                                        case 1:
                                            administrativeManager.addAdministrative();
                                            break;
                                        case 2:
                                            technicalManager.addTechnical();
                                            break;
                                        case 3:
                                            salesManager.addSales();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Vui lòng chọn lại.");
                                    }
                                } while (choice2 != 0);
                            } catch (Exception e) {
                                System.err.println("Vui lòng nhập số");
                            }
                            break;

                        case 3:
                            try {
                                do {
                                    System.out.println("\n---- TÍNH LƯƠNG NHÂN VIÊN ----");
                                    System.out.println("1. Nhân viên Hành Chính");
                                    System.out.println("2. Nhân viên Kỹ thuật");
                                    System.out.println("3. Nhân viên Kinh doanh");
                                    System.out.println("0. Quay lại");
                                    System.out.print("Lựa chọn: ");
                                    choice3 = Integer.parseInt(sc.nextLine());

                                    switch (choice3) {
                                        case 1:
                                            administrativeManager.calculateMonthlySalaryOfAdministrative();
                                            break;
                                        case 2:
                                            technicalManager.calculateMonthlySalaryOfTechnical();
                                            break;
                                        case 3:
                                            salesManager.calculateMonthlySalaryOfSales();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Vui lòng chọn lại.");
                                    }
                                } while (choice3 != 0);

                            } catch (Exception e) {
                                System.err.println("Vui lòng nhập số");
                            }
                            break;

                        case 4:
                            try {
                                do {
                                    System.out.println("\n---- ĐIỂM DANH ----");
                                    System.out.println("1. Nhân viên Hành Chính");
                                    System.out.println("2. Nhân viên Kỹ thuật");
                                    System.out.println("3. Nhân viên Kinh doanh");
                                    System.out.println("0. Quay lại");
                                    System.out.print("Lựa chọn: ");
                                    choice4 = Integer.parseInt(sc.nextLine());

                                    switch (choice4) {
                                        case 1:
                                            administrativeManager.rollUp();
                                            break;
                                        case 2:
                                            technicalManager.rollUp();
                                            break;
                                        case 3:
                                            salesManager.rollUp();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Vui lòng chọn lại.");
                                    }
                                } while (choice4 != 0);
                            } catch (Exception e) {
                                System.err.println("Vui lòng nhập số");
                            }
                            break;

                        case 0:
                            return;
                        default:
                            System.out.println("Vui lòng chọn lại.");
                    }
                } while (choice != 0);
            } catch (Exception e) {
                System.err.println("Vui lòng nhập số.");
            }
        }
    }
}
