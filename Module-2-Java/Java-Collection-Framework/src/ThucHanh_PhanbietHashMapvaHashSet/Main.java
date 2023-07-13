package ThucHanh_PhanbietHashMapvaHashSet;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("An" , 20, "HN");
        Student student2 = new Student("Dong", 14 , "HB");
        Student student3 = new Student("Tot", 24, "HN");

        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4, student1);

        for (Map.Entry<Integer, Student> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }

        Set<Student> students = new HashSet<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
