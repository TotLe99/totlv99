import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Btap_ThemPtu {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ptu can add: ");
        int add = sc.nextInt();
        System.out.print("Nhap vi tri add ptu: ");
        int index = sc.nextInt();

        if (index < 0 || index > arr.length - 1) {
            System.out.println("Khong chen duoc phan tu!");
        }

        int[] arr2 = new int[arr.length + 1];
        for (int i = 0; i < arr2.length; i++) {
            if (index > i) {
                arr2[i] = arr[i];
            } else if (index == i) {
                arr2[i] = add;
            } else {
                arr2[i] = arr[i - 1];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
