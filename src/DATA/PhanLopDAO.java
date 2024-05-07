/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import DTO.PhanLopDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHUONG ANH
 */
public class PhanLopDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public PhanLopDAO(){}
    
    public ArrayList <PhanLopDTO> list(){
        ArrayList <PhanLopDTO> ds=new ArrayList();
        try{
            String sql="select * from phanlop";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id= rs.getString("HocSinhid");
                String idlop=rs.getString("Lopid");
                
                PhanLopDTO pl=new PhanLopDTO(id,idlop);
                ds.add(pl);
            }
            rs.close();
            mySQL.disConnect();
        }catch(SQLException ex){
            Logger.getLogger(PhanLopDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public void set(PhanLopDTO pl) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE phanlop SET ";
            sql += "HocSinhid='"+pl.getHocSinhID()+"', ";
            sql += "Lopid='"+pl.getLopID()+"', ";

            sql += " WHERE HocSinhid='"+pl.getHocSinhID()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }
    
    public void add(PhanLopDTO pl) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO phanlop VALUES (";
                sql += "'"+pl.getHocSinhID()+"',";
                sql += "'"+pl.getLopID()+"',";

         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void delete(PhanLopDTO pl){
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "update phanlop set Lopid = NULL where HocSinhid = '"+pl.getHocSinhID()+"'";
        mySQL.executeUpdate(sql);

            
            
    }
}
