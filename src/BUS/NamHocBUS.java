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
    
    // public ArrayList<NamHocDTO> search(String id, String NamHoc) {
    //     ArrayList<NamHocDTO> searchResult = new ArrayList<>();
        
    //     id = id == null ? "" : id;
    //     NamHoc = (NamHoc == null || NamHoc.equals("Tất cả")) ? "" : NamHoc;
    
    //     for (NamHocDTO nh : dsnh) {
    //         String academicYear = nh.getNamHocBatDau() + "-" + nh.getNamHocKetThuc();
    //         if (nh.getNamHocID().contains(id) && academicYear.equals(NamHoc)) {
    //             searchResult.add(nh);
    //         }
    //     }
        
    //     return searchResult;
    // }
    
    
    public ArrayList<NamHocDTO> getList() {
        return dsnh;
    }

    public static void main(String[] args) {
        // Create an instance of NamHocBUS
        NamHocBUS namHocBUS = new NamHocBUS(1);
    
        System.out.println(namHocBUS.getByStartYear(2024).getNamHocID());
    }
    
}
