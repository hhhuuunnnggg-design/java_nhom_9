/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.HocSinhDAO;
import DTO.HocSinhDTO;
import java.util.ArrayList;


public class HocSinhBUS{
    private ArrayList<HocSinhDTO> dshs ;
    public HocSinhBUS(int i1)
    {
        list();
    }
    
    public HocSinhBUS()
    {
        
    }
    public HocSinhDTO get(String id)
    {
        for(HocSinhDTO hs : dshs )
        {
            if(hs.getHocSinhID().equals(id))
            {
                return hs;
            }
        }
        return null;
    }
    public void list()
    {
        HocSinhDAO hsDATA = new HocSinhDAO();
        dshs = new ArrayList<>();
        dshs = hsDATA.list();
    }
    public void add(HocSinhDTO hs)
    {
        dshs.add(hs);
        HocSinhDAO hsDATA = new HocSinhDAO();
        hsDATA.add(hs);
    }

    public void delete(String id)
    {
        for(HocSinhDTO hs : dshs )
        {
            if(hs.getHocSinhID().equals(id))
            {
                dshs.remove(hs);
                HocSinhDAO hsDATA = new HocSinhDAO();
                hsDATA.delete(id);
                return;
            }
        }
    }
    public void set(HocSinhDTO s)
    {
        for(int i = 0 ; i < dshs.size() ; i++)
        {
            if(dshs.get(i).getHocSinhID().equals(s.getHocSinhID()))
            {
                dshs.set(i, s);
                HocSinhDAO hsDATA = new HocSinhDAO();
                hsDATA.set(s);
                return;
            }
        }
    }
    public boolean check(String id)
    {
        for(HocSinhDTO hs : dshs)
        {
            if(hs.getHocSinhID().equals(id))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<HocSinhDTO> search(String id,String hoten)
    {
        ArrayList<HocSinhDTO> search = new ArrayList<>();
        id = id.isEmpty()?id = "": id;
        hoten = hoten.isEmpty()?hoten = "": hoten;
        for(HocSinhDTO hs : dshs)
        {
            if( hs.getHocSinhID().contains(id) && 
                hs.getTenHocSinh().contains(hoten))
            {
                search.add(hs);
            }
        }
        return search;
    }

    public ArrayList<HocSinhDTO> search(String hoten)
    {
        ArrayList<HocSinhDTO> search = new ArrayList<>();
        hoten = hoten.isEmpty()?hoten = "": hoten;
        for(HocSinhDTO hs : dshs)
        {
            if( hs.getTenHocSinh().contains(hoten))
            {
                search.add(hs);
            }
        }
        return search;
    }
        
    public HocSinhDTO searchById(String id)
    {
        HocSinhDTO hs = null;
        for(HocSinhDTO x : dshs)
        {
            if( hs.getHocSinhID()==id){
                hs = x;
            }
        }
        return hs;
    }
    
    public ArrayList<HocSinhDTO> getList() {
        return dshs;
    }
    public static void main(String[] args) {
    HocSinhBUS hocSinhBUS = new HocSinhBUS(1);
    ArrayList<HocSinhDTO> hocSinhList = hocSinhBUS.getList();
    
    // Print the data of each HocSinhDTO object in the list
    for (HocSinhDTO hs : hocSinhList) {
        System.out.println("HocSinhID: " + hs.getHocSinhID());
        System.out.println("HoVaTen: " + hs.getTenHocSinh());
        System.out.println("GioiTinh: " + hs.getGioiTinh());
        System.out.println("NgaySinh: " + hs.getNgaySinh());
        System.out.println("DienThoai: " + hs.getDienThoai());
        System.out.println("DiaChi: " + hs.getDiaChi());
        System.out.println("HocPhi: " + hs.getHocPhi());
        System.out.println("IMG: " + hs.getIMG());
        System.out.println(); // for readability
    }
    }

}
