package Btap_QueueUseLinked;

public class LinkedQueue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    //Add element to the REAR
    public void enQueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        rear.next = front;
    }

    //Remove and return the element at the FRONT
    public T deQueue() {
        if (front == null) {
            return null;
        } else {
            T value = front.data;
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
                rear.next = front;
            }
            return value;
        }
    }

    //Display the elements
    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty");
        } else {
            Node<T> current = front;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != front);

            System.out.println();
        }
    }
}
