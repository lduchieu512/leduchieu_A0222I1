package ss7_Abstract_Class__Interface.thuc_hanh.trien_khai_interface_Comparator_de_so_sanh_cach_lop_hinh_hoc;

public class Shape {
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


}
