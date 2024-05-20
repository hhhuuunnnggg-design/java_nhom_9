package DATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DATABASE.MySQLConnect;
import DTO.chucnangDTO;
import DTO.phanquyenDTO;

public class phanquyenDAO {
    MySQLConnect mysql = new MySQLConnect();

    public ArrayList<phanquyenDTO> listQuyen() {
        ArrayList<phanquyenDTO> dsquyen = new ArrayList<>();
        String sql = "SELECT * FROM quyen WHERE enable = 1"; // Chỉnh sửa câu truy vấn SQL

        try {
            ResultSet rs = mysql.executeQuery(sql); // Thực thi truy vấn và nhận kết quả

            // Duyệt qua kết quả và thêm vào danh sách quyền
            while (rs.next()) {
                String maQuyen = rs.getString("maquyen");
                String tenQuyen = rs.getString("tenquyen");
                phanquyenDTO quyen = new phanquyenDTO(maQuyen, tenQuyen);
                dsquyen.add(quyen);
            }

            rs.close(); // Đóng ResultSet sau khi sử dụng
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsquyen;
    }

    public ArrayList<chucnangDTO> listChucNang() {
        ArrayList<chucnangDTO> dsquyen = new ArrayList<>();
        String sql = "SELECT * FROM chucnang WHERE  1"; // Chỉnh sửa câu truy vấn SQL

        try {
            ResultSet rs = mysql.executeQuery(sql); // Thực thi truy vấn và nhận kết quả

            // Duyệt qua kết quả và thêm vào danh sách quyền
            while (rs.next()) {
                String machucnang = rs.getString("machucnang");
                String tenchucnang = rs.getString("tenchucnang");
                chucnangDTO cn = new chucnangDTO(machucnang, tenchucnang);
                dsquyen.add(cn);
            }

            rs.close(); // Đóng ResultSet sau khi sử dụng
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsquyen;
    }

}
