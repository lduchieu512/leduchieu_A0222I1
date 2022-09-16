package model;

public class Household {
     private int  IdHousehold;
     private String nameOfHouseholdHead;
     private int quantily;
     private int DateOfRegistration;
     private String Address;

    public Household(int idHousehold, String nameOfHouseholdHead, int quantily, int dateOfRegistration, String address) {
        IdHousehold = idHousehold;
        this.nameOfHouseholdHead = nameOfHouseholdHead;
        this.quantily = quantily;
        DateOfRegistration = dateOfRegistration;
        Address = address;
    }

    public Household(String nameOfHouseholdHead, int quantily, int dateOfRegistration, String address) {
        this.nameOfHouseholdHead = nameOfHouseholdHead;
        this.quantily = quantily;
        DateOfRegistration = dateOfRegistration;
        Address = address;
    }

    public Household() {
    }

    public int getIdHousehold() {
        return IdHousehold;
    }

    public void setIdHousehold(int idHousehold) {
        IdHousehold = idHousehold;
    }

    public String getNameOfHouseholdHead() {
        return nameOfHouseholdHead;
    }

    public void setNameOfHouseholdHead(String nameOfHouseholdHead) {
        this.nameOfHouseholdHead = nameOfHouseholdHead;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public int getDateOfRegistration() {
        return DateOfRegistration;
    }

    public void setDateOfRegistration(int dateOfRegistration) {
        DateOfRegistration = dateOfRegistration;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
