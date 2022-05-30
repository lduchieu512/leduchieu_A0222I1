package ss6_Ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class Rectangle extends Shape{
    private double width =1.0,length =1.0 ;

    public Rectangle(){

    }
    public Rectangle( double width,double length){
        this.length =length;
        this.width =width;
    }

    public Rectangle(String color, Boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return 2*(width+length);
    }
    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }
}
