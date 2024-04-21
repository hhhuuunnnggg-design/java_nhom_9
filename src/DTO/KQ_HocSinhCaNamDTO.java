package DTO;
public class KQ_HocSinhCaNamDTO {

    private String HocSinhID;
    private String NamHocID;
    private String HocLuc;
    private Float DiemTrungBinhNam;
    private String KetQua;

    public KQ_HocSinhCaNamDTO(String hocSinhID, String namHocID, String hocLuc, Float diemTrungBinhNam, String ketQua) {
        HocSinhID = hocSinhID;
        NamHocID = namHocID;
        HocLuc = hocLuc;
        DiemTrungBinhNam = diemTrungBinhNam;
        KetQua = ketQua;
    }

    public String getHocSinhID() {
        return HocSinhID;
    }

    public void setHocSinhID(String hocSinhID) {
        HocSinhID = hocSinhID;
    }

    public String getNamHocID() {
        return NamHocID;
    }

    public void setNamHocID(String namHocID) {
        NamHocID = namHocID;
    }

    public String getHocLuc() {
        return HocLuc;
    }

    public void setHocLuc(String hocLuc) {
        HocLuc = hocLuc;
    }

    public Float getDiemTrungBinhNam() {
        return DiemTrungBinhNam;
    }

    public void setDiemTrungBinhNam(Float diemTrungBinhNam) {
        DiemTrungBinhNam = diemTrungBinhNam;
    }

    public String getKetQua() {
        return KetQua;
    }

    public void setKetQua(String ketQua) {
        KetQua = ketQua;
    }

}