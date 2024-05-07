
package DATA;

import DTO.MonHocDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHUONG ANH
 */
public class MonHocDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public MonHocDAO(){}
    
    public ArrayList <MonHocDTO> list(){
        ArrayList <MonHocDTO> ds=new ArrayList();
        try{
            String sql="select * from MonHoc";
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
    

}
