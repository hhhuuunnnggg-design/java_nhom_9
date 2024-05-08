package DATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DATABASE.MySQLConnect;
import DTO.DTB_HocKyDTO;

public class DTB_HocKyDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public DTB_HocKyDAO(){}
    
    public ArrayList <DTB_HocKyDTO> list(){
        ArrayList <DTB_HocKyDTO> ds=new ArrayList();
        try{
            String sql="select * from diemtbhocky";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id= rs.getString(1);
                String idhk=rs.getString(2);
                Float dtb= rs.getFloat(3);


                DTB_HocKyDTO ctd=new DTB_HocKyDTO(id,idhk,dtb);
                ds.add(ctd);
            }
            rs.close();
            mySQL.disConnect();
        }catch(SQLException ex){
            Logger.getLogger(DTB_HocKyDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public void set(DTB_HocKyDTO ctd) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE diemtbhocky SET ";
            sql += "HocSinhid='"+ctd.getHocSinhID()+"', ";
            
            sql += "HocKyid='"+ctd.getHocKyID()+"', ";
            sql += "MonHocid='"+ctd.getDiemTrungBinh()+"', ";

            sql += " WHERE HocSinhid='"+ctd.getHocSinhID()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }
    
    public void add(DTB_HocKyDTO ctd) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO diemtbhocky VALUES (";
                sql += "'"+ctd.getHocSinhID()+"',";
                sql += "'"+ctd.getHocKyID()+"',";
                sql += "'"+ctd.getDiemTrungBinh()+"')";

         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void delete(DTB_HocKyDTO ctd){
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "update diemtbhocky set Diem = NULL where HocSinhid = '"+ctd.getHocSinhID()+"'";
        mySQL.executeUpdate(sql);
            
    }
}
