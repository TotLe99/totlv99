package Btap_DaoNguocStack;

import java.util.Arrays;
import java.util.Stack;

public class MyGenericStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int[] arr = {2, 4, 5, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        System.out.println("Stack: " + stack);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.print("Mang sau khi dao nguoc: " + Arrays.toString(arr));
    }
}
