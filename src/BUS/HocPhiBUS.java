package BUS;

import DATA.HocPhiDAO;
import DTO.HocPhiDTO;

import java.util.ArrayList;

public class HocPhiBUS {
    private ArrayList<HocPhiDTO> dsHocPhi;

    public HocPhiBUS() {
        list();
    }

    public void list() {
        HocPhiDAO hocPhiDAO = new HocPhiDAO();
        dsHocPhi = hocPhiDAO.list();
    }

    public ArrayList<HocPhiDTO> getList() {
        return dsHocPhi;
    }

    public HocPhiDTO get(int idhs) {
        for (HocPhiDTO hocPhi : dsHocPhi) {
            if (hocPhi.getIdhs() == idhs) {
                return hocPhi;
            }
        }
        return null;
    }

    public void add(HocPhiDTO hocPhi) {
        dsHocPhi.add(hocPhi);
        HocPhiDAO hocPhiDAO = new HocPhiDAO();
        hocPhiDAO.add(hocPhi);
    }

    public void set(HocPhiDTO hocPhi) {
        for (int i = 0; i < dsHocPhi.size(); i++) {
            if (dsHocPhi.get(i).getIdhs() == hocPhi.getIdhs()) {
                dsHocPhi.set(i, hocPhi);
                HocPhiDAO hocPhiDAO = new HocPhiDAO();
                hocPhiDAO.set(hocPhi);
                return;
            }
        }
    }

    public void delete(int idhs) {
        for (HocPhiDTO hocPhi : dsHocPhi) {
            if (hocPhi.getIdhs() == idhs) {
                dsHocPhi.remove(hocPhi);
                HocPhiDAO hocPhiDAO = new HocPhiDAO();
                hocPhiDAO.delete(idhs);
                return;
            }
        }
    }

    public static void main(String[] args) {
        HocPhiBUS hocPhiBUS = new HocPhiBUS();
        ArrayList<HocPhiDTO> dsHocPhi = hocPhiBUS.getList();

        for (HocPhiDTO hocPhi : dsHocPhi) {
            System.out.println("ID Học Sinh: " + hocPhi.getIdhs());
            System.out.println("ID Năm Học: " + hocPhi.getIdnh());
            System.out.println("Thời gian: " + hocPhi.getThoigian());
            System.out.println("Trạng thái: " + hocPhi.getStatus());
            System.out.println();
        }
    }
}
