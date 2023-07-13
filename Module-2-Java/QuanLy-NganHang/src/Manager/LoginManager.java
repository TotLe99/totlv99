package Manager;

import Login.AdminLogin;
import MainBank.BankMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginManager {
    static Scanner sc = new Scanner(System.in);
    AdminLogin login = new AdminLogin();
    BankMain bankMain = new BankMain();
    List<AdminLogin> logins = new ArrayList<>();

    public void addAdminLogin() {
        login = new AdminLogin("admin", "admin");
        logins.add(login);
    }

    public void checkAdminLogin() {
        addAdminLogin();
        System.out.print("User: ");
        String user = sc.nextLine();
        for (AdminLogin adminLogin : logins) {
            if (user.equals(adminLogin.getUser())) {
                System.out.print("Password: ");
                String password = sc.nextLine();
                if (password.equals(adminLogin.getPassword())) {
                    System.out.println("Đăng nhập thành công!");
                    bankMain.toMainBank();
                    break;
                } else {
                    System.out.println("Sai mật khẩu");
                }
            } else {
                System.out.println("Tài khoản sai");
                break;
            }
        }
    }
}
