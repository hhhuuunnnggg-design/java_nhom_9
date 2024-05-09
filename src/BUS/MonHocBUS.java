package BUS;

import java.util.ArrayList;

import DATA.MonHocDAO;
import DTO.MonHocDTO;

public class MonHocBUS {
    private ArrayList<MonHocDTO> dsmh ;
    public MonHocBUS(int i1)
    {
        list();
    }
    
    public MonHocBUS()
    {
        
    }

    //search by id mon hoc
    public MonHocDTO get(String id)
    {
        for(MonHocDTO mh : dsmh )
        {
            if(mh.getMonHocID().equals(id))
            {
                return mh;
            }
        }
        return null;
    }
    public void list()
    {
        MonHocDAO mhDATA = new MonHocDAO();
        dsmh = new ArrayList<>();
        dsmh = mhDATA.list();
    }

    public boolean check(String id)
    {
        for(MonHocDTO mh : dsmh)
        {
            if(mh.getMonHocID().equals(id))
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<MonHocDTO> search(String id,String monhoc)
    {
        ArrayList<MonHocDTO> search = new ArrayList<>();
        id = id==null?id = "": id;
        monhoc = (monhoc==null ||monhoc.equals("Tất cả"))?monhoc = "":monhoc;
        
        for(MonHocDTO mh : dsmh)
        {
            if( mh.getMonHocID().contains(id) &&
                mh.getTenMonHoc().contains(monhoc))
            {
                search.add(mh);
            }
        }
        return search;
    }

    
    public ArrayList<MonHocDTO> getList() {
        return dsmh;
    }
}
