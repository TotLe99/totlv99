public class Btap_timMin {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
