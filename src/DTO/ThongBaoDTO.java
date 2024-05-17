package DTO;

public class ThongBaoDTO {
    private String idnguoigui;
    private String tieudetb;
    private String noidungtb;
    private String thoigiantb;
    private String loaitb;

    // Constructor
    public ThongBaoDTO() {
    }

    // Getters and Setters
    public String getIdnguoigui() {
        return idnguoigui;
    }

    public void setIdnguoigui(String idnguoigui) {
        this.idnguoigui = idnguoigui;
    }

    public String getTieudetb() {
        return tieudetb;
    }

    public void setTieudetb(String tieudetb) {
        this.tieudetb = tieudetb;
    }

    public String getNoidungtb() {
        return noidungtb;
    }

    public void setNoidungtb(String noidungtb) {
        this.noidungtb = noidungtb;
    }

    public String getThoigiantb() {
        return thoigiantb;
    }

    public void setThoigiantb(String thoigiantb) {
        this.thoigiantb = thoigiantb;
    }

    public String getLoaitb() {
        return loaitb;
    }

    public void setLoaitb(String loaitb) {
        this.loaitb = loaitb;
    }

    // ToString method
    @Override
    public String toString() {
        return "ThongBaoDTO{" +
                "idnguoigui='" + idnguoigui + '\'' +
                ", tieudetb='" + tieudetb + '\'' +
                ", noidungtb='" + noidungtb + '\'' +
                ", thoigiantb='" + thoigiantb + '\'' +
                ", loaitb='" + loaitb + '\'' +
                '}';
    }
}

