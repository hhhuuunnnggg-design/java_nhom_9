package DTO;

public class GiaoVienDTO {
   private String maGV, HoGV, TenGV,GioiTinh,IMG;
   private String NamSinh,DienThoai;

    public GiaoVienDTO(String maGV, String tenGV, String gioiTinh, String iMG, String namSinh, String dienThoai) {
    this.maGV = maGV;
    TenGV = tenGV;
    GioiTinh = gioiTinh;
    IMG = iMG;
    NamSinh = namSinh;
    DienThoai = dienThoai;
}
    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHoGV() {
        return HoGV;
    }

    public void setHoGV(String hoGV) {
        HoGV = hoGV;
    }

    public String getTenGV() {
        return TenGV;
    }

    public void setTenGV(String tenGV) {
        TenGV = tenGV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String iMG) {
        IMG = iMG;
    }
    public String getNamSinh() {
        return NamSinh;
    }
    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }
    public String getDienThoai() {
        return DienThoai;
    }
    public void setDienThoai(String dienThoai) {
        DienThoai = dienThoai;
    }

    // public void setLocationRelativeTo(Object object) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'setLocationRelativeTo'");
    // }

}
