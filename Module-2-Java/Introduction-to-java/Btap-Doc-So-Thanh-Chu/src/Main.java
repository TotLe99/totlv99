import java.util.Scanner;


        public class Main {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhap so: ");
                int number = sc.nextInt();

                if (number < 2) {
                    System.out.println(number + " ko là SNT");
                } else {
                    boolean check = true;
                    for (int i = 2; i < Math.sqrt(number); i++) {
                        if (number % i == 0) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        System.out.println(number + " là SNT");
                    } else {
                        System.out.println(number + " ko là SNT");
                    }
                }
            }
        }