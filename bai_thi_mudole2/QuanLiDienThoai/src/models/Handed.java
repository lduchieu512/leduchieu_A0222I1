package models;

import models.Phone;

public class Handed extends Phone {
    private String country;
    private int status;

    public Handed() {
    }

    public Handed( int price, String name, String brand, String country, int status) {
        super( price, name, brand);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString()+
                "models.Handed{" +
                "country='" + country + '\'' +
                ", status=" + status +
                '}';
    }
}
