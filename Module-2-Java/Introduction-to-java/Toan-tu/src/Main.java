import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float chieuDai;
        float chieuRong;

        Scanner sc = new Scanner(System.in);

        System.out.println("Chieu dai = ");
        chieuDai = sc.nextFloat();

        System.out.println("Chieu rong = ");
        chieuRong = sc.nextFloat();

        float area = chieuDai * chieuRong;
        System.out.println("Dien tich = " + area);

        sc.close();
    }
}