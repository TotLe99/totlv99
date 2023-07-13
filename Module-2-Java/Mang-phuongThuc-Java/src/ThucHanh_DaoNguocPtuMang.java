import java.util.Scanner;

public class ThucHanh_DaoNguocPtuMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhap size: ");
            size = sc.nextInt();
            if (size > 20)
                System.out.println("Size ko dc qua 20!");
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhap element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
            i++;
        }

        System.out.println("Array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        System.out.println("\nReverseArray: ");
        for (int j = array.length - 1; j >= 0; j--) {
            System.out.print(array[j] + "\t");
        }
    }
}
