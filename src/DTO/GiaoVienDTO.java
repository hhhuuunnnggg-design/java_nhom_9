package DTO;


public class GiaoVienDTO {
   private String maGV, HoGV, TenGV,GioiTinh,IMG;
   private int NamSinh,DienThoai;

    public GiaoVienDTO(String maGV, String hoGV, String tenGV, String gioiTinh, String iMG, int namSinh, int dienThoai) {
    this.maGV = maGV;
    HoGV = hoGV;
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
    public int getNamSinh() {
        return NamSinh;
    }
    public void setNamSinh(int namSinh) {
        NamSinh = namSinh;
    }
    public int getDienThoai() {
        return DienThoai;
    }
    public void setDienThoai(int dienThoai) {
        DienThoai = dienThoai;
    }

    // public void setLocationRelativeTo(Object object) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setLocationRelativeTo'");
    // }

   
}
