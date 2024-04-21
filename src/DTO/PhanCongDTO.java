package DTO;
public class PhanCongDTO {
    private String GiaoVienID;
    private String MonHocID;
    private String LopID;

    public PhanCongDTO(String giaoVienID, String monHocID, String lopID) {
        GiaoVienID = giaoVienID;
        MonHocID = monHocID;
        LopID = lopID;
    }

    public String getGiaoVienID() {
        return GiaoVienID;
    }

    public void setGiaoVienID(String giaoVienID) {
        GiaoVienID = giaoVienID;
    }

    public String getMonHocID() {
        return MonHocID;
    }

    public void setMonHocID(String monHocID) {
        MonHocID = monHocID;
    }

    public String getLopID() {
        return LopID;
    }

    public void setLopID(String lopID) {
        LopID = lopID;
    }

}