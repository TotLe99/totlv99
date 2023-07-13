import java.util.Scanner;

public class Btap_GTLNmang2chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap mang cha: ");
        int a = sc.nextInt();
        System.out.print("Nhap mang con: ");
        int b = sc.nextInt();
        int[][] arr;
        arr = new int[a][b];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhap phantu " + (i + 1)+ " : ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("GTLN của mảng 2 chiều Arr = " + max);
    }
}
