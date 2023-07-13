package Btap_SNTnhoHon100;

public class HienThiSNTnhoHon100 {
    public static void main(String[] args) {
        int n = 2;
        while (n < 100) {
            if (isPrimeNumber(n)) {
                System.out.print(n + " ");
            }
            n++;
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
