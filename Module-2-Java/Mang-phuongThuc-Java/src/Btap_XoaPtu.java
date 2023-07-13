import java.util.Scanner;

public class Btap_XoaPtu {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap phan tu can xoa: ");
        int x = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                System.out.println("Vi tri " + (i + 1) + " xoa phan tu " + arr[i]);
                System.out.println("Mang sau khi xoa: ");
                break;
            }
        }

        for (int i : arr) {
            if (x == i) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
