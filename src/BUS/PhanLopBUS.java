/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DATA.PhanLopDAO;
import DTO.PhanLopDTO;
import java.util.ArrayList;


public class PhanLopBUS {
    private ArrayList<PhanLopDTO> dspl ;
    public PhanLopBUS(int i1)
    {
        list();
    }
    
    public PhanLopBUS()
    {
        
    }

    public void list()
    {
        PhanLopDAO plDAO = new PhanLopDAO();
        dspl = new ArrayList<>();
        dspl = plDAO.list();
    }
    public void add(PhanLopDTO pl)
    {
        dspl.add(pl);
        PhanLopDAO plDAO = new PhanLopDAO();
        plDAO.add(pl);
    }

    public void delete(String hsid)
    {
        for(PhanLopDTO pl : dspl )
        {
            if(pl.getHocSinhID().equals(hsid))
            {
                dspl.remove(pl);
                PhanLopDAO plDAO = new PhanLopDAO();
                plDAO.delete(pl);
                return;
            }
        }
    }
    public void set(PhanLopDTO s)
    {
        for(int i = 0 ; i < dspl.size() ; i++)
        {
            if(dspl.get(i).getHocSinhID().equals(s.getHocSinhID()))
            {
                dspl.set(i, s);
                PhanLopDAO plDAO = new PhanLopDAO();
                plDAO.set(s);
                return;
            }
        }
    }
    public boolean check(String id)
    {
        for(PhanLopDTO pl : dspl)
        {
            if(pl.getHocSinhID().equals(id))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<PhanLopDTO> search(String id,String idlop)
    {
        ArrayList<PhanLopDTO> search = new ArrayList<>();
        id = id.isEmpty()?id = "": id;
        idlop = idlop.isEmpty()?idlop = "": idlop;
        for(PhanLopDTO pl : dspl)
        {
            if( pl.getHocSinhID().contains(id) && 
                pl.getLopID().contains(idlop))
            {
                search.add(pl);
            }
        }
        return search;
    }

    public ArrayList<PhanLopDTO> search(String idlop)
    {
        ArrayList<PhanLopDTO> search = new ArrayList<>();
        idlop = idlop.isEmpty()?idlop = "": idlop;
        for(PhanLopDTO pl : dspl)
        {
            if( pl.getLopID().contains(idlop))
            {
                search.add(pl);
            }
        }
        return search;
    }
        
    public PhanLopDTO searchById(String id)
    {
        PhanLopDTO pl = null;
        for(PhanLopDTO x : dspl)
        {
            if( pl.getHocSinhID()==id){
                pl = x;
            }
        }
        return pl;
    }
    
    public ArrayList<PhanLopDTO> getList() {
        return dspl;
    }

}
