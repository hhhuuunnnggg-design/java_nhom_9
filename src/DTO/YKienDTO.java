package DTO;

public class YKienDTO {
    private String idnguoigui;
    private String tieudeyk;
    private String noidungyk;
    private String thoigianyk;
    private String tenhs;
    private String tenlop;
    private String trangthai;

    // Constructor
    public YKienDTO() {
    }

    // Getters and Setters
    public String getIdnguoigui() {
        return idnguoigui;
    }

    public void setIdnguoigui(String idnguoigui) {
        this.idnguoigui = idnguoigui;
    }

    public String getTieudeyk() {
        return tieudeyk;
    }

    public void setTieudeyk(String tieudeyk) {
        this.tieudeyk = tieudeyk;
    }

    public String getNoidungyk() {
        return noidungyk;
    }

    public void setNoidungyk(String noidungyk) {
        this.noidungyk = noidungyk;
    }

    public String getThoigianyk() {
        return thoigianyk;
    }

    public void setThoigianyk(String thoigianyk) {
        this.thoigianyk = thoigianyk;
    }

    public String getTenhs() {
        return tenhs;
    }

    public void setTenhs(String tenhs) {
        this.tenhs = tenhs;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    // ToString method
    @Override
    public String toString() {
        return "YKienDTO{" +
                "idnguoigui='" + idnguoigui + '\'' +
                ", tieudeyk='" + tieudeyk + '\'' +
                ", noidungyk='" + noidungyk + '\'' +
                ", thoigianyk='" + thoigianyk + '\'' +
                ", tenhs='" + tenhs + '\'' +
                ", tenlop='" + tenlop + '\'' +
                ", trangthai='" + trangthai + '\'' +
                '}';
    }
}
