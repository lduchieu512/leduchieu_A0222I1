package ss12_Collection_Framework.bai_tap.quan_ly_xe.model;

public class Car {
    private String seaOfControl ;
    private String brand;
    private int year;
    private String owner;

    public Car(String seaOfControl, String brand, int year, String owner) {
        this.seaOfControl = seaOfControl;
        this.brand = brand;
        this.year = year;
        this.owner = owner;
    }

    public Car() {
    }

    public String getSeaOfControl() {
        return seaOfControl;
    }

    public void setSeaOfControl(String seaOfControl) {
        this.seaOfControl = seaOfControl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seaOfControl='" + seaOfControl + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", owner='" + owner + '\'' +
                '}';
    }
}
