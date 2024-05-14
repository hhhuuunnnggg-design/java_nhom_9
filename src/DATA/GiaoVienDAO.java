package DATA;


import DTO.*;
import BUS.*;
import DATABASE.*;
import GUI.*;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


//-------------
import DTO.GiaoVienDTO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//--------------------------
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GiaoVienDAO {
    private  MySQLConnect mySQL = new MySQLConnect(); 
    public GiaoVienDAO() {
    }

    public ArrayList<GiaoVienDTO> list() {
        ArrayList<GiaoVienDTO> dsgv = new ArrayList<>();
        try {
            String sql = "SELECT * FROM giaovien WHERE enable = 1";
            System.out.println("1");
            ResultSet rs = mySQL.executeQuery(sql);
            
            while (rs.next()) {

                String maGV = rs.getString("MAGV");
                String hoGV = rs.getString("HOGV");
                String tenGV = rs.getString("TENGV");
                String gioiTinh = rs.getString("GIOITINH");
                String namSinh = rs.getString("NAMSINH");
                String dienThoai = rs.getString("DIENTHOAI");
                String IMG = rs.getString("IMG");

                GiaoVienDTO gv = new GiaoVienDTO(maGV, hoGV, tenGV, gioiTinh, IMG, namSinh, dienThoai);
                dsgv.add(gv);
            }
            rs.close();
            mySQL.disConnect();
             System.out.println("1.5");
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("lõi");
        }
        return dsgv;
    }



    public void set(GiaoVienDTO gv){
    String sql = "UPDATE giaovien SET ";
    sql += "HOGV='"+gv.getHoGV()+"', ";
    sql += "TENGV='"+gv.getTenGV()+"', ";
    sql += "GIOITINH='"+gv.getGioiTinh()+"', ";
    sql += "NAMSINH='"+gv.getNamSinh()+"', ";
    sql += "DIENTHOAI='"+gv.getDienThoai()+"', ";
    sql += "IMG='"+gv.getIMG()+"' ";
    sql += "WHERE MAGV='"+gv.getMaGV()+"'";
    
    mySQL.executeUpdate(sql);
    System.out.println("2");
    System.out.println(sql);
    
}

    

    // Lấy giá trị thêm
    public void add(GiaoVienDTO gv){
        String sql="INSERT INTO giaovien VALUES (";
                 
                sql+="'"+gv.getMaGV()+"',";
                sql+="'"+gv.getHoGV()+"',";
                sql+="'"+gv.getTenGV()+"',";
                sql+="'"+gv.getGioiTinh()+"',";
                sql+="'"+gv.getNamSinh()+"',";
                sql+="'"+gv.getDienThoai()+"',";
                sql+="'"+gv.getIMG()+"',";
                sql += "'1')";
        System.out.println(sql);
        System.out.println("3");
        mySQL.executeUpdate(sql);

    }

    
    //xóa
    public void delete(String MAGV){
        String sql = "UPDATE FROM giaovien SET enable =0 WHERE maGV='"+MAGV+"'";
        
        System.out.println("4");
        mySQL.executeUpdate(sql);
        System.out.println(sql);
    }   

    public void ExportExcelDatabase(){
        try {
            String sql="SELECT * FROM giaovien WHERE 1";
            ResultSet rs=mySQL.executeQuery(sql);
             XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("giaoviendb");
            
                    
            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
        
           XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue("MAGV");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("HOGV");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("TENGV");
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue("GIOITINH");
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue("NAMSINH");
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue("DIENTHOAI");
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue("IMG");
            cell.setCellStyle(style);
            int i = 1;

            while(rs.next()){
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(rs.getString("MAGV"));
            cell = row.createCell(1);
            cell.setCellValue(rs.getString("HOGV"));
            cell = row.createCell(2);
            cell.setCellValue(rs.getInt("TENGV"));
            cell = row.createCell(3);
            cell.setCellValue(rs.getInt("GIOITINH"));
            cell = row.createCell(4);
            cell.setCellValue(rs.getString("NAMSINH"));
            cell = row.createCell(5);
            cell.setCellValue(rs.getString("DIENTHOAI"));
            cell = row.createCell(6);
            cell.setCellValue(rs.getString("IMG"));
            
            i++;
        }
        for(int colNum = 0;colNum < row.getLastCellNum();colNum++) {
            sheet.autoSizeColumn((short) (colNum));
        }
        FileOutputStream out = new FileOutputStream(new File("./report/giaoviendb.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Xuat file thanh cong");


        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void ImportExcelDatabase(File file){
        try{
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                String maGV = row.getCell(0).getStringCellValue();
                String hoGV = row.getCell(1).getStringCellValue();
                String tENGV = row.getCell(2).getStringCellValue();
                String gioiTinh = row.getCell(3).getStringCellValue();
                int namSinh = (int) row.getCell(4).getNumericCellValue();
                int dienThoai = (int) row.getCell(5).getNumericCellValue();
                String IMG = row.getCell(6).getStringCellValue();
               
                String sql_check = "SELECT * FROM giaovien WHERE MaSP='"+maGV+"'";
                ResultSet rs = mySQL.executeQuery(sql_check);
                if(!rs.next()){
                    String sql = "INSERT INTO giaovien VALUES (";
                    sql += "'"+maGV+"',";
                    sql += "'"+hoGV+"',";
                    sql += "'"+tENGV+"',";
                    sql += "x'"+gioiTinh+"',";
                    sql += "'"+namSinh+"',";
                    sql += "'"+dienThoai+"',";
                    sql += "'"+IMG+"',";
                    
                    System.out.println(sql);
                    mySQL.executeUpdate(sql);
                }
                else{
                    String sql = "UPDATE giaovien SET ";
                   
                    sql += "SOLUONG='"+hoGV+"', ";
                    sql += "GIA='"+tENGV+"', ";
                    sql += "DONVITINH='"+gioiTinh+"', ";
                    sql += "MALOAI='"+namSinh+"', ";
                    sql += "MANSX='"+dienThoai+"', ";
                    sql += "IMG='"+IMG+"' ";
                    sql += "WHERE maGV='"+maGV+"'";
                    System.out.println(sql);    
                    mySQL.executeUpdate(sql);
                }
            }
            in.close();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}