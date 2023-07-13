package Btap_cacPThucCuaArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size, Object[] elements) {
        this.size = size;
        this.elements = elements;
    }

    //in toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString());
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //them ptu vào vị trí
    public void add(int index, E e) {
        if (size >= elements.length) {
            ensureCapacity(size + 1);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;
    }

    // Xoá ptu tại vị trí
    public E remove(int index) {
        E e = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    //trả về số lượng ptu
    public int size() {
        return size;
    }

    // Tạo 1 bản sao
    public MyList<E> clone() {
        MyList<E> clonedList = new MyList<>();
        for (int i = 0; i < size; i++) {
            clonedList.add((E) elements[i]);
        }
        return clonedList;
    }

    //xem ptu có trong ds ko
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    //trả về vị trí đầu tiên của ptu, nếu ko trả về -1
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    //thêm ptu vào cuối ds
    public boolean add(E o) {
        add(size, o);
        return true;
    }

    // Đảm bảo ds có thể chứa ít nhất minCapacity ptu
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    // Trả về ptu tại vị trí i trong ds
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    // Xoá tất cả ptu
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
