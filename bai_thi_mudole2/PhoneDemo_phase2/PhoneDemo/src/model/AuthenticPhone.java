package model;

public class AuthenticPhone extends Phone{
    private int granteeByYear;
    private String granteeByCode;

    public AuthenticPhone(int id, String name, Double price, String manufacturer, int granteeByYear, String granteeByCode) {
        super(id, name, price, manufacturer);
        this.granteeByYear = granteeByYear;
        this.granteeByCode = granteeByCode;
    }


    public int getGranteeByYear() {
        return granteeByYear;
    }

    public void setGranteeByYear(int granteeByYear) {
        this.granteeByYear = granteeByYear;
    }

    public String getGranteeByCode() {
        return granteeByCode;
    }

    public void setGranteeByCode(String granteeByCode) {
        this.granteeByCode = granteeByCode;
    }

    @Override
    public String toString() {
        return "AuthenticPhone{" +
                "granteeByYear=" + granteeByYear +
                ", granteeByCode='" + granteeByCode + '\'' +
                "} " + super.toString();
    }

    public String toData(){
        return String.format("%s,%s,%s,0", super.toData(), granteeByYear, granteeByCode);
    }
}
