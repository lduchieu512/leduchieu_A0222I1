package ss6_Ke_thua.bai_tap.lop_Point_va_MoveablePoint;

public class Test {
    public static void main(String[] args) {
        Point2D point2D= new Point2D(3,9);
        System.out.println(point2D);

        MoveblePoint moveablePoint= new MoveblePoint(2,5,7,9);
        System.out.println(moveablePoint.move());
    }
}
