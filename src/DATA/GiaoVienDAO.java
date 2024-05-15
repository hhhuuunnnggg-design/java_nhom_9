package DATA;

import DTO.GiaoVienDTO;
import DATABASE.MySQLConnect;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
public class GiaoVienDAO {
    private MySQLConnect mySQL = new MySQLConnect();

    public GiaoVienDAO() {
    }

    public ArrayList<GiaoVienDTO> list() {
        ArrayList<GiaoVienDTO> dsgv = new ArrayList<>();
        try {
            String sql = "SELECT * FROM giaovien WHERE enable = 1";
            ResultSet rs = mySQL.executeQuery(sql);

            while (rs.next()) {
                String maGV = rs.getString(1);
                String tenGV = rs.getString(2);
                String gioiTinh = rs.getString(3);
                String namSinh = rs.getString(4);
                String dienThoai = rs.getString(6);
                String IMG = rs.getString(7);

                GiaoVienDTO gv = new GiaoVienDTO(maGV, tenGV, gioiTinh, IMG, namSinh, dienThoai);
                dsgv.add(gv);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.disConnect();
        }
        return dsgv;
    }

    public void set(GiaoVienDTO gv) {
        try {
            String sql = "UPDATE giaovien SET " +
                         "GiaoVienid='" + gv.getMaGV() + "', " +
                         "TenGiaoVien='" + gv.getTenGV() + "', " +
                         "GioiTinh='" + gv.getGioiTinh() + "', " +
                         "NamSinh='" + gv.getNamSinh() + "', " +
                         "DienThoai='" + gv.getDienThoai() + "', " +
                         "IMG='" + gv.getIMG() + "' " +
                         "WHERE GiaoVienid='" + gv.getMaGV() + "'";
            mySQL.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.disConnect();
        }
    }

    public void add(GiaoVienDTO gv) {
        try {
            String sql = "INSERT INTO giaovien (GiaoVienid, TenGiaoVien, GioiTinh, NamSinh, DienThoai, IMG, enable) VALUES (" +
                         "'" + gv.getMaGV() + "'," +
                         "'" + gv.getTenGV() + "'," +
                         "'" + gv.getGioiTinh() + "'," +
                         "'" + gv.getNamSinh() + "'," +
                         "'" + gv.getDienThoai() + "'," +
                         "'" + gv.getIMG() + "'," +
                         "'1')";
            mySQL.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.disConnect();
        }
    }

    public void delete(String MAGV) {
        try {
            String sql = "UPDATE giaovien SET enable = 0 WHERE MAGV='" + MAGV + "'";
            mySQL.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mySQL.disConnect();
        }
    }



    public static void main(String[] args) {
        GiaoVienDAO giaoVienDAO = new GiaoVienDAO();
        ArrayList<GiaoVienDTO> dsgv = giaoVienDAO.list();

        for (GiaoVienDTO gv : dsgv) {
            System.out.println("MAGV: " + gv.getMaGV());
            System.out.println("TENGV: " + gv.getTenGV());
            System.out.println("GIOITINH: " + gv.getGioiTinh());
            System.out.println("NAMSINH: " + gv.getNamSinh());
            System.out.println("DIENTHOAI: " + gv.getDienThoai());
            System.out.println("IMG: " + gv.getIMG());
            System.out.println("-------------------------------");
        }
    }
}


    // public void ExportExcelDatabase(){
    //     try {
    //         String sql="SELECT * FROM giaovien WHERE 1";
    //         ResultSet rs=mySQL.executeQuery(sql);
    //          XSSFWorkbook workbook = new XSSFWorkbook();
    //         XSSFSheet sheet = workbook.createSheet("giaoviendb");
            
                    
    //         XSSFFont font = workbook.createFont();
    //         font.setFontHeightInPoints((short) 12);
    //         font.setBold(true);
        
    //        XSSFCellStyle style = workbook.createCellStyle();
    //         style.setFont(font);
            
    //         XSSFRow row = sheet.createRow(0);
    //         XSSFCell cell;

    //         cell = row.createCell(0);
    //         cell.setCellValue("MAGV");
    //         cell.setCellStyle(style);
    //         cell = row.createCell(1);
    //         cell.setCellValue("HOGV");
    //         cell.setCellStyle(style);
    //         cell = row.createCell(2);
    //         cell.setCellValue("TENGV");
    //         cell.setCellStyle(style);
    //         cell = row.createCell(3);
    //         cell.setCellValue("GIOITINH");
    //         cell.setCellStyle(style);
    //         cell = row.createCell(4);
    //         cell.setCellValue("NAMSINH");
    //         cell.setCellStyle(style);
    //         cell = row.createCell(5);
    //         cell.setCellValue("DIENTHOAI");
    //         cell.setCellStyle(style);
    //         cell = row.createCell(6);
    //         cell.setCellValue("IMG");
    //         cell.setCellStyle(style);
    //         int i = 1;

    //         while(rs.next()){
    //         row = sheet.createRow(i);
    //         cell = row.createCell(0);
    //         cell.setCellValue(rs.getString("MAGV"));
    //         cell = row.createCell(1);
    //         cell.setCellValue(rs.getString("HOGV"));
    //         cell = row.createCell(2);
    //         cell.setCellValue(rs.getInt("TENGV"));
    //         cell = row.createCell(3);
    //         cell.setCellValue(rs.getInt("GIOITINH"));
    //         cell = row.createCell(4);
    //         cell.setCellValue(rs.getString("NAMSINH"));
    //         cell = row.createCell(5);
    //         cell.setCellValue(rs.getString("DIENTHOAI"));
    //         cell = row.createCell(6);
    //         cell.setCellValue(rs.getString("IMG"));
            
    //         i++;
    //     }
    //     for(int colNum = 0;colNum < row.getLastCellNum();colNum++) {
    //         sheet.autoSizeColumn((short) (colNum));
    //     }
    //     FileOutputStream out = new FileOutputStream(new File("./report/giaoviendb.xlsx"));
    //     workbook.write(out);
    //     out.close();
    //     System.out.println("Xuat file thanh cong");


    //     } catch (SQLException ex) {
    //         Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     } catch (FileNotFoundException ex) {
    //         Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     } catch (IOException ex) {
    //         Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     }
        
        
    // }

    // public void ImportExcelDatabase(File file){
    //     try{
    //         FileInputStream in = new FileInputStream(file);
    //         XSSFWorkbook workbook = new XSSFWorkbook(in);
    //         XSSFSheet sheet = workbook.getSheetAt(0);
    //         Row row;
    //         for(int i = 1; i <= sheet.getLastRowNum(); i++){
    //             row = sheet.getRow(i);
    //             String maGV = row.getCell(0).getStringCellValue();
    //             String hoGV = row.getCell(1).getStringCellValue();
    //             String tENGV = row.getCell(2).getStringCellValue();
    //             String gioiTinh = row.getCell(3).getStringCellValue();
    //             int namSinh = (int) row.getCell(4).getNumericCellValue();
    //             int dienThoai = (int) row.getCell(5).getNumericCellValue();
    //             String IMG = row.getCell(6).getStringCellValue();
               
    //             String sql_check = "SELECT * FROM giaovien WHERE MaSP='"+maGV+"'";
    //             ResultSet rs = mySQL.executeQuery(sql_check);
    //             if(!rs.next()){
    //                 String sql = "INSERT INTO giaovien VALUES (";
    //                 sql += "'"+maGV+"',";
    //                 sql += "'"+hoGV+"',";
    //                 sql += "'"+tENGV+"',";
    //                 sql += "x'"+gioiTinh+"',";
    //                 sql += "'"+namSinh+"',";
    //                 sql += "'"+dienThoai+"',";
    //                 sql += "'"+IMG+"',";
                    
    //                 System.out.println(sql);
    //                 mySQL.executeUpdate(sql);
    //             }
    //             else{
    //                 String sql = "UPDATE giaovien SET ";
                   
    //                 sql += "SOLUONG='"+hoGV+"', ";
    //                 sql += "GIA='"+tENGV+"', ";
    //                 sql += "DONVITINH='"+gioiTinh+"', ";
    //                 sql += "MALOAI='"+namSinh+"', ";
    //                 sql += "MANSX='"+dienThoai+"', ";
    //                 sql += "IMG='"+IMG+"' ";
    //                 sql += "WHERE maGV='"+maGV+"'";
    //                 System.out.println(sql);    
    //                 mySQL.executeUpdate(sql);
    //             }
    //         }
    //         in.close();
          
    //     } catch (FileNotFoundException ex) {
    //         Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     } catch (IOException | SQLException ex) {
    //         Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    // }

