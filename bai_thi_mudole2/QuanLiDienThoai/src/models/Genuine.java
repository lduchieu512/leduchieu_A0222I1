package models;

public class Genuine extends Phone {
    private int warrantyTime;
    private int warrantyCode;

    public Genuine() {
    }

    public Genuine( int price, String name, String brand) {
        super(price, name, brand);
    }

    public Genuine( double price, String name, String brand, int warrantyTime, int warrantyCode) {
        super( price, name, brand);
        this.warrantyTime = warrantyTime;
        this.warrantyCode = warrantyCode;
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(int warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public int getWarrantyCode() {
        return warrantyCode;
    }

    public void setWarrantyCode(int warrantyCode) {
        this.warrantyCode = warrantyCode;
    }

    @Override
    public String toString() {
        return super.toString()+
                "models.Genuine{" +
                "warrantyTime=" + warrantyTime +
                ", warrantyCode=" + warrantyCode +
                '}';
    }
}
