package ss6_Ke_thua.bai_tap.lop_Circle_va_lop_Cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return getRadius()* 2* 3.14* height;
    }


    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }
}
