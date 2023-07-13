package KiemTraSNT;

import java.util.Scanner;

class KiemTraSNT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so: ");
        int number = sc.nextInt();

        boolean check = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                check = false;
                break;
            }
        }

        if (number < 2) {
            System.out.println(number + " ko là SNT");
        } else if (check) {
            System.out.println(number + " là SNT");
        } else {
            System.out.println(number + " ko là SNT");
        }
    }
}