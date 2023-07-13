import java.util.Scanner;

public class Btap_TongCotMang2Chieu {
    public static void main(String[] args) {
        int[][] array = {{4, 3, 3}, {2, 6, 8}, {9, 8, 1}};

        Scanner sc = new Scanner(System.in);
        int input_Cot;
        int sum = 0;

        System.out.print("nhap cot thu: ");
        input_Cot = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
           sum += array[i][input_Cot - 1];
        }
        System.out.println("Tong cot: " + sum);
    }
}
