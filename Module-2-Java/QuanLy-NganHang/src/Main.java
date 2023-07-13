import Manager.LoginManager;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int choice;
    static LoginManager loginManager = new LoginManager();

    public static void main(String[] args) {
        while (true) {
            try {
                do {
                    System.out.println("---- LOGIN ----");
                    System.out.println("1. Đăng nhập");
                    System.out.println("0. Thoát");
                    System.out.print("Lựa chọn: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            loginManager.checkAdminLogin();
                            break;
                        case 0:
                            return;
                        default:
                            System.out.println("Vui lòng nhập lại");
                    }
                } while (choice != 0);
            } catch (Exception e) {
                System.err.println("Nhập số");
            }
        }
    }
}
