package Btap_AccessModifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double r) {
        r = radius;
    }

    double getRadius() {
        return radius;
    }

    double getArea() {
        return radius * radius * Math.PI;
    }

}

