package Btap_CircleVaCylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(11, "Black");
        System.out.println(circle);
        System.out.println("---------------------------");

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(20, 10, "Pink");
        System.out.println(cylinder);
    }
}
