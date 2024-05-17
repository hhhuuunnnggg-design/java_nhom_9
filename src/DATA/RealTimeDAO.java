package DATA;

import DATABASE.MySQLConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RealTimeDAO {
    private MySQLConnect mySQL = new MySQLConnect();

    public RealTimeDAO() {
    }

    public String getRealtime() {
        String currentTime = "";
        String sql = "SELECT NOW() AS current_time";
        try (PreparedStatement ps = mySQL.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                currentTime = rs.getString("current_time");
            }
        } catch (SQLException e) {
            System.err.println("Error in NamHienTaiDAO.getRealtime()");
            e.printStackTrace();
        }
        return currentTime;
    }

    public static void main(String[] args) {
        RealTimeDAO namHienTaiDAO = new RealTimeDAO();
        String currentDateTime = namHienTaiDAO.getRealtime();
        System.out.println("Current Date and Time: " + currentDateTime);
    }
}
