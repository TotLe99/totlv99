package TaoMenu;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Vẽ Tam Giác");
            System.out.println("2. Vẽ Vuông");
            System.out.println("3. Vẽ HCN");
            System.out.println("0. Thoát");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Vẽ TG");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Vẽ vuông");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    break;
                case 3:
                    System.out.println("Vẽ HCN");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Hãy chọn lại!");
            }
        }
    }
}
