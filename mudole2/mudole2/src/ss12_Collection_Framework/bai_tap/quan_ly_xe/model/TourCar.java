package ss12_Collection_Framework.bai_tap.quan_ly_xe.model;

public class TourCar extends Car{
    private int sitNumber ;
    private String carType;

    public TourCar(){
    }
    public TourCar(String seaOfControl, String brand, int year, String owner, int sitNumber, String carType) {
        super(seaOfControl, brand, year, owner);
        this.sitNumber = sitNumber;
        this.carType = carType;
    }

    public int getSitNumber() {
        return sitNumber;
    }

    public void setSitNumber(int sitNumber) {
        this.sitNumber = sitNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "TourCar{" + super.toString() +
                "sitNumber=" + sitNumber +
                ", carType='" + carType + '\'' +
                '}';
    }
}

