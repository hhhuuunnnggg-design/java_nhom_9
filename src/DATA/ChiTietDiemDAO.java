
package DATA;

import DTO.ChiTietDiemDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DATABASE.MySQLConnect;

/**
 *
 * @author PHUONG ANH
 */
public class ChiTietDiemDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public ChiTietDiemDAO(){}
    
    public ArrayList <ChiTietDiemDTO> list(){
        ArrayList <ChiTietDiemDTO> ds=new ArrayList<>();
        try{
            String sql="select * from chitietdiem";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id= rs.getString(1);
                String idmh=rs.getString(2);
                String idhk= rs.getString(3);
                int idheso= rs.getInt(4);
                String idnam = rs.getString(5);
                Float diem= rs.getFloat(6);

                ChiTietDiemDTO ctd=new ChiTietDiemDTO(id,idmh,idhk, idheso,idnam,diem);
                ds.add(ctd);
            }
            rs.close();
            mySQL.disConnect();
        }catch(SQLException ex){
            Logger.getLogger(ChiTietDiemDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public void set(ChiTietDiemDTO ctd) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE chitietdiem SET ";
            sql += "HocSinhid='"+ctd.getHocSinhID()+"', ";
            
            sql += "MonHocid='"+ctd.getMonHocID()+"', ";
            sql += "HocKyid='"+ctd.getHocKyID()+"', ";
            sql += "HeSoid='"+ctd.getHeSoID()+"', ";
            sql += "NamHocid='"+ctd.getNamHocID()+"', ";
            sql += "MonHocid='"+ctd.getDiem()+"', ";

            sql += " WHERE HocSinhid='"+ctd.getHocSinhID()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }
    
    public void add(ChiTietDiemDTO ctd) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO chitietdiem VALUES (";
                sql += "'"+ctd.getHocSinhID()+"',";
                sql += "'"+ctd.getMonHocID()+"',";
                sql += "'"+ctd.getHocKyID()+"',";
                sql += "'"+ctd.getHeSoID()+"',";
                sql += "'"+ctd.getNamHocID()+"',";
                sql += "'"+ctd.getDiem()+"')";

         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void delete(String hsID){
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "update chitietdiem set Diem = NULL where HocSinhid = '"+hsID+"'";
        mySQL.executeUpdate(sql);
            
    }
}
