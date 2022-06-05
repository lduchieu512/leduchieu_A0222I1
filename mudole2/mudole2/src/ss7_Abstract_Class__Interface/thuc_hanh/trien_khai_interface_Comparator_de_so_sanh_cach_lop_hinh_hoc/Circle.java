package ss7_Abstract_Class__Interface.thuc_hanh.trien_khai_interface_Comparator_de_so_sanh_cach_lop_hinh_hoc;

import ss6_Ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Circle extends Shape {
    private double radius =1.0;

    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius ;
    }

    public Circle(String color, boolean filled, double radius) {
//        setColor(color);
//        setFilled(filled);
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return radius * radius * Math.PI;

    }
    public double getPerimeter(){
        return 2 * radius * Math.PI;

    }

    @Override
    public String toString(){
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }



}
