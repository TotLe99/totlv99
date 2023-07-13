package ThucHanh_QueueUseArray;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        if (currentSize == capacity) {
            return true;
        }
        return false;
    }

    public boolean isQueueEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Đã đầy! Ko thể thêm phần tử.");
        } else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Phần tử " + item + " đã thêm vào Queue!");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Rỗng! Ko có Ptu để Remove.");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Lấy ptu thành công! Remove: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Lấy ptu thành công! Remove: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
}
