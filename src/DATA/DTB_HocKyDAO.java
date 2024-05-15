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
        ArrayList <DTB_HocKyDTO> ds=new ArrayList<>();
        try{
            String sql="select * from diemtbhocky";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id= rs.getString(1);
                String idhk=rs.getString(2);
                String idnam = rs.getString(3);
                Float dtb= rs.getFloat(4);

                DTB_HocKyDTO ctd=new DTB_HocKyDTO(id,idhk,idnam,dtb);
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
        sql += "NamHocid='"+ctd.getNamHocID()+"', ";
        
        sql += "DiemTrungBinh='"+ctd.getDiemTrungBinh()+"' ";
    
        // Concatenating multiple conditions in the WHERE clause
        sql += " WHERE HocSinhid='"+ctd.getHocSinhID()+"' AND ";
        sql += "HocKyid='"+ctd.getHocKyID()+"' AND ";
        sql += "NamHocid='"+ctd.getNamHocID()+"'";
        
        System.out.println(sql);
        
        mySQL.executeUpdate(sql);
    }
    
    public void add(DTB_HocKyDTO ctd) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO diemtbhocky VALUES (";
                sql += "'"+ctd.getHocSinhID()+"',";
                sql += "'"+ctd.getHocKyID()+"',";
                sql += "'"+ctd.getNamHocID()+"',";
                sql += "'"+ctd.getDiemTrungBinh()+"')";

         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void delete(String hsID){
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "update diemtbhocky set Diem = NULL where HocSinhid = '"+hsID+"'";
        mySQL.executeUpdate(sql);
            
    }
}
