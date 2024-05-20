package BUS;

import java.util.ArrayList;

import DATA.NamHocDAO;
import DTO.NamHocDTO;

public class NamHocBUS {
    private ArrayList<NamHocDTO> dsnh ;
    public NamHocBUS(int i1)
    {
        list();
    }
    
    public NamHocBUS()
    {
        
    }

    public NamHocDTO get(String id)
    {
        for(NamHocDTO nh : dsnh )
        {
            if(nh.getNamHocID().equals(id))
            {
                return nh;
            }
        }
        return null;
    }
    // theem
    public void addNH(NamHocDTO nh) {
        dsnh.add(nh);
        NamHocDAO nhDAO =new NamHocDAO();
        nhDAO.Add(nh);
    }
    // xoa
    public void deleteNH(String manh) {
        for (NamHocDTO nh : dsnh) {
            if (nh.getNamHocID().equals(manh)) {
                // dshs.remove(mahs);
                NamHocDAO nhDAO = new NamHocDAO();
                nhDAO.delete(manh);
                return;
           }
        }
    }
    
    
    // cập nhật
    public void updateNH(NamHocDTO s) {
        for (int i = 0; i < dsnh.size(); i++) {
            if (dsnh.get(i).getNamHocID().equals(s.getNamHocID())) {
                dsnh.set(i, s);
                NamHocDAO hsDAO = new NamHocDAO();
                hsDAO.Update(s);
                return;
            }
        }
    }
    

    // kiem tra ma
    // public boolean checkMaNH(String manh) {
    //     NamHocDAO hsDao = new NamHocDAO();
    //     dsnh = new ArrayList<>();
    //     dsnh = hsDao.checkMaNH();
    //     for (NamHocDTO nh : dsnh) {
    //         System.out.println(nh.getNamHocID());
    //         if (nh.getNamHocID().equals(manh)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean checkMaNH(String id)
    {
        for(NamHocDTO nh : dsnh)
        {
            if(nh.getNamHocID().equals(id))
            {
                return true;
            }
        }
        return false;
    }

    public void listNH() {
        NamHocDAO nhDAO = new NamHocDAO();
        dsnh = new ArrayList<>();
        dsnh = nhDAO.list();
    }
    

    public NamHocDTO getByName(String tennamhoc)
    {
        for(NamHocDTO nh : dsnh )
        {
            if(nh.getNamHocKetThuc()==(Integer.parseInt(tennamhoc.substring(5))))
            {
                return nh;
            }
        }
        return null;
    }
    public NamHocDTO getByStartYear(int namhientai)
    {
        for(NamHocDTO nh : dsnh )
        {
            if(nh.getNamHocBatDau()==namhientai)
            {
                return nh;
            }
        }
        return null;
    }
    public String getByAcademicYear(String academicYear) {
        for (NamHocDTO nh : dsnh) {
            String namHocID = nh.getNamHocBatDau() + "-" + nh.getNamHocKetThuc();
            if (namHocID.equals(academicYear)) {
                return nh.getNamHocID();
            }
        }
        return null;
    }
    
    public void list()
    {
        NamHocDAO nhDATA = new NamHocDAO();
        dsnh = new ArrayList<>();
        dsnh = nhDATA.list();
    }

    public boolean check(String id)
    {
        for(NamHocDTO nh : dsnh)
        {
            if(nh.getNamHocID().equals(id))
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<NamHocDTO> search(String id,String NamHoc)
    {
        ArrayList<NamHocDTO> search = new ArrayList<>();
        id = id==null?id = "": id;
        NamHoc = (NamHoc==null ||NamHoc.equals("Tất cả"))?NamHoc = "":NamHoc.substring(5);
        
        for(NamHocDTO nh : dsnh)
        {
            if( nh.getNamHocID().contains(id) &&
                String.valueOf(nh.getNamHocKetThuc()).contains(NamHoc))
            {
                search.add(nh);
            }
        }
        return search;
    }
    

    public ArrayList<NamHocDTO> getList() {
        return dsnh;
    }

    public static void main(String[] args) {
        // Create an instance of NamHocBUS
        NamHocBUS namHocBUS = new NamHocBUS(1);
    
        System.out.println(namHocBUS.getByStartYear(2024).getNamHocID());
    }
    
}
