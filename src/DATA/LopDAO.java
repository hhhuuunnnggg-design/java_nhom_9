/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import DTO.LopDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHUONG ANH
 */
public class LopDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public LopDAO(){}
    
    public ArrayList <LopDTO> list(){
        ArrayList <LopDTO> ds=new ArrayList();
        try{
            String sql="select * from lop";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                
                String id=rs.getString("Lopid");
                String ten=rs.getString("TenLop");
                
                LopDTO lop=new LopDTO(id,ten);
                ds.add(lop);
            }
            rs.close();
            mySQL.disConnect();
        }catch(SQLException ex){
            Logger.getLogger(LopDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
        public void set(LopDTO lop) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE hocsinh SET ";
            sql += "Lopid='"+lop.getLopID()+"', ";
            sql += "TenLop='"+lop.getTenLop()+"', ";

            sql += " WHERE Lopid='"+lop.getTenLop()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }
    
    public void add(LopDTO lop) {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO nhanvien VALUES (";
                sql += "'"+lop.getLopID()+"',";
                sql += "'"+lop.getTenLop()+"',";

         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
    
    public void delete(LopDTO lop){
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "";
        
            //xoa phancong
            sql = "delete phancong where Lopid ='"+lop.getLopID()+"'";
            mySQL.executeUpdate(sql);

            //xoa phanlop
            sql = "delete phanlop where Lopid ='"+lop.getLopID()+"'";
            mySQL.executeUpdate(sql);
            
            //xoa lop
            sql = "delete lop where Lopid ='"+lop.getLopID()+"'";
            mySQL.executeUpdate(sql);
    }
    public static void main(String[] args) {
    LopDAO lopDAO = new LopDAO();
    ArrayList<LopDTO> lopList = lopDAO.list();
    
    // Print the data of each LopDTO object in the list
    for (LopDTO lop : lopList) {
        System.out.println("LopID: " + lop.getLopID());
        System.out.println("TenLop: " + lop.getTenLop());
        System.out.println(); // for readability
    }
}

}
