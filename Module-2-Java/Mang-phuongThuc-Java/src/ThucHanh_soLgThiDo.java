import java.util.Scanner;

public class ThucHanh_soLgThiDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size;
        int array[];
        System.out.print("Nhap size: ");
        size = sc.nextInt();

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Nhap diem thu " + (i + 1) + " : ");
            array[i] = sc.nextInt();
            i++;
        }

        int count = 0;
        System.out.print("Danh sach diem: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
            if (array[j] >= 5 && array[j] <= 10) {
                count++;
            }
        }
        System.out.println("\nSo nguoi dat: " + count);
    }
}
