package DTO;

public class HocSinhDTO {

    private String HocSinhID;
    private String TenHocSinh;
    private String GioiTinh;
    private String NgaySinh;
    private String DiaChi;
    private Integer DienThoai;
    private String HocPhi;
    private String IMG;

    public HocSinhDTO(String hocSinhID, String tenHocSinh, String gioiTinh, String ngaySinh, String diaChi,
            Integer dienThoai, String hocPhi, String iMG) {
        HocSinhID = hocSinhID;
        TenHocSinh = tenHocSinh;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        DienThoai = dienThoai;
        HocPhi = hocPhi;
        IMG = iMG;
    }

    public String getHocSinhID() {
        return HocSinhID;
    }

    public void setHocSinhID(String hocSinhID) {
        HocSinhID = hocSinhID;
    }

    public String getTenHocSinh() {
        return TenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        TenHocSinh = tenHocSinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public Integer getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(Integer dienThoai) {
        DienThoai = dienThoai;
    }

    public String getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(String hocPhi) {
        HocPhi = hocPhi;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String iMG) {
        IMG = iMG;
    }

}
