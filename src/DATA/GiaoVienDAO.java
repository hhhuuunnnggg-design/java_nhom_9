package DATA;

import DTO.GiaoVienDTO;
import DATABASE.MyConnection;
import DATABASE.MySQLConnect;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.SQLException;
public class GiaoVienDAO {
    private  MySQLConnect mySQL = new MySQLConnect();

    public GiaoVienDAO() {
    }
    public ArrayList<GiaoVienDTO> list()
    {
        ArrayList<GiaoVienDTO> gv = new ArrayList<>();
        try {
            String sql = "SELECT * FROM giaovien WHERE enable = 1";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                String maGV = rs.getString("GiaoVienid");
                String tenGV = rs.getString("TenGiaoVien");
                String GioiTinh = rs.getString("GioiTinh");
                String NamSinh= rs.getString("NamSinh");
                String DiaChi = rs.getString("DiaChi");
                String DienThoai = rs.getString("DienThoai");
                String IMG = rs.getString("IMG");
                GiaoVienDTO s = new GiaoVienDTO(maGV, tenGV, GioiTinh, IMG, NamSinh, DienThoai, DiaChi);
                gv.add(s);
            }
            rs.close();
            mySQL.disConnect();

        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gv;
    }
    public void add(GiaoVienDTO gv)
    {
        String sql = "INSERT INTO giaovien VALUES (";
        sql += "'"+gv.getMaGV()+"',";
        sql += "'"+gv.getTenGV()+"',";
        sql += "'"+gv.getGioiTinh()+"',";
        sql += "'"+gv.getNamSinh()+"',";
        sql += "'"+gv.getDiachi()+"',";
        sql += "'"+gv.getDienThoai()+"',";
        sql += "'"+gv.getIMG()+"',";
        sql += "'1')";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    // public void delete(String idGV)
    // {
    //     String sql = "UPDATE giaovien SET enable = 0 WHERE GiaoVienid ='"+idGV+"'";
       
    //     System.out.println(sql);
    //     mySQL.executeUpdate(sql);
    //    System.out.println("delete");
       
    // }
    public void delete(String idGV) {
        String sql = "UPDATE giaovien SET enable = 0 WHERE GiaoVienid = ?";
        java.sql.Connection con = null;
        java.sql.PreparedStatement pstmt = null;

        try {
            // Lấy kết nối từ MyConnection
            con = MyConnection.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, idGV);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và Connection
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            MyConnection.closeConnection(con);
        }
    }
  
    // public void set(GiaoVienDTO gv)
    // {
    //     String sql = "UPDATE giaovien SET ";
    //     sql += "TENGV='"+gv.getTenGV()+"', ";
    //     sql += "GIOITINH='"+gv.getGioiTinh()+"', ";
    //     sql += "NAMSINH='"+gv.getNamSinh()+"', ";
    //     sql += "DIENTHOAI='"+gv.getDienThoai()+"', ";
    //     sql += "IMG='"+gv.getIMG()+"' ";
    //     sql += "WHERE MAGV='"+gv.getMaGV()+"'";
    //     System.out.println(sql);
    //     mySQL.executeUpdate(sql);
    // }
    public void ImportExcelDatabase(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ImportExcelDatabase'");
    }
    // public void Update(GiaoVienDTO gv) {
   //     MySQLConnect mysql = new MySQLConnect();
    //     String sql = "UPDATE giaovien SET ";
    //     // sql += "GiaoVienid  = '" + hs.getHocSinhID() + "' ,";
    //     sql += "TenGiaoVien = '" + gv.getTenGV() + "' ,";
    //     sql += "GioiTinh = '" + gv.getGioiTinh() + "' ,";
    //     sql += "NamSinh	 = '" + gv.getNamSinh() + "' ,";
    //     sql += "DiaChi = '" + gv.getDiachi() + "' ,";
    //     sql += "DienThoai = '" + gv.getDienThoai() + "' ,";
    //     sql += "IMG = '" + gv.getIMG() + "' ";
    //     sql += "WHERE HocSinhid='" +gv.getMaGV() + "'";
    //     mysql.executeUpdate(sql);
    //     System.out.println(sql); // Đoạn này để kiểm tra xem câu lệnh SQL có đúng không
    // }
   public void Update(GiaoVienDTO gv) {
    String sql = "UPDATE giaovien SET TenGiaoVien = ?, GioiTinh = ? , NamSinh = ? , DiaChi = ? , DienThoai = ? , IMG = ? WHERE GiaoVienid = ?";
    java.sql.Connection con = null;
    java.sql.PreparedStatement ps = null;
    
    try {
        con = MyConnection.getConnection();
        if (con != null) {
            ps = con.prepareStatement(sql);
            ps.setString(1, gv.getTenGV());
            ps.setString(2, gv.getGioiTinh());
            ps.setString(3, gv.getNamSinh());
            ps.setString(4, gv.getDiachi());
            ps.setString(5, gv.getDienThoai());
            ps.setString(6, gv.getIMG());
            ps.setString(7, gv.getMaGV());
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully updated NamHocID: " + gv.getMaGV());
            } else {
                System.out.println("No record found with NamHocID: " + gv.getMaGV());
            }
        } else {
            System.out.println("Failed to establish connection.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) MyConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




public Integer CountGV() {
        String sql = "SELECT COUNT(*) AS count FROM giaovien";
        Integer count = 0;

        try {
            ResultSet rs = mySQL.executeQuery(sql);

            if (rs.next()) {
                int numberOfGiaoVien = rs.getInt("count");
                count = numberOfGiaoVien;
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        }

        return count;
    }

public ArrayList<GiaoVienDTO> checkMagv() {
        ArrayList<GiaoVienDTO> dsgv = new ArrayList<>();

        String sql = "SELECT GiaoVienid  FROM giaovien";
        ResultSet rs = mySQL.executeQuery(sql);
        try {
            while (rs.next()) {
                String mahs = rs.getString("GiaoVienid");

                GiaoVienDTO gv = new GiaoVienDTO(mahs, "", "", "", "", "","");
                dsgv.add(gv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsgv;
    }
}
