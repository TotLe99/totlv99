package BtapSlack_5523;

import java.util.Scanner;

public class Bai3_TongSNT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số SNT: ");
        int n = sc.nextInt();
        int count = 0;
        int x = 2;
        int sum = 0;

        while (count < n) {
            if (isPrimeNumber(x)) {
                count++;
                sum += x;
            }
            x++;
        }
        System.out.println("Tổng SNT nhập vào là: " + sum);
    }

    public static boolean isPrimeNumber (int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
