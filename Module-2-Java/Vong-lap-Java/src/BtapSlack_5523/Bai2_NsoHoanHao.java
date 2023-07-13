package BtapSlack_5523;

import java.util.Scanner;

public class Bai2_NsoHoanHao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số Số Hoàn Hảo: ");
        int n = sc.nextInt();
        int count = 0;
        int perfectNumber = 1;
        while (count < n) {
            if (isPerfectNumber(perfectNumber)) {
                System.out.print(perfectNumber + " ");
                count++;
            }
            perfectNumber++;
        }
    }

    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}
