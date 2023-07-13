package ThucHanh_StaticMethod.codegym;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(111, "Tot");
        Student s2 = new Student(222, "GGG");
        Student s3 = new Student(333, "MMM");

        s1.display();
        s2.display();
        s3.display();
    }
}
