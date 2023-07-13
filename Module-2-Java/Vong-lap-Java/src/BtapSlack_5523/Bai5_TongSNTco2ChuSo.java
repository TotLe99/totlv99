package BtapSlack_5523;

public class Bai5_TongSNTco2ChuSo {
    public static void main(String[] args) {
        int sum2NumPrimeNumber = 0;
        int primeNumber = 2;
        while (primeNumber <= 99) {
            if (isPrimeNumber(primeNumber)) {
                if (primeNumber >= 10 && primeNumber <= 99) {
                    sum2NumPrimeNumber += primeNumber;
                }
            }
            primeNumber++;
        }
        System.out.println("Tổng SNT có 2 chữ số là: " + sum2NumPrimeNumber);
    }

    public static boolean isPrimeNumber(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
