package BenhVien.Model;

public class BenhAnVip extends BenhAn{
    private String goiVIP;
    private String thoiHanVIP;

    public BenhAnVip(){}

    public BenhAnVip(String stt, String maBA, String tenBA, String ngayNhapVien, String ngayRaVien, String lyDo, String goiVIP, String thoiHanVIP) {
        super(stt, maBA, tenBA, ngayNhapVien, ngayRaVien, lyDo);
        this.goiVIP = goiVIP;
        this.thoiHanVIP = thoiHanVIP;
    }

    public String getGoiVIP() {
        return goiVIP;
    }

    public void setGoiVIP(String goiVIP) {
        this.goiVIP = goiVIP;
    }

    public String getThoiHanVIP() {
        return thoiHanVIP;
    }

    public void setThoiHanVIP(String thoiHanVIP) {
        this.thoiHanVIP = thoiHanVIP;
    }

    @Override
    public String toString() {
        return "BenhAnVip{" +
                "goiVIP='" + goiVIP + '\'' +
                ", thoiHanVIP='" + thoiHanVIP + '\'' +
                '}'+ super.toString();
    }

    @Override
    public String getDataBA() {
        return super.getDataBA()+","+getGoiVIP()+","+getThoiHanVIP();
    }
}
