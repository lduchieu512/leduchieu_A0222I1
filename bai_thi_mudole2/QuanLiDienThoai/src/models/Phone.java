package models;

public abstract class Phone {
    private int id;
    private double price;
    private String name;
    private String brand;

    public Phone() {
    }

    public Phone( double price, String name, String brand) {

        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "models.Phone{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
