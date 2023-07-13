package Btap_CircleVaCylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTotalArea() {
        return ((2 * Math.PI * getRadius() * getRadius()) + (2 * Math.PI * getRadius() * height));
    }

    public double getTotalPerimeter() {
        return (2 * Math.PI * getRadius() + 2 * Math.PI * height);
    }

    @Override
    public String toString() {
        return "a Cylinder with height = " + getHeight() + " , radius = " + getRadius() + " , S = " + getTotalArea()
                + " , C = " + getTotalPerimeter() + ", color is " + getColor();
    }
}
