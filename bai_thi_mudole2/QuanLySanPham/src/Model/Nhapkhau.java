package Model;

public class Nhapkhau extends SanPham{
    private String giaNK;
    private String tinhNK;
    private String thueNK;

    public Nhapkhau() {
    }

    public Nhapkhau(String id, String maSP, String tenSP, String giaSP, String soLuong, String nhaSanXuat, String giaNK, String tinhNK, String thueNK) {
        super(id, maSP, tenSP, giaSP, soLuong, nhaSanXuat);
        this.giaNK = giaNK;
        this.tinhNK = tinhNK;
        this.thueNK = thueNK;
    }

    public String getGiaNK() {
        return giaNK;
    }

    public void setGiaNK(String giaNK) {
        this.giaNK = giaNK;
    }

    public String getTinhNK() {
        return tinhNK;
    }

    public void setTinhNK(String tinhNK) {
        this.tinhNK = tinhNK;
    }

    public String getThueNK() {
        return thueNK;
    }

    public void setThueNK(String thueNK) {
        this.thueNK = thueNK;
    }


    @Override
    public String getDataSP() {
        return super.getDataSP()+","+getGiaNK()+","+getTinhNK()+","+getThueNK();
    }

    @Override
    public String toString() {
        return "Nhapkhau{" +
                "giaNK='" + giaNK + '\'' +
                ", tinhNK='" + tinhNK + '\'' +
                ", thueNK='" + thueNK + '\'' +
                '}'+
                super.toString();
    }
}
