package DTO;
public class NamHocDTO {
    private String NamHocID;
    private String NamHocBatDau;
    private String NamHocKetThuc;

    public NamHocDTO(String namHocID, String namHocBatDau, String namHocKetThuc) {
        NamHocID = namHocID;
        NamHocBatDau = namHocBatDau;
        NamHocKetThuc = namHocKetThuc;
    }

    public String getNamHocID() {
        return NamHocID;
    }

    public void setNamHocID(String namHocID) {
        NamHocID = namHocID;
    }

    public String getNamHocBatDau() {
        return NamHocBatDau;
    }

    public void setNamHocBatDau(String namHocBatDau) {
        NamHocBatDau = namHocBatDau;
    }

    public String getNamHocKetThuc() {
        return NamHocKetThuc;
    }

    public void setNamHocKetThuc(String namHocKetThuc) {
        NamHocKetThuc = namHocKetThuc;
    }

}
