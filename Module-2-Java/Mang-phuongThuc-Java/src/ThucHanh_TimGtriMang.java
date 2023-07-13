import java.util.Scanner;

public class ThucHanh_TimGtriMang {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna",
                "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String inputName = sc.nextLine();

        boolean isExist = true;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(inputName)) {
                System.out.println("Vi tri cua" + inputName + "trong list la:" + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Khong thay " + inputName + " trong list");
        }
    }
}
