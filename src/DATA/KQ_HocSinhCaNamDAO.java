package DATA;
import DTO.KQ_HocSinhCaNamDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DATABASE.MySQLConnect;

public class KQ_HocSinhCaNamDAO {
    private MySQLConnect mySQL=new MySQLConnect();

    public KQ_HocSinhCaNamDAO(){

    }

    public ArrayList <KQ_HocSinhCaNamDTO> list(){
        ArrayList <KQ_HocSinhCaNamDTO> ds = new ArrayList<>();
        try{
            String sql = "select * from kqhocsinhcanam";

            ResultSet rs=mySQL.executeQuery(sql);
            
            while(rs.next()){
                String id = rs.getString(1);
                String namhocid = rs.getString(2);
                String hocluc = rs.getString(3);
                String hanhkiem = rs.getString(4);
                Float diemtb = rs.getFloat(5);
                String kq = rs.getString(6);

                KQ_HocSinhCaNamDTO k = new KQ_HocSinhCaNamDTO(id, namhocid, hocluc, hanhkiem, diemtb, kq);
                ds.add(k);
            }
            rs.close();
            mySQL.disConnect();

        }catch(SQLException e){
            Logger.getLogger(KQ_HocSinhCaNamDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ds;
    }

    public void set(KQ_HocSinhCaNamDTO kqHS) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "UPDATE kqhocsinhcanam SET ";
        sql += "HocSinhid='"+kqHS.getHocSinhID()+"', ";
        sql += "NamHocid='"+kqHS.getNamHocID()+"', ";
        sql += "HocLuc='"+kqHS.getHocLuc()+"', ";
        sql += "HanhKiem='"+kqHS.getHanhKiem()+"', ";
        sql += "Diemtb='"+kqHS.getDiemTrungBinhNam()+"', ";
        sql += "KetQua='"+kqHS.getKetQua()+"', ";
        sql += " where HocSinhid='"+kqHS.getHocSinhID()+"'";
        System.out.println(sql);
        
        mySQL.executeUpdate(sql);
}

    public void add(KQ_HocSinhCaNamDTO kqHS) {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "INSERT INTO kqhocsinhcanam VALUES (";
                sql += "'"+kqHS.getHocSinhID()+"',";
                sql += "'"+kqHS.getNamHocID()+"',";
                sql += "'"+kqHS.getHocLuc()+"',";
                sql += "'"+kqHS.getHanhKiem()+"',";
                sql += "'"+kqHS.getDiemTrungBinhNam()+"',";
                sql += "'"+kqHS.getKetQua()+"')";

        System.out.println(sql);
        mySQL.executeUpdate(sql);
    }

    public void delete(String id)
    {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "UPDATE kqhocsinhcanam SET enable = 0 WHERE HocSinhid='"+id+"'";
        mySQL.executeUpdate(sql);
        System.out.println(sql);
    }

}


