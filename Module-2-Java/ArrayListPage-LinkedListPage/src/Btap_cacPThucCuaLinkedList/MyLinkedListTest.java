package Btap_cacPThucCuaLinkedList;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.addLast(44);
        myLinkedList.addFirst(11);
        myLinkedList.add(22);
        myLinkedList.add(0, 1);

        System.out.println("==== Sau khi thêm phần tử ====");
        System.out.println("LinkedList: " + myLinkedList.toString());
    }
}
