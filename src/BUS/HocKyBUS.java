package BUS;

import java.util.ArrayList;

import DATA.HocKyDAO;
import DTO.HocKyDTO;

public class HocKyBUS {
    private ArrayList<HocKyDTO> dshk ;
    public HocKyBUS(int i1)
    {
        list();
    }
    
    public HocKyBUS()
    {
        
    }

    public void list()
    {
        HocKyDAO hkDAO = new HocKyDAO();
        dshk = new ArrayList<>();
        dshk = hkDAO.list();
    }
    public void add(HocKyDTO hk)
    {
        dshk.add(hk);
        HocKyDAO hkDAO = new HocKyDAO();
        hkDAO.add(hk);
    }

    public void set(HocKyDTO s)
    {
        for(int i = 0 ; i < dshk.size() ; i++)
        {
            if(dshk.get(i).getHocKyID().equals(s.getHocKyID()))
            {
                dshk.set(i, s);
                HocKyDAO hkDAO = new HocKyDAO();
                hkDAO.set(s);
                return;
            }
        }
    }
    public boolean check(String id)
    {
        for(HocKyDTO hk : dshk)
        {
            if(hk.getHocKyID().equals(id))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<HocKyDTO> search(String id,String tenkh)
    {
        ArrayList<HocKyDTO> search = new ArrayList<>();
        id = id==null?id = "": id;
        tenkh = (tenkh==null || tenkh.equals("Tất cả"))?tenkh = "": tenkh;
        for(HocKyDTO hk : dshk)
        {
            if( hk.getHocKyID().contains(id) && 
                hk.getTenHocKy().contains(tenkh))
            {
                search.add(hk);
            }
        }
        return search;
    }
  
    public HocKyDTO search(String id)
    {
        HocKyDTO hk = null;
        for(HocKyDTO x : dshk)
        {
            if( hk.getHocKyID()==id){
                hk = x;
            }
        }
        return hk;
    }
    
    public ArrayList<HocKyDTO> getList() {
        return dshk;
    }

}
