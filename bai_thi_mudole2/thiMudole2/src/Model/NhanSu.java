package Model;

public abstract class NhanSu {
    private String id;
    private String hoVaTen;
    private String ngaySinh;
    private String diaChi;
    private String soDienThoai;

    public NhanSu(){}

    public NhanSu(String id, String hoVaTen, String ngaySinh, String diaChi, String soDienThoai) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMadd() {
        return id;
    }

    public void setMadd(String id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "NhanSu{" +
                "madd='" + id + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }

    public String getData(){
        return String.format("%s,%s,%s,%s,%s",id,hoVaTen,ngaySinh,diaChi,soDienThoai);
    }
}
