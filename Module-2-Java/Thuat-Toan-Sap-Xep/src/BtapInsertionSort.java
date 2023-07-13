import java.util.Arrays;

public class BtapInsertionSort {
    public static void main(String[] args) {
        int[] list = {4, 6, 1, 2, 9};
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i;
            while (j > 0 && key < list[j - 1]) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }
}
