package ThucHanh_StackTrongLinkedList;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("1. Stack of String");
        stackOfStrings();
        System.out.println("2. Stack of Interger");
        stackOfInteger();
    }
    private static void stackOfStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        System.out.println("1.1 Size of stack after push operations: " + stack.size());
        System.out.println("1.2 After push: " + stack.toString());
        System.out.println("1.3 Pop elements from stack: ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n1.4 Size of stack after pop operations: " + stack.size());
        System.out.println("==================================================");
    }

    public static void stackOfInteger() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("2.1 Size of stack after push operations: " + stack.size());
        System.out.println("2.2 After push: " + stack.toString());
        System.out.println("2.3 Pop elements from stack: ");
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\n2.4 Size of stack after pop opretions: " + stack.size());
    }
}
