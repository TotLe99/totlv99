import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double VND, USD;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tien: ");
        USD = sc.nextDouble();

        VND = USD * 23000;
        System.out.printf("%s USD = %s VNĐ", USD, VND);
    }
}