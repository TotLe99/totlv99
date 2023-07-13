package Btap_QueueUseLinked;

public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();

        //add
        linkedQueue.enQueue(11);
        linkedQueue.enQueue(22);
        linkedQueue.enQueue(33);
        linkedQueue.enQueue(44);
        System.out.print("Sau khi them: ");
        linkedQueue.displayQueue();

        //remove
        int delete_1 = linkedQueue.deQueue();
        int delete_2 = linkedQueue.deQueue();
        System.out.println("\nPtu xoa: " + delete_1);
        System.out.println("\nPtu xoa: " + delete_2);

        System.out.print("\nSau khi xoa: ");
        linkedQueue.displayQueue();
    }
}
