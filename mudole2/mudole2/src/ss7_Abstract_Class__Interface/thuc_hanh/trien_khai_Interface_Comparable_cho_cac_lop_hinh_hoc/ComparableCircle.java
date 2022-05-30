package ss7_Abstract_Class__Interface.thuc_hanh.trien_khai_Interface_Comparable_cho_cac_lop_hinh_hoc;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, Boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius()<o.getRadius()) return -1;
        else return 0;
    }
}
