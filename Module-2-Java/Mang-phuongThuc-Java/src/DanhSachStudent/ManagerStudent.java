package DanhSachStudent;

import java.util.Scanner;

public class ManagerStudent {
    Scanner sc = new Scanner(System.in);
    Student[] students = new Student[2];

    ManagerStudent(){
        students[0] = new Student(1, "Tùng", 20);
        students[1] = new Student(2, "Vương", 21);
    }

    public void show() {
        for (Student student : students) {
            System.out.println(student.getId() + " - " + student.getName() + " - "
            + student.getAge());
        }
    }

    public void add() {
        System.out.println("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        Student student = new Student(id, name, age);

        Student[] newStudents = new Student[students.length + 1];
        newStudents[newStudents.length - 1] = student;
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        students = newStudents;
    }

    public void fix() {
        System.out.println("Nhập ID cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student : students) {
            if (id == student.getId()) {
                System.out.println("Nhập tên sửa: ");
                student.setName(sc.nextLine());
                System.out.println("Nhập tuổi sửa: ");
                student.setAge(Integer.parseInt(sc.nextLine()));
                break;
            }
        }
    }

    public void delete() {
        System.out.println("Nhập ID cần xoá");
        int id = Integer.parseInt(sc.nextLine());

        Student[] deleteStudent = new Student[students.length - 1];
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                for (int j = 0; j < deleteStudent.length; j++) {
                    if (j < i) {
                        deleteStudent[j] = students[j];
                    } else {
                        deleteStudent[j] = students[j + 1];
                    }
                }
            }
        }
        students = deleteStudent;
    }
}
