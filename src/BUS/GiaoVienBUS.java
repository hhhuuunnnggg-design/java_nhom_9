package BUS;


import java.io.File;
import java.util.ArrayList;

import DATA.GiaoVienDAO;
import DTO.*;
import DTO.GiaoVienDTO;

import java.util.ArrayList;


public class GiaoVienBUS {
    private ArrayList<GiaoVienDTO> dsgv;
    public GiaoVienBUS(){}

    public void listGV(){
        GiaoVienDAO gvDAO=new GiaoVienDAO();
    
        dsgv = new ArrayList<>();
        dsgv=gvDAO.list();
    }
    //theem
    public void addGV(GiaoVienDTO gv){
        dsgv.add(gv);
        GiaoVienDAO gvDAO=new GiaoVienDAO();
        gvDAO.add(gv);
    }
    //xoa
    public void deleteGV(String magv){
        for(GiaoVienDTO gv:dsgv){
            if(gv.getMaGV().equals(magv)){
                dsgv.remove(magv);
                GiaoVienDAO gvDAO=new GiaoVienDAO();
                gvDAO.delete(magv);
                return;
            }
        }
    }
    // get/set
    public void setGV(GiaoVienDTO s){
        for(int i=0 ; i<dsgv.size() ; i++){
            if(dsgv.get(i).getMaGV().equals(s.getMaGV())){
                dsgv.set(i, s);
                GiaoVienDAO gvDAO=new GiaoVienDAO();
                gvDAO.set(s);
                return;
            }
        }
    }
    public GiaoVienDTO getGV(String magv){
        for(GiaoVienDTO gv:dsgv){
            if(gv.getMaGV().equals(magv)){
                return gv;
            }
        }
        return null;
    }


    //kiem tra ma
    public boolean checkMagv(String magv){
        for(GiaoVienDTO gv:dsgv){
            if(gv.getMaGV().equals(magv)){
                return true;
            }
        }
        return false;
    }
    // public ArrayList<GiaoVienDTO> searchGV(String maGV, String tenGV, int namSinh) {
    // ArrayList<GiaoVienDTO> searchGV = new ArrayList<>();

    // // Lặp qua danh sách giáo viên để tìm kiếm
    // for (GiaoVienDTO gv : dsgv) {
    //     // Kiểm tra xem thông tin mã giáo viên, tên giáo viên và năm sinh có trùng khớp với thông tin tìm kiếm không
    //     if (gv.getMaGV().contains(maGV) &&
    //         gv.getTenGV().contains(tenGV) &&
    //         (namSinh == 0 || gv.getNamSinh() == namSinh)) {
    //         searchGV.add(gv); // Nếu trùng khớp, thêm giáo viên vào danh sách kết quả
    //     }
    // }
    // return searchGV; // Trả về danh sách kết quả
    // }

    // public ArrayList<GiaoVienDTO> searchGV(String maGV, String tenGV, int namSinh) {
    // ArrayList<GiaoVienDTO> search = new ArrayList<>();
    //     maGV = maGV.isEmpty()?maGV = "": maGV;
    //     tenGV = tenGV.isEmpty()?tenGV = "": tenGV;
    //     //namSinh = namSinh.isEmpty()?namSinh = "": namSinh;
    //     for(GiaoVienDTO gv:dsgv){
    //         if(gv.getMaGV().contains(maGV) &&
    //             gv.getTenGV().contains(tenGV)&&
    //             gv.getNamSinh()==namSinh
    //         ){
    //             search.add(gv);
    //         }
    //     }
    public ArrayList<GiaoVienDTO> searchGV(String maGV, String tenGV) {
    ArrayList<GiaoVienDTO> search = new ArrayList<>();
        maGV = maGV.isEmpty()?maGV = "": maGV;
        tenGV = tenGV.isEmpty()?tenGV = "": tenGV;
        //namSinh = namSinh.isEmpty()?namSinh = "": namSinh;
        for(GiaoVienDTO gv:dsgv){
            if(gv.getMaGV().contains(maGV) &&
                gv.getTenGV().contains(tenGV)
            ){
                search.add(gv);
            }
        }
    return search; // Trả về danh sách kết quả
    }

    public ArrayList<GiaoVienDTO>getList(){
        return dsgv;
    }
   
  
}
