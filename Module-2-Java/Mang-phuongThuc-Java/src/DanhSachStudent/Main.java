package DanhSachStudent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();

        while (true) {
            System.out.println("Danh sách sinh viên");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Sửa");
            System.out.println("4. Xoá");
            System.out.println("5. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    managerStudent.show();
                    break;
                case 2:
                    managerStudent.add();
                    break;
                case 3:
                    managerStudent.fix();
                    break;
                case 4:
                    managerStudent.delete();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
