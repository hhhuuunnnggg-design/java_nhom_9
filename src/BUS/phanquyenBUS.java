package BUS;

import java.util.ArrayList;
import DATA.phanquyenDAO;
import DTO.chucnangDTO;
import DTO.phanquyenDTO;

public class phanquyenBUS {

    ArrayList<phanquyenDTO> dsquyen;
    ArrayList<chucnangDTO> dschucnang;

    public void listquyen() {
        phanquyenDAO dao = new phanquyenDAO();
        dsquyen = new ArrayList<>();
        dsquyen = dao.listQuyen();
    }

    public void listchucnang() {
        phanquyenDAO dao = new phanquyenDAO();
        dschucnang = new ArrayList<>();
        dschucnang = dao.listChucNang();
    }

    public ArrayList<phanquyenDTO> getlistquyen() {
        return dsquyen;
    }

    public ArrayList<chucnangDTO> getlistchucnang() {
        return dschucnang;
    }

    public static void main(String[] args) {
        phanquyenBUS phanquyenBUS = new phanquyenBUS();
    
        // Ensure the lists are initialized
        phanquyenBUS.listquyen();
        phanquyenBUS.listchucnang();
    
        // Print out all phanquyenDTO objects
        ArrayList<phanquyenDTO> allQuyen = phanquyenBUS.getlistquyen();
        for (phanquyenDTO quyen : allQuyen) {
            System.out.println("MaQuyen: " + quyen.getMaquyen());
            System.out.println("TenQuyen: " + quyen.getTenquyen());
            System.out.println("-------------------------");
        }
    
    //     // Print out all chucnangDTO objects
    //     ArrayList<chucnangDTO> allChucNang = phanquyenBUS.getlistchucnang();
    //     for (chucnangDTO chucNang : allChucNang) {
    //         System.out.println("MaChucNang: " + chucNang.getMaChucNang());
    //         System.out.println("TenChucNang: " + chucNang.getTenChucNang());
    //         System.out.println("-------------------------");
    //     }
    }
    
}
