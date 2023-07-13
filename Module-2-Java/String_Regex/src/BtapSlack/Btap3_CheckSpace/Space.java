package BtapSlack.Btap3_CheckSpace;

import java.util.Scanner;

public class Space {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập: ");
        String str = sc.nextLine();

        boolean isValid = str.matches("^(.*[A-Z]{1,}.*)* (.*[A-Z]{1,}.*)*$");
        if (isValid) {
            System.out.println("'" + str + "' Over Hợp");
        } else {
            System.out.println("'" + str + "' Nót Over Hợp");
        }
    }
}
