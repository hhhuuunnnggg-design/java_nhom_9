package BUS;

import DATA.GiaoVienDAO;
import DTO.GiaoVienDTO;

import java.util.ArrayList;

public class GiaoVienBUS {
    private ArrayList<GiaoVienDTO> dsgv;

    public GiaoVienBUS() {
        listGV();
    }

    public void listGV() {
        GiaoVienDAO gvDAO = new GiaoVienDAO();
        dsgv = gvDAO.list();
    }

    public void addGV(GiaoVienDTO gv) {
        dsgv.add(gv);
        GiaoVienDAO gvDAO = new GiaoVienDAO();
        gvDAO.add(gv);
    }

    public void deleteGV(String magv) {
        for (GiaoVienDTO gv : dsgv) {
            if (gv.getMaGV().equals(magv)) {
                dsgv.remove(gv);
                GiaoVienDAO gvDAO = new GiaoVienDAO();
                gvDAO.delete(magv);
                return;
            }
        }
    }

    public void setGV(GiaoVienDTO s) {
        for (int i = 0; i < dsgv.size(); i++) {
            if (dsgv.get(i).getMaGV().equals(s.getMaGV())) {
                dsgv.set(i, s);
                GiaoVienDAO gvDAO = new GiaoVienDAO();
                gvDAO.set(s);
                return;
            }
        }
    }

    public GiaoVienDTO getGV(String magv) {
        for (GiaoVienDTO gv : dsgv) {
            if (gv.getMaGV().equals(magv)) {
                return gv;
            }
        }
        return null;
    }

    public boolean checkMagv(String magv) {
        for (GiaoVienDTO gv : dsgv) {
            if (gv.getMaGV().equals(magv)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<GiaoVienDTO> searchGV(String maGV, String tenGV, String namSinh, String gioiTinh, String dienThoai) {
        ArrayList<GiaoVienDTO> search = new ArrayList<>();
        maGV = maGV.isEmpty() ? maGV = "" : maGV;
        tenGV = tenGV.isEmpty() ? tenGV = "" : tenGV;
        namSinh = namSinh.isEmpty() ? namSinh = "" : namSinh;
        gioiTinh = gioiTinh.isEmpty() ? gioiTinh = "" : gioiTinh;
        dienThoai = dienThoai.isEmpty() ? dienThoai = "" : dienThoai;
        for (GiaoVienDTO gv : dsgv) {
            if (gv.getMaGV().contains(maGV) &&
                gv.getTenGV().contains(tenGV) &&
                gv.getNamSinh().contains(namSinh) &&
                gv.getGioiTinh().contains(gioiTinh) &&
                gv.getDienThoai().contains(dienThoai)) {
                search.add(gv);
            }
        }
        return search; // Trả về danh sách kết quả
    }

    public ArrayList<GiaoVienDTO> getList() {
        return dsgv;
    }


   
    public static void main(String[] args) {
        GiaoVienBUS giaoVienBUS = new GiaoVienBUS();
    
        // Display all teachers to debug and see what is being loaded
        ArrayList<GiaoVienDTO> dsgv = giaoVienBUS.getList();
    
        System.out.println("All Teachers:");
        for (GiaoVienDTO gv : dsgv) {
            System.out.println("MAGV: " + gv.getMaGV());
            System.out.println("HOGV: " + gv.getHoGV());
            System.out.println("TENGV: " + gv.getTenGV());
            System.out.println("GIOITINH: " + gv.getGioiTinh());
            System.out.println("NAMSINH: " + gv.getNamSinh());
            System.out.println("DIENTHOAI: " + gv.getDienThoai());
            System.out.println("IMG: " + gv.getIMG());
            System.out.println("-------------------------------");
        }
    
        // Attempt to get and print details of a specific teacher
        GiaoVienDTO gv = giaoVienBUS.getGV("GV1");
        if (gv != null) {
            System.out.println("Details of GV1:");
            System.out.println("MAGV: " + gv.getMaGV());
            System.out.println("HOGV: " + gv.getHoGV());
            System.out.println("TENGV: " + gv.getTenGV());
            System.out.println("GIOITINH: " + gv.getGioiTinh());
            System.out.println("NAMSINH: " + gv.getNamSinh());
            System.out.println("DIENTHOAI: " + gv.getDienThoai());
            System.out.println("IMG: " + gv.getIMG());
        } else {
            System.out.println("No teacher found with MAGV = GV1");
        }
    }
    
}
