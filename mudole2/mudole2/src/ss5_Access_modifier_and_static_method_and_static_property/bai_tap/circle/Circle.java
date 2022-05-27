package ss5_Access_modifier_and_static_method_and_static_property.bai_tap.circle;

public class Circle {
    private double radius =1.0;
    private String color = "red";


    public Circle(){}
    public Circle(double r){
        this.radius =radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return radius*radius*3.14;
    }
}
