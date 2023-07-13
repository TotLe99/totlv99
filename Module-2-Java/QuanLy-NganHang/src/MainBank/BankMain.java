package MainBank;

import Manager.MBBankManager;

import java.util.Scanner;

public class BankMain {

    static Scanner sc = new Scanner(System.in);

    MBBankManager mbBankManager = new MBBankManager();

    static int choice, choice5, choice51;

    public BankMain() {
    }

    public void toMainBank() {
        while (true) {
            try {
                do {
                    System.out.println("\n----- QUẢN LÝ TÀI KHOẢN KHÁCH NGÂN HÀNG -----");
                    System.out.println("1. Nạp tiền");
                    System.out.println("2. Rút tiền");
                    System.out.println("3. Thông tin các tài khoản");
                    System.out.println("4. Chuyển khoản");
                    System.out.println("5. Thanh toán hoá đơn");
                    System.out.println("6. Thêm tài khoản");
                    System.out.println("7. Sửa thông tin");
                    System.out.println("8. Xoá tài khoản");
                    System.out.println("0. Đăng xuất");
                    System.out.print("Lựa chọn: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            mbBankManager.rechargeMoney();
                            break;
                        case 2:
                            mbBankManager.takeMoney();
                            break;
                        case 3:
                            mbBankManager.displayAccount();
                            break;
                        case 4:
                            mbBankManager.sendMoney();
                            break;
                        case 5:
                            while (true) {
                                try {
                                    do {
                                        System.out.println("\n---- HOÁ ĐƠN ----");
                                        System.out.println("1. Hoá đơn Điện");
                                        System.out.println("0. Quay lại");
                                        System.out.print("Lựa chọn: ");
                                        choice5 = Integer.parseInt(sc.nextLine());
                                        switch (choice5) {
                                            case 1:
                                                try {
                                                    do {
                                                        System.out.println("\n---- ĐIỆN ----");
                                                        System.out.println("1. Thông tin");
                                                        System.out.println("2. Tiếp nhận hoá đơn");
                                                        System.out.println("3. Thanh toán hoá đơn");
                                                        System.out.println("4. Xoá hoá đơn");
                                                        System.out.println("0. Quay lại");
                                                        System.out.print("Lựa chọn: ");
                                                        choice51 = Integer.parseInt(sc.nextLine());
                                                        switch (choice51) {
                                                            case 1:
                                                                mbBankManager.displayElectricityBill();
                                                                break;
                                                            case 2:
                                                                mbBankManager.receiveElectricityBill();
                                                                break;
                                                            case 3:
                                                                mbBankManager.payElectricityBill2();
                                                                break;
                                                            case 4:
                                                                mbBankManager.deleteElectricityBill();
                                                                break;
                                                        }
                                                    } while (choice51 != 0);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                    System.err.println("Vui lòng nhập số");
                                                }
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Vui lòng nhập lại");
                                                break;
                                        }
                                    } while (choice5 != 0);
                                } catch (Exception e) {
                                    System.err.println("Vui lòng nhập số");
                                }
                                break;
                            }
                            break;
                        case 6:
                            mbBankManager.addAccount();
                            break;
                        case 7:
                            mbBankManager.editAccount();
                            break;
                        case 8:
                            mbBankManager.deleteAccount();
                            break;
                        case 0:
                            return;
                        default:
                            System.out.println("Vui lòng nhập lại.");
                            break;
                    }
                } while (choice != 0);
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số.");
            }
        }
    }
}
