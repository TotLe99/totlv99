import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Chieu cao = ");
        double chieuCao = sc.nextDouble();
        System.out.print("Can nang = ");
        double canNang = sc.nextDouble();

        double bmi = canNang / Math.pow(chieuCao, 2);
        System.out.printf("%-20s%s", "BMI", "Thể trạng \n");

        if (bmi < 18.5) {
            System.out.printf("%-20f%s", bmi , "Gầy");
        } else if (bmi < 25) {
            System.out.printf("%-20f%s", bmi , "Bình thường");
        } else if (bmi < 30) {
            System.out.printf("%-20f%s", bmi , "Thừa cân");
        } else {
            System.out.printf("%-20f%s", bmi , "Béo");
        }
    }
}