package Btap_20SNT;

import java.util.Scanner;

public class HienThi20SNT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong SNT ");
        int number = sc.nextInt();
        int count = 0;
        int n = 2;
        while (count < number) {
            if (isPrimeNumber(n)) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
