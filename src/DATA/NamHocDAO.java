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
        ArrayList <NamHocDTO> ds=new ArrayList<>();
        try{
            String sql="select * from namhoc";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id= rs.getString(1);
                int bd=rs.getInt(2);
                int kt= rs.getInt(3);

                NamHocDTO ctd=new NamHocDTO(id,bd, kt);
                ds.add(ctd);
            }
            rs.close();
            mySQL.disConnect();
        }catch(SQLException ex){
            Logger.getLogger(NamHocDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
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
    
    public void add(NamHocDTO ctd) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO namhoc VALUES (";
                sql += "'"+ctd.getNamHocID()+"',";
                sql += "'"+ctd.getNamHocBatDau()+"',";
                sql += "'"+ctd.getNamHocKetThuc()+"',";

         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }

}
