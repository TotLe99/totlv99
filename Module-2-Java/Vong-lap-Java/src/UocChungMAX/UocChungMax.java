package UocChungMAX;

import java.util.Scanner;

public class UocChungMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap a: ");
        int a = sc.nextInt();
        System.out.println("Nhap b: ");
        int b = sc.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("Ko co uoc");
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        System.out.println("Uoc chung lon nhat: " + a);
    }
}