package DATA;

import DTO.HocSinhDTO;
import DATABASE.MySQLConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QLHS_DAO {
    private MySQLConnect mySQL = new MySQLConnect();

    public ArrayList<HocSinhDTO> list() {
        ArrayList<HocSinhDTO> dshs = new ArrayList<>();
        String sql = "SELECT * FROM hocsinh";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String maHS = rs.getString("HocSinhid");
                String tenHS = rs.getString("HoVaTen");
                String gioiTinh = rs.getString("GioiTinh");
                String namSinh = rs.getString("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String dienThoai = rs.getString("DienThoai");
                String hocphi = rs.getString("HocPhi");
                String IMG = rs.getString("IMG");

                HocSinhDTO hs = new HocSinhDTO(maHS, tenHS, gioiTinh, namSinh, diaChi, dienThoai);
                hs.setHocPhi(hocphi);
                hs.setIMG(IMG);
                dshs.add(hs);
            }
        } catch (SQLException e) {
            System.err.println("Loi o qlhs-dao");
            e.printStackTrace();
        }
        return dshs;
    }

    public void Update(HocSinhDTO hs) {
        MySQLConnect mysql = new MySQLConnect();
        String sql = "UPDATE hocsinh SET ";
        sql += "HocSinhid = '" + hs.getHocSinhID() + "' ,";
        sql += "HoVaTen = '" + hs.getTenHocSinh() + "' ,";
        sql += "GioiTinh = '" + hs.getGioiTinh() + "' ,";
        sql += "NgaySinh = '" + hs.getNgaySinh() + "' ,";
        sql += "DiaChi = '" + hs.getDiaChi() + "' ,";
        sql += "DienThoai = '" + hs.getDienThoai() + "' ,";
        sql += "HocPhi = '" + hs.getHocPhi() + "' ,";
        sql += "IMG = '" + hs.getIMG() + "' ";
        sql += "WHERE HocSinhid='" + hs.getHocSinhID() + "'";
        mysql.executeUpdate(sql);
        System.out.println(sql); // Đoạn này để kiểm tra xem câu lệnh SQL có đúng không
    }

    public void Add(HocSinhDTO hs) {
        MySQLConnect mysql = new MySQLConnect();
        String sql = "INSERT INTO hocsinh VALUE (";
        sql += "'" + hs.getHocSinhID() + "' ,";
        sql += "'" + hs.getTenHocSinh() + "' ,";
        sql += "'" + hs.getGioiTinh() + "' ,";
        sql += "'" + hs.getNgaySinh() + "' ,";
        sql += "'" + hs.getDienThoai() + "' ,";
        sql += "'" + hs.getDiaChi() + "' ,";
        sql += "'" + hs.getHocPhi() + "' ,";
        sql += "'" + hs.getIMG() + "' )";
        mysql.executeUpdate(sql);
    }

    public void delete(String mahs) {
        String sql = "DELETE FROM hocsinh WHERE HocSinhid='" + mahs + "'";
        mySQL.executeUpdate(sql);
        System.out.println(sql);
    }

}
