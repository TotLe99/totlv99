package BtapSlack.Bai2_TachKhoangTrang;

import java.util.Scanner;

public class CreateSpaceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập: ");
        String str = sc.nextLine();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                output.append(" ");
            }
            output.append(c);
        }
        System.out.println(output.toString());
    }
}
