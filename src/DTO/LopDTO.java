package DTO;
public class LopDTO {
    private String LopID;
    private String TenLop;
    private Integer SiSo;

    public LopDTO(String lopID, String tenLop, Integer siSo) {
        LopID = lopID;
        TenLop = tenLop;
        SiSo = siSo;
    }

    public String getLopID() {
        return LopID;
    }

    public void setLopID(String lopID) {
        LopID = lopID;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public Integer getSiSo() {
        return SiSo;
    }

    public void setSiSo(Integer siSo) {
        SiSo = siSo;
    }

}
