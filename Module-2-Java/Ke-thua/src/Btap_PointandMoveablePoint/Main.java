package Btap_PointandMoveablePoint;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point = new Point(6, 8);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(4, 4);
        System.out.println(moveablePoint);

        moveablePoint = new MoveablePoint(4, 4, 6,6);
        System.out.println(moveablePoint);

        moveablePoint.move();
        moveablePoint.move();
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
