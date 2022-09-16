package model;

public class Quan_ly {
    private int id;
    private String ma_mat_bang;
    private double dien_tich;
    private int trang_thai_id;
    private int tang;
    private int van_phong_id;
    private String mo_ta;
    private int gia_cho_thue;
    private String ngay_bat_dau;
    private String ngay_ket_thuc;

    public Quan_ly() {
    }

    public Quan_ly(String ma_mat_bang, double dien_tich, int trang_thai_id, int tang, int van_phong_id, String mo_ta, int gia_cho_thue, String ngay_bat_dau, String ngay_ket_thuc) {
        this.ma_mat_bang = ma_mat_bang;
        this.dien_tich = dien_tich;
        this.trang_thai_id = trang_thai_id;
        this.tang = tang;
        this.van_phong_id = van_phong_id;
        this.mo_ta = mo_ta;
        this.gia_cho_thue = gia_cho_thue;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public Quan_ly(int id, String ma_mat_bang, double dien_tich, int trang_thai_id, int tang, int van_phong_id, String mo_ta, int gia_cho_thue, String ngay_bat_dau, String ngay_ket_thuc) {
        this.id = id;
        this.ma_mat_bang = ma_mat_bang;
        this.dien_tich = dien_tich;
        this.trang_thai_id = trang_thai_id;
        this.tang = tang;
        this.van_phong_id = van_phong_id;
        this.mo_ta = mo_ta;
        this.gia_cho_thue = gia_cho_thue;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_mat_bang() {
        return ma_mat_bang;
    }

    public void setMa_mat_bang(String ma_mat_bang) {
        this.ma_mat_bang = ma_mat_bang;
    }

    public double getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(double dien_tich) {
        this.dien_tich = dien_tich;
    }

    public int getTrang_thai_id() {
        return trang_thai_id;
    }

    public void setTrang_thai_id(int trang_thai_id) {
        this.trang_thai_id = trang_thai_id;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getVan_phong_id() {
        return van_phong_id;
    }

    public void setVan_phong_id(int van_phong_id) {
        this.van_phong_id = van_phong_id;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getGia_cho_thue() {
        return gia_cho_thue;
    }

    public void setGia_cho_thue(int gia_cho_thue) {
        this.gia_cho_thue = gia_cho_thue;
    }

    public String getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(String ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public String getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(String ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }
}