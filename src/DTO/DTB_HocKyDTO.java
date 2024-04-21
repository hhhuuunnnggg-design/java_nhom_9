package DTO;

public class DTB_HocKyDTO {
    private String HocSinhID;
    private String HocKyID;
    private String DiemTrungBinh;

    public DTB_HocKyDTO(String hocSinhID, String hocKyID, String diemTrungBinh) {
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

    public String getDiemTrungBinh() {
        return DiemTrungBinh;
    }

    public void setDiemTrungBinh(String diemTrungBinh) {
        DiemTrungBinh = diemTrungBinh;
    }

}
