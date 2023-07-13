package Btap_VeHinh;

import java.util.Scanner;

public class Hinh {
    public static void main(String[] args) {
        int chon = -1;
        Scanner sc = new Scanner(System.in);

        while (chon !=0) {
            System.out.println("Menu");
            System.out.println("1. Ve HCN");
            System.out.println("2. Vẽ Tam Giác Vuong");
            System.out.println("3. Vẽ Tam Giác Vuong nguoc");
            System.out.println("0. Thoát");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("Ve HCN");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Ve TG Vuong");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Ve TG Vuong nguoc");
                    for (int i = 1; i <= 5; i++) {
                         for (int j = 5 - i; j >= 1; j--) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Hãy chọn lại!");
            }
        }
    }
}