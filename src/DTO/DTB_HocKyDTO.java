package DTO;

public class DTB_HocKyDTO {
    private String HocSinhID;
    private String HocKyID;
    private Float DiemTrungBinh;

    public DTB_HocKyDTO(String hocSinhID, String hocKyID, Float diemTrungBinh) {
        HocSinhID = hocSinhID;
        HocKyID = hocKyID;
        DiemTrungBinh = diemTrungBinh;
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

    public Float getDiemTrungBinh() {
        return DiemTrungBinh;
    }

    public void setDiemTrungBinh(Float diemTrungBinh) {
        DiemTrungBinh = diemTrungBinh;
    }


}
