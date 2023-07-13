package BtapSlack_5523;

import java.util.Scanner;

public class Bai1_NsoNT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vị trí SNT: ");
        int n = sc.nextInt();
        int count = 0;
        int x = 2;
        while (count < n) {
            if (isPrimeNumber(x)) {
                System.out.println(x + " ");
                count++;
            }
            x++;
        }
        System.out.println("SNT vị trí thứ " + n + " là: " + (x-1));
    }

    public static boolean isPrimeNumber(int x) {
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