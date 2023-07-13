package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> students;
    public StudentService(){
        students = new ArrayList<>();
        students.add(new Student("Tina", "https://www.pngmart.com/files/17/Student-PNG-Clipart.png"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student findByID(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }

    public int findIndexByID(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void editStudent(int id, Student student) {
        int index = findIndexByID(id);
        students.set(index, student);
    }

    public List<Student> deleteStudent(int id) {
        int index = findIndexByID(id);
        students.remove(index);
        return students;
    }

    public void createStudent(String name, String img) {
        students.add(new Student(name,img));
    }
}
