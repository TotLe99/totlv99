import java.util.Scanner;

public class ThucHanh_ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double F;
        double C;
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Chuyen tu do F sang do C");
            System.out.println("2. Chuyen tu do C sang do F");
            System.out.println("0. Exit");
            System.out.println("Nhap: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap do F: ");
                    F = sc.nextDouble();
                    System.out.println("Chuyen do F sang C = " + FsangC(F));
                    break;
                case 2:
                    System.out.print("Nhap do C: ");
                    C = sc.nextDouble();
                    System.out.println("Chuyen do C sang F = " + CsangF(C));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice > 0);
    }

    public static double CsangF(double C) {
        double F = (9.0 / 5) * C + 32;
        return F;
    }

    public static double FsangC(double F) {
        double C = (5.0 / 9) * (F - 32);
        return C;
    }
}
