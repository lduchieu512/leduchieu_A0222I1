package model;

public class Van_phong {
    private int id;
    private String loai_van_phong;

    public Van_phong(int id, String loai_van_phong) {
        this.id = id;
        this.loai_van_phong = loai_van_phong;
    }

    public Van_phong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoai_van_phong() {
        return loai_van_phong;
    }

    public void setLoai_van_phong(String loai_van_phong) {
        this.loai_van_phong = loai_van_phong;
    }
}
