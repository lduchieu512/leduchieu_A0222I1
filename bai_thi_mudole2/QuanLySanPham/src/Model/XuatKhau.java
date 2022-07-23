package Model;

public class XuatKhau extends SanPham{
    private String giaXK;
    private String quocgiaNK;

    public XuatKhau() {
    }

    public XuatKhau(String id, String maSP, String tenSP, String giaSP, String soLuong, String nhaSanXuat, String giaXK, String quocgiaNK) {
        super(id, maSP, tenSP, giaSP, soLuong, nhaSanXuat);
        this.giaXK = giaXK;
        this.quocgiaNK = quocgiaNK;
    }

    public String getGiaXK() {
        return giaXK;
    }

    public void setGiaXK(String giaXK) {
        this.giaXK = giaXK;
    }

    public String getQuocgiaNK() {
        return quocgiaNK;
    }

    public void setQuocgiaNK(String quocgiaNK) {
        this.quocgiaNK = quocgiaNK;
    }

    @Override
    public String getDataSP() {
        return super.getDataSP()+","+getGiaXK()+","+getQuocgiaNK();
    }
    @Override
    public String toString() {
        return "XuatKhau{" +
                "giaXK='" + giaXK + '\'' +
                ", quocgiaNK='" + quocgiaNK + '\'' +
                '}'+
                super.toString();
    }

}
