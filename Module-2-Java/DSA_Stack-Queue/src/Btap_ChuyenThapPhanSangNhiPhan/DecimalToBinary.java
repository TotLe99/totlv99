package Btap_ChuyenThapPhanSangNhiPhan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số: ");
        int decimal = sc.nextInt();

        String binary = decimalToBinary(decimal);
        System.out.println(decimal + "ở hệ Nhị Phân là: " + binary);
    }

    public static String decimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal = decimal / 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }
        return binary.toString();
    }
}
