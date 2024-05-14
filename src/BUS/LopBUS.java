/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.LopDAO;
import DTO.LopDTO;
import java.util.ArrayList;


public class LopBUS {
    private ArrayList<LopDTO> dslop ;
    public LopBUS(int i1)
    {
        list();
    }
    
    public LopBUS()
    {
        
    }
    public LopDTO get(String id)
    {
        for(LopDTO lop : dslop )
        {
            if(lop.getLopID().equals(id))
            {
                return lop;
            }
        }
        return null;
    }
    public void list()
    {
        LopDAO lopDAO = new LopDAO();
        dslop = new ArrayList<>();
        dslop = lopDAO.list();
    }
    public void add(LopDTO lop)
    {
        dslop.add(lop);
        LopDAO lopDAO = new LopDAO();
        lopDAO.add(lop);
    }

    public void delete(String id)
    {
        for(LopDTO lop : dslop )
        {
            if(lop.getLopID().equals(id))
            {
                dslop.remove(lop);
                LopDAO lopDAO = new LopDAO();
                lopDAO.delete(lop);
                return;
            }
        }
    }
    public void set(LopDTO s)
    {
        for(int i = 0 ; i < dslop.size() ; i++)
        {
            if(dslop.get(i).getLopID().equals(s.getLopID()))
            {
                dslop.set(i, s);
                LopDAO lopDAO = new LopDAO();
                lopDAO.set(s);
                return;
            }
        }
    }
    public boolean check(String id)
    {
        for(LopDTO lop : dslop)
        {
            if(lop.getLopID().equals(id))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<LopDTO> search(String id,String tenlop)
    {
        ArrayList<LopDTO> search = new ArrayList<>();
        id = id==null ?id = "": id;
        tenlop = (tenlop==null || tenlop.equals("Tất cả"))?tenlop = "": tenlop;
        for(LopDTO lop : dslop)
        {
            if( lop.getLopID().contains(id) && 
                lop.getTenLop().contains(tenlop))
            {
                search.add(lop);
            }
        }
        return search;
    }

    public ArrayList<LopDTO> search(String hoten)
    {
        ArrayList<LopDTO> search = new ArrayList<>();
        hoten = hoten.isEmpty()?hoten = "": hoten;
        for(LopDTO lop : dslop)
        {
            if( lop.getTenLop().contains(hoten))
            {
                search.add(lop);
            }
        }
        return search;
    }
        
    public LopDTO searchById(String id)
    {
        LopDTO lop = null;
        for(LopDTO x : dslop)
        {
            if( lop.getLopID()==id){
                lop = x;
            }
        }
        return lop;
    }
    
    public ArrayList<LopDTO> getList() {
        return dslop;
    }
    public static void main(String[] args) {
        // Create an instance of LopBUS
        LopBUS lopBUS = new LopBUS(1);
    
        // Search for classes with the name "10A1"
        String classNameToSearch = "Tất cả";
        ArrayList<LopDTO> searchResult = lopBUS.search(null, classNameToSearch);
    
        // Print the search result
        if (!searchResult.isEmpty()) {
            System.out.println("Search Result for Class " + classNameToSearch + ":");
            for (LopDTO lop : searchResult) {
                System.out.println(lop);
            }
        } else {
            System.out.println("No result found for Class " + classNameToSearch);
        }
    }
    
}
