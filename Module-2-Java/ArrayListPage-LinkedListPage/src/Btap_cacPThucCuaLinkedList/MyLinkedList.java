package Btap_cacPThucCuaLinkedList;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Node next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    private Node getNode(int index) {
        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }

    //in toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node currNode = head;
        for (int i = 0; i < numNodes; i++) {
            sb.append(Integer.toString((int) currNode.getData()));
            if (i != numNodes - 1) {
                sb.append(", ");
            }
            currNode = currNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prevNode = getNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        numNodes++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(numNodes, e);
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        E removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node prevNode = getNode(index - 1);
            Node targetNode = prevNode.next;
            removedData = targetNode.data;
            prevNode.next = targetNode.next;
        }
        numNodes--;
        return removedData;
    }

    public boolean remove(Object e) {
        Node prevNode = null;
        for (Node currNode = head; currNode != null; currNode = currNode.next) {
            if (e.equals(currNode.data)) {
                if (prevNode == null) {
                    head = currNode.next;
                } else {
                    prevNode.next = currNode.next;
                }
                numNodes--;
                return true;
            }
            prevNode = currNode;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> clonedList = new MyLinkedList<>();
        for (Node currNode = head; currNode != null; currNode = currNode.next) {
            clonedList.addLast(currNode.data);
        }
        return clonedList;
    }

    public boolean contains(E o) {
        for (Node currNode = head; currNode != null; currNode = currNode.next) {
            if (o.equals(currNode.data)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        int index = 0;
        for (Node currNode = head; currNode != null; currNode = currNode.next) {
            if (o.equals(currNode.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        //Không thực hiện pthuc này trong LinkedList
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node targetNode = getNode(index);
        return targetNode.data;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public E getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node lastNode = getNode(numNodes - 1);
        return lastNode.data;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }
}
