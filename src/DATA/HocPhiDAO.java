package DATA;


import DTO.HocPhiDTO;
import DATABASE.MySQLConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HocPhiDAO {
    private MySQLConnect mySQL = new MySQLConnect();

    public ArrayList<HocPhiDTO> list() {
        ArrayList<HocPhiDTO> dsHocPhi = new ArrayList<>();
        String sql = "SELECT idhs, idnh, thoigian, status FROM hocphi";

        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HocPhiDTO hocPhi = new HocPhiDTO();
                hocPhi.setIdhs(rs.getInt("idhs"));
                hocPhi.setIdnh(rs.getInt("idnh"));
                hocPhi.setThoigian(rs.getString("thoigian"));
                hocPhi.setStatus(rs.getString("status"));
                dsHocPhi.add(hocPhi);
            }
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.list()");
            e.printStackTrace();
        }
        return dsHocPhi;
    }

    public void set(HocPhiDTO hocPhi) {
        String sql = "UPDATE hocphi SET thoigian = ?, status = ? WHERE idhs = ?";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql)) {
            ps.setString(1, hocPhi.getThoigian());
            ps.setString(2, hocPhi.getStatus());
            ps.setInt(3, hocPhi.getIdhs());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.set()");
            e.printStackTrace();
        }
    }

    public void add(HocPhiDTO hocPhi) {
        String sql = "INSERT INTO hocphi (idhs, idnh, thoigian, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql)) {
            ps.setInt(1, hocPhi.getIdhs());
            ps.setInt(2, hocPhi.getIdnh());
            ps.setString(3, hocPhi.getThoigian());
            ps.setString(4, hocPhi.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.add()");
            e.printStackTrace();
        }
    }

    public void delete(int idhs) {
        String sql = "DELETE FROM hocphi WHERE idhs = ?";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idhs);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.delete()");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HocPhiDAO hocPhiDAO = new HocPhiDAO();
        ArrayList<HocPhiDTO> dsHocPhi = hocPhiDAO.list();

        for (HocPhiDTO hocPhi : dsHocPhi) {
            System.out.println("ID Học Sinh: " + hocPhi.getIdhs());
            System.out.println("ID Năm Học: " + hocPhi.getIdnh());
            System.out.println("Thời gian: " + hocPhi.getThoigian());
            System.out.println("Trạng thái: " + hocPhi.getStatus());
            System.out.println();
        }
    }
}
