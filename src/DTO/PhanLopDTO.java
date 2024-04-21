package DTO;
public class PhanLopDTO {
    private String HocSinhID;
    private String LopID;

    public PhanLopDTO(String hocSinhID, String lopID) {
        HocSinhID = hocSinhID;
        LopID = lopID;
    }

    public String getHocSinhID() {
        return HocSinhID;
    }

    public void setHocSinhID(String hocSinhID) {
        HocSinhID = hocSinhID;
    }

    public String getLopID() {
        return LopID;
    }

    public void setLopID(String lopID) {
        LopID = lopID;
    }

}
