package manager;

import model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyen C", "1999-01-12", "c@gmail", "Ha Tinh", "0978901234"));
        students.add(new Student(2, "Nguyen D", "1999-02-18", "d@gmail", "Ha Noi", "0978904321"));
    }
}
