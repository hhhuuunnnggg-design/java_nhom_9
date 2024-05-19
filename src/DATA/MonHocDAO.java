
package DATA;

import DTO.MonHocDTO;
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
public class MonHocDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public MonHocDAO(){}
    
    public ArrayList <MonHocDTO> list(){
        ArrayList <MonHocDTO> ds=new ArrayList<>();
        try{
            String sql="select * from monhoc";
            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id= rs.getString("MonHocid");
                String idlop=rs.getString("TenMonHoc");
                
                MonHocDTO ml=new MonHocDTO(id,idlop);
                ds.add(ml);
            }
            rs.close();
            mySQL.disConnect();
        }catch(SQLException ex){
            Logger.getLogger(MonHocDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public void set(MonHocDTO ml) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE monhoc SET ";
            sql += "MonHocid='"+ml.getMonHocID()+"', ";
            
            sql += "TenMonHoc='"+ml.getTenMonHoc()+"', ";

            sql += " WHERE MonHocid='"+ml.getMonHocID()+"'";
            System.out.println(sql);
            
            mySQL.executeUpdate(sql);
    }
   public void  add(MonHocDTO mh){
    MySQLConnect mysql = new MySQLConnect();
    String sql = "INSERT INTO monhoc VALUES (";
        sql += "'"+mh.getMonHocID()+"',";
        sql += "'"+mh.getTenMonHoc()+"')";
        System.out.println(sql);
        mySQL.executeUpdate(sql);
   }
  
    public void delete(String id)
    {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "DELETE monhoc WHERE MonHocid ='"+id+"'";
        mySQL.executeUpdate(sql);
        System.out.println(sql);
    }
    public void Update(MonHocDTO mh) {
        MySQLConnect mysql = new MySQLConnect();
        String sql = "UPDATE monhoc SET ";
        sql += "MonHocid  = '" + mh.getMonHocID() + "' ,";
        sql += "TenMonHoc = '" + mh.getTenMonHoc() + "' ,";
        sql += "WHERE HocSinhid='" + mh.getMonHocID() + "'";
        mysql.executeUpdate(sql);
        System.out.println(sql); // Đoạn này để kiểm tra xem câu lệnh SQL có đúng không
    }

    public ArrayList<MonHocDTO> checkMaMH() {
        ArrayList<MonHocDTO> dsmh = new ArrayList<>();

        String sql = "SELECT MonHocid  FROM monhoc";
        ResultSet rs = mySQL.executeQuery(sql);
        try {
            while (rs.next()) {
                String mamh = rs.getString("MonHocid");
                MonHocDTO monhoc = new MonHocDTO(mamh, "");            
                dsmh.add(monhoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsmh;
    }
}
