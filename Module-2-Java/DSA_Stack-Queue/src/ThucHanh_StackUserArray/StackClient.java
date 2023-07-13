package ThucHanh_StackUserArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StackClient {
    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack(5);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        int afterSize = myStack.size();
        System.out.println("1. Size: " + afterSize);
        System.out.printf("2. Lấy phần tử từ Stack: ");
        while (!myStack.isEmpty()) {
            System.out.printf(" %d", myStack.pop());
        }

    }
}
