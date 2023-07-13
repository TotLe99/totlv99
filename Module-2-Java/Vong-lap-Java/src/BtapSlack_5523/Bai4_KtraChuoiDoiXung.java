package BtapSlack_5523;

import java.util.Scanner;

public class Bai4_KtraChuoiDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }

        if (str.equals(reverseStr)) {
            System.out.println(str + " là chuỗi đối xứng");
        } else {
            System.out.println(str + " không phải chuỗi đối xứng");
        }
    }
}
