package BenhVien.Model;

public class BenhAnThuong extends BenhAn{
    private String vienPhi;

    public BenhAnThuong(){
    }

    public BenhAnThuong(String stt, String maBA, String tenBA, String ngayNhapVien, String ngayRaVien, String lyDo, String vienPhi) {
        super(stt, maBA, tenBA, ngayNhapVien, ngayRaVien, lyDo);
        this.vienPhi = vienPhi;
    }

    public String getVienPhi() {
        return vienPhi;
    }

    public void setVienPhi(String vienPhi) {
        this.vienPhi = vienPhi;
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" +
                "vienPhi='" + vienPhi + '\'' +
                '}'+super.toString();
    }

    @Override
    public String getDataBA() {
        return super.getDataBA()+","+getVienPhi();
    }
}
