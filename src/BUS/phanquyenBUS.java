package BUS;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import DATA.phanquyenDAO;
import DTO.chitietquyenDTO;
import DTO.chucnangDTO;
import DTO.phanquyenDTO;

public class phanquyenBUS {

    ArrayList<phanquyenDTO> dsquyen;
    ArrayList<chucnangDTO> dschucnang;
    ArrayList<chitietquyenDTO> dschitietquyen;

    public void listquyen() {
        phanquyenDAO dao = new phanquyenDAO();
        dsquyen = new ArrayList<>();
        dsquyen = dao.listQuyen();
    }

    public void listChiTietQuyen(String maquyen) {
        phanquyenDAO dao = new phanquyenDAO();
        dschitietquyen = new ArrayList<>();
        dschitietquyen = dao.listChiTietQuyen(maquyen);
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

    public void addQuyen(phanquyenDTO newQuyen) {
        phanquyenDAO dao = new phanquyenDAO();
        dao.addQuyen(newQuyen);
    }

    public boolean checkExist(String maquyen) {
        phanquyenDAO dao = new phanquyenDAO();
        return dao.checkExist(maquyen);
    }

    public void addChitietquyen(chitietquyenDTO ctq) {
        phanquyenDAO dao = new phanquyenDAO();
        dao.addChitietquyen(ctq);

    }

    public ArrayList<chitietquyenDTO> getListchitietquyen() {
        return dschitietquyen;
    }

    public void deleteQuyen(String maquyen) {
        phanquyenDAO dao = new phanquyenDAO();
        dao.deleteQuyen(maquyen);
    }

    public void deleteChitietquyen(String maquyen) {
        phanquyenDAO dao = new phanquyenDAO();
        dao.deteleChitietQuyen(maquyen);
    }
}