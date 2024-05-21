package DATA;

import DTO.HocPhiDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DATABASE.MySQLConnect;

public class HocPhiDAO {
    private MySQLConnect mySQL = new MySQLConnect();

    // Method to fetch all HocPhiDTO objects from the database
    public ArrayList<HocPhiDTO> list() {
        ArrayList<HocPhiDTO> dsHocPhi = new ArrayList<>();
        String sql = "SELECT idhs, idnh, thoigian, status FROM hocphi";

        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HocPhiDTO hocPhi = new HocPhiDTO();
                hocPhi.setIdhs(rs.getString("idhs"));
                hocPhi.setIdnh(rs.getString("idnh"));
                hocPhi.setThoigian(rs.getString("thoigian"));
                hocPhi.setStatus(rs.getInt("status"));
                dsHocPhi.add(hocPhi);
            }
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.list()");
            e.printStackTrace();
        }
        return dsHocPhi;
    }

    // Method to update a HocPhiDTO object in the database
    public void set(HocPhiDTO hocPhi) {
        String sql = "UPDATE hocphi SET thoigian = ?, status = ? WHERE idhs = ?";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql)) {
            ps.setString(1, hocPhi.getThoigian());
            ps.setInt(2, hocPhi.getStatus());
            ps.setString(3, hocPhi.getIdhs());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.set()");
            e.printStackTrace();
        }
    }

    // Method to insert a new HocPhiDTO object into the database
    public void add(HocPhiDTO hocPhi) {
        String sql = "INSERT INTO hocphi (idhs, idnh, thoigian, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql)) {
            ps.setString(1, hocPhi.getIdhs());
            ps.setString(2, hocPhi.getIdnh());
            ps.setString(3, hocPhi.getThoigian());
            ps.setInt(4, hocPhi.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.add()");
            e.printStackTrace();
        }
    }

    // Method to delete a HocPhiDTO object from the database
    public void delete(String idhs) {
        String sql = "DELETE FROM hocphi WHERE idhs = ?";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql)) {
            ps.setString(1, idhs);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in HocPhiDAO.delete()");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // Create an instance of HocPhiDAO
        HocPhiDAO hocPhiDAO = new HocPhiDAO();

        // Fetch all HocPhiDTO objects from the database
        ArrayList<HocPhiDTO> hocPhiList = hocPhiDAO.list();

        // Print the fetched HocPhiDTO objects
        for (HocPhiDTO hocPhiDTO : hocPhiList) {
            System.out.println("ID Học Sinh: " + hocPhiDTO.getIdhs());
            System.out.println("ID Năm Học: " + hocPhiDTO.getIdnh());
            System.out.println("Thời gian: " + hocPhiDTO.getThoigian());
            System.out.println("Trạng thái: " + hocPhiDTO.getStatus());
            System.out.println();
        }
    }
}
