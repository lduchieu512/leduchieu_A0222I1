package model;

public class Trang_thai {
    private int id;
    private String loai_trang_thai;

    public Trang_thai(int id, String loai_trang_thai) {
        this.id = id;
        this.loai_trang_thai = loai_trang_thai;
    }

    public Trang_thai() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoai_trang_thai() {
        return loai_trang_thai;
    }

    public void setLoai_trang_thai(String loai_trang_thai) {
        this.loai_trang_thai = loai_trang_thai;
    }
}
