package Model;

public class NhanVien extends NhanSu{
    private String luong;
    private String phongBan;
    private String viTri;

    public NhanVien() { }

    public NhanVien(String id, String hoVaTen, String ngaySinh, String diaChi, String soDienThoai, String luong, String phongBan, String viTri) {
        super(id, hoVaTen, ngaySinh, diaChi, soDienThoai);
        this.luong = luong;
        this.phongBan = phongBan;
        this.viTri = viTri;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "luong='" + luong + '\'' +
                ", phongBan='" + phongBan + '\'' +
                ", viTri='" + viTri + '\'' +
                '}'+super.toString();
    }

    @Override
    public String getData() {
        return super.getData()+","+getLuong()+","+getPhongBan()+","+getViTri();
    }
}
