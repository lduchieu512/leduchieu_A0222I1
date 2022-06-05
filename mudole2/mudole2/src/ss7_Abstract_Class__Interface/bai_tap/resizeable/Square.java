package ss7_Abstract_Class__Interface.bai_tap.resizeable;

public class Square extends Rectangle {
    public Square() {
        super(1,1);
    }
    public Square(double side)  {
       super(side,side);
    }

    public Square(String color, Boolean filled,double site) {
        super(color, filled, site, site);
    }

    public double getSide(){
        return getWidth();
    }
    public void  setSide( double side){
        super.setWidth(side);
        super.setLength(side);

    }
    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double height) {
        setSide(height);
    }

    @Override
    public String toString() {
        return "A Square with side= "
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }


}
