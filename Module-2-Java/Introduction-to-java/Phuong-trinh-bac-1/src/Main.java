import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Giai phuong trinh bac 1: ax + b = c");

        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        System.out.print("c = ");
        double c = sc.nextDouble();

        if (a != 0){
            double x = (c - b) / a;
            System.out.printf("Ket qua x = %f!\n", x);
        } else {
            if (b == c) {
                System.out.print("Vo so nghiem");
            } else {
                System.out.print("Vo nghiem");
            }
        }
    }
}