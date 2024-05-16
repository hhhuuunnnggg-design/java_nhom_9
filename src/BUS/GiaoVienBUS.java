package BUS;

import DATA.GiaoVienDAO;
import DTO.GiaoVienDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GiaoVienBUS {
   private ArrayList<GiaoVienDTO> dsgv ;
    public GiaoVienBUS()
    {
       
    }
    public void listGV()
    {
        GiaoVienDAO gvDAO = new GiaoVienDAO();
        dsgv = new ArrayList<>();
        dsgv = gvDAO.list();
    }

    public void addGV(GiaoVienDTO gv)
    {
        dsgv.add(gv);
        GiaoVienDAO gvDAO = new GiaoVienDAO();
       gvDAO.add(gv);
    }

    public void deleteGV(String idGV)
    {
        for(GiaoVienDTO gv : dsgv )
        {
            if(gv.getMaGV().equals(idGV))
            {
                dsgv.remove(gv);
                GiaoVienDAO gvDAO = new GiaoVienDAO();
                gvDAO.delete(idGV);
                return;
            }
        }
    }
    // public void setGV(GiaoVienDTO s)
    // {
    //     for(int i = 0 ; i < dsgv.size() ; i++)
    //     {
    //         if(dsgv.get(i).getMaGV().equals(s.getMaGV()))
    //         {
    //             dsgv.set(i, s);
    //             GiaoVienDAO gvDAO = new GiaoVienDAO();
    //             gvDAO.set(s);
    //             return;
    //         }
    //     }
    // }
    public boolean checkMagv(String magv)
    {
        GiaoVienDAO gvDao = new GiaoVienDAO();
        dsgv = new ArrayList<>();
        dsgv = gvDao.checkMagv();
        for (GiaoVienDTO gv : dsgv) {
            System.out.println(gv.getMaGV());
            if (gv.getMaGV().equals(magv)) {
                return true;
            }
        }
        return false;
    }
    public GiaoVienDTO getGV(String magv)
    {
        for(GiaoVienDTO gv : dsgv)
        {
            if(gv.getMaGV().equals(magv))
            {
                return gv;
            }
        }
        return null;
    }
    //----chu y-----
    
    public ArrayList<GiaoVienDTO> searchGV(String magv,String tengv)
    {
        ArrayList<GiaoVienDTO> search = new ArrayList<>();
        magv = magv.isEmpty()?magv = "": magv;
        tengv = tengv.isEmpty()?tengv = "": tengv;
        for(GiaoVienDTO gv : dsgv)
        {
            if( gv.getMaGV().contains(magv) && 
                gv.getTenGV().contains(tengv) )
               
            {
                search.add(gv);
           }
        }
        return search;
    }
   

    public ArrayList<GiaoVienDTO> getList() {
        return dsgv;
    }
    
    public void ImportExcelDatabase(File file){
        GiaoVienDAO gvDAO = new GiaoVienDAO();
        gvDAO.ImportExcelDatabase(file);
    }
    public Integer CountGV() {
        GiaoVienDAO gv = new GiaoVienDAO();
        Integer count = gv.CountGV();
        return count;
    }
    public void updateGV(GiaoVienDTO s) {
        for (int i = 0; i < dsgv.size(); i++) {
            if (dsgv.get(i).getMaGV().equals(s.getMaGV())) {
                dsgv.set(i, s);
                GiaoVienDAO gvDAO = new GiaoVienDAO();
                gvDAO.Update(s);
                return;
            }
        }
    }
}
