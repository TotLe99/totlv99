package ThucHanh_CacDoiTuongHinhHoc;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("blue", false);
        System.out.println(shape);
        System.out.println("-----------------------------------");

        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(4.5);
        System.out.println(circle);

        circle = new Circle(4.5, "indigo", false);
        System.out.println(circle);

        System.out.println("-----------------------------------");

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(6, 9);
        System.out.println(rectangle);

        rectangle = new Rectangle(6,9,"Green",false);
        System.out.println(rectangle);
        System.out.println("-----------------------------------");

        Square square = new Square();
        System.out.println(square);

        square = new Square(7);
        System.out.println(square);

        square = new Square(7 ,"Black", true);
        System.out.println(square);
    }
}
