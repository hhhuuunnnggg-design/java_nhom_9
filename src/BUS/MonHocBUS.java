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
    
    public MonHocBUS(){}

    // theem
    public void addMH(MonHocDTO mh) {
        dsmh.add(mh);
        MonHocDAO hsDAO = new MonHocDAO();
        hsDAO.add(mh);
    }
   //xóa
    public void deleteMH(String mamh) {
        for (MonHocDTO hs : dsmh) {
            if (hs.getMonHocID().equals(mamh)) {
                // dshs.remove(mahs);
                MonHocDAO hsDAO = new MonHocDAO();
                hsDAO.delete(mamh);
                return;
            }
        }
    }

    
    // get/set
    //cập nhật
    public void updateMH(MonHocDTO s) {
        for (int i = 0; i < dsmh.size(); i++) {
            if (dsmh.get(i).getMonHocID().equals(s.getMonHocID())) {
                dsmh.set(i, s);
                MonHocDAO mhDAO = new MonHocDAO();
                mhDAO.Update(s);
                return;
            }
        }
    }
    //k thấy có tác dụng gì
    public MonHocDTO getByName(String tenmh)
    {
        for(MonHocDTO mh : dsmh )
        {
            if(mh.getTenMonHoc().equals(tenmh))
            {
                return mh;
            }
        }
        return null;
    }

    public void list()
    {
        MonHocDAO mhDAO = new MonHocDAO();
        dsmh = new ArrayList<>();
        dsmh = mhDAO.list();
    }
    //kiếm tra theo mã
    public boolean checkMaMH(String id) {
        // Cập nhật danh sách người dùng từ cơ sở dữ liệu
        list();
        
        for (MonHocDTO mh : dsmh) {
            if (mh.getMonHocID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMH(String id)
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

    //tim kiếm id
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
    public static void main(String[] args) {
        // Create an instance of MonHocBUS
        MonHocBUS monHocBUS = new MonHocBUS(1);
    
    }
    
}
