package DTO;

public class ChiTietDiemDTO {
    private String HocSinhID;
    private String MonHocID;
    private String HocKyID;
    private String HeSoID;
    private String NamHocID;
    private Float Diem;

    public ChiTietDiemDTO(String hocSinhID, String monHocID, String hocKyID, String HeSoid,String namhocid,  Float diem) {
        HocSinhID = hocSinhID;
        HocKyID = hocKyID;
        MonHocID = monHocID;
        HeSoID = HeSoid;
        NamHocID = namhocid;
        Diem = diem;
    }

    public String getHocSinhID() {
        return HocSinhID;
    }

    public void setHocSinhID(String hocSinhID) {
        HocSinhID = hocSinhID;
    }

    public String getHocKyID() {
        return HocKyID;
    }

    public void setHocKyID(String hocKyID) {
        HocKyID = hocKyID;
    }

    public String getMonHocID() {
        return MonHocID;
    }

    public void setMonHocID(String monHocID) {
        MonHocID = monHocID;
    }

    public Float getDiem() {
        return Diem;
    }

    public void setDiem(Float diem) {
        Diem = diem;
    }

    public String getHeSoID() {
        return HeSoID;
    }

    public void setHeSoID(String heSoID) {
        HeSoID = heSoID;
    }

    public String getNamHocID() {
        return NamHocID;
    }

    public void setNamHocID(String namHocID) {
        NamHocID = namHocID;
    }

}
