package DTO;

public class HocPhiDTO {
    private int idhs;
    private int idnh;
    private String thoigian;
    private String status;

    public HocPhiDTO(int idhs, int idnh, String thoigian, String status) {
        this.idhs = idhs;
        this.idnh = idnh;
        this.thoigian = thoigian;
        this.status = status;
    }

    // Getters and setters

    public HocPhiDTO() {
    }

    @Override
    public String toString() {
        return "HocPhiDTO{" +
                "idhs=" + idhs +
                ", idnh=" + idnh +
                ", thoigian='" + thoigian + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getIdhs() {
        return idhs;
    }

    public void setIdhs(int idhs) {
        this.idhs = idhs;
    }

    public int getIdnh() {
        return idnh;
    }

    public void setIdnh(int idnh) {
        this.idnh = idnh;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
