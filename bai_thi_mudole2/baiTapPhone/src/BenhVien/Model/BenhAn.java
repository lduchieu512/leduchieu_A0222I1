package BenhVien.Model;

public abstract class BenhAn {
    private String stt;
    private String maBA;
    private String tenBA;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDo;

    public BenhAn() {
    }

    public BenhAn(String stt, String maBA, String tenBA, String ngayNhapVien, String ngayRaVien, String lyDo) {
        this.stt = stt;
        this.maBA = maBA;
        this.tenBA = tenBA;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getMaBA() {
        return maBA;
    }

    public void setMaBA(String maBA) {
        this.maBA = maBA;
    }

    public String getTenBA() {
        return tenBA;
    }

    public void setTenBA(String tenBA) {
        this.tenBA = tenBA;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    @Override
    public String toString() {
        return "BenhAn{" +
                "stt='" + stt + '\'' +
                ", maBA='" + maBA + '\'' +
                ", tenBA='" + tenBA + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyDo='" + lyDo + '\'' +
                '}';
    }

    public String getDataBA(){
        return String.format("%s,%s,%s,%s,%s,%s",stt,maBA,tenBA,ngayNhapVien,ngayRaVien,lyDo);
    }
}
