import java.util.Arrays;

public class Btap_GopMang {
    public static void main(String[] args) {
        int[] arr1 = {4, 12, 7, 8, 1, 6, 9};
        int[] arr2 = {4, 12, 7, 8, 1, 6, 9};
        int[] arr3 = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        System.out.println(Arrays.toString(arr3));

        for (int i = 0; i < arr2.length; i++) {
            arr3[arr2.length + i] = arr2[i];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
