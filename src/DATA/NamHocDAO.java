package DATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DATABASE.MySQLConnect;
import DTO.NamHocDTO;

public class NamHocDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public NamHocDAO(){}
   
    public ArrayList <NamHocDTO> list(){
        ArrayList <NamHocDTO> dsNH=new ArrayList<>();
        try{
            String sql="select * from namhoc";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id= rs.getString(1);
                int bd=rs.getInt(2);
                int kt= rs.getInt(3);

                NamHocDTO ctd=new NamHocDTO(id,bd, kt);
                dsNH.add(ctd);
            }
            rs.close();
            mySQL.disConnect();
        }catch(SQLException ex){
            Logger.getLogger(NamHocDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNH;
    }
    
    public void set(NamHocDTO ctd) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE namhoc SET ";
            sql += "NamHocid='"+ctd.getNamHocID()+"', ";
            sql += "HocKyid='"+ctd.getNamHocBatDau()+"', ";
            sql += "MonHocid='"+ctd.getNamHocKetThuc()+"', ";
            sql += " WHERE NamHocid='"+ctd.getNamHocID()+"'";
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }
    
    public void add(NamHocDTO nh) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO namhoc VALUES (";
                sql += "'"+nh.getNamHocID()+"',";
                sql += "'"+nh.getNamHocBatDau()+"',";
                sql += "'"+nh.getNamHocKetThuc()+"',";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }

    public void delete(String id){
        MySQLConnect mySQL=new MySQLConnect();
        String sql = "DELETE namhoc WHERE NamHocid ='"+id+"'";
        mySQL.executeQuery(sql);
        System.out.println(sql);
    }
    //SQL thêm
    public void Add(NamHocDTO nh) {
        MySQLConnect mysql = new MySQLConnect();
        String sql = "INSERT INTO namhoc VALUE (";
        sql += "'" + nh.getNamHocID() + "' ,";
        sql += "'" + nh.getNamHocBatDau() + "' ,";
        sql += "'" + nh.getNamHocKetThuc() + "' ,";
        mysql.executeUpdate(sql);
    }
    //sql cập nhật
    public void Update(NamHocDTO nh) {
        MySQLConnect mysql = new MySQLConnect();
        String sql = "UPDATE namhoc SET ";
        sql += "NamBatDau = '" + nh.getNamHocID() + "' ,";
        sql += "NamKetThuc = '" + nh.getNamHocBatDau() + "' ,";  
        sql += "WHERE NamHocid ='" + nh.getNamHocKetThuc() + "'";
        mysql.executeUpdate(sql);
        System.out.println(sql); // Đoạn này để kiểm tra xem câu lệnh SQL có đúng không
    }
     public ArrayList<NamHocDTO> checkMaNH() {
        ArrayList<NamHocDTO> dsnh = new ArrayList<>();

        String sql = "SELECT NamHocid  FROM namhoc";
        ResultSet rs = mySQL.executeQuery(sql);
        try {
            while (rs.next()) {
                String manh = rs.getString("NamHocid ");

                NamHocDTO hocsinh = new NamHocDTO(manh, 0, 0);
                dsnh.add(hocsinh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnh;
    }
}
