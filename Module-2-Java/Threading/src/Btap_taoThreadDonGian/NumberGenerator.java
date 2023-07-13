package Btap_taoThreadDonGian;

public class NumberGenerator implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + Thread.currentThread().hashCode() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator();
        NumberGenerator numberGenerator2 = new NumberGenerator();

        Thread thread1 = new Thread(numberGenerator1);
        Thread thread2 = new Thread(numberGenerator2);

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
