package ss7_Abstract_Class__Interface.bai_tap.resizeable;

public class Shape implements Resizeable {
    private String color ="Green";
    private boolean filled = true;

    public Shape(){}
    public Shape(String color, Boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }


    @Override
    public void resize(double percent) {

    }
}
