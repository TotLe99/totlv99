import java.util.Scanner;

public class ThucHanh_timMax {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhap size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("ko vuot qua 20 size");
            }
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhap element" + (i + 1) + " : ");
            array[i] = sc.nextInt();
            i++;
        }

        System.out.print("Array: ");
        for (int Arrays : array) {
            System.out.print(Arrays + "\t");
        }

        int max = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
            }
        }

        System.out.println("\nGTLN trong mang: " + max);
    }
}
