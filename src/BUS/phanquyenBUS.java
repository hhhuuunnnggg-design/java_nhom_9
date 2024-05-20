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

}