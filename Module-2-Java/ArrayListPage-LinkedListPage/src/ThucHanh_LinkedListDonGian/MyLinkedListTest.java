package ThucHanh_LinkedListDonGian;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("======= TESTING =======");
        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.addFirst(11);
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(13);

        myLinkedList.add(6,9);
        myLinkedList.add(100,10);
        myLinkedList.add(10,11);
        myLinkedList.printList();
    }
}
