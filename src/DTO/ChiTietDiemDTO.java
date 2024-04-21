package DTO;

public class ChiTietDiemDTO {
    private String HocSinhID;
    private String HocKyID;
    private String MonHocID;
    private String TenHeSo;
    private Float Diem;

    public ChiTietDiemDTO(String hocSinhID, String hocKyID, String monHocID, String tenHeSo, Float diem) {
        HocSinhID = hocSinhID;
        HocKyID = hocKyID;
        MonHocID = monHocID;
        TenHeSo = tenHeSo;
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

    public String getTenHeSo() {
        return TenHeSo;
    }

    public void setTenHeSo(String tenHeSo) {
        TenHeSo = tenHeSo;
    }

    public Float getDiem() {
        return Diem;
    }

    public void setDiem(Float diem) {
        Diem = diem;
    }

}
