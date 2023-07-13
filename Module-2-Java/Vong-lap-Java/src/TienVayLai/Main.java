import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double Tien_gui, Tien_lai = 0;
        int So_thang_gui;
        final double Ti_le_lai_suat = 5.5/100;

        System.out.print("Nhap so tien gui: ");
        Tien_gui = sc.nextDouble();
        System.out.print("So thang: ");
        So_thang_gui = sc.nextInt();

        for (int i = 0; i < So_thang_gui; i++) {
            Tien_lai += Tien_gui * Ti_le_lai_suat / 12 * So_thang_gui;
        }
        System.out.println("Bạn đã gửi " + So_thang_gui + " tháng. Tiền lãi: " + Tien_lai);
    }
}