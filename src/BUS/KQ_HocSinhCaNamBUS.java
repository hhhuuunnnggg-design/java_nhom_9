package BUS;

import java.util.ArrayList;

import DATA.KQ_HocSinhCaNamDAO;
import DTO.KQ_HocSinhCaNamDTO;

public class KQ_HocSinhCaNamBUS {
    private ArrayList<KQ_HocSinhCaNamDTO> dskq ;
    public KQ_HocSinhCaNamBUS()
    {
        list();
    }
    

    public String getHocLucById(String id){
        for(KQ_HocSinhCaNamDTO kq : dskq )
        {
            if(kq.getHocSinhID().equals(id))
            {
                return kq.getHocLuc();
            }
        }
        return null;
    }

    public String getHanhKiemById(String id){
        for(KQ_HocSinhCaNamDTO kq : dskq )
        {
            if(kq.getHocSinhID().equals(id))
            {
                return kq.getHanhKiem();
            }
        }
        return null;
    }

    
    public KQ_HocSinhCaNamDTO get(String id)
    {
        for(KQ_HocSinhCaNamDTO kq : dskq )
        {
            if(kq.getHocSinhID().equals(id))
            {
                return kq;
            }
        }
        return null;
    }
    public void list()
    {
        KQ_HocSinhCaNamDAO kq_kqDATA = new KQ_HocSinhCaNamDAO();
        dskq = new ArrayList<>();
        dskq = kq_kqDATA.list();
    }
    public void add(KQ_HocSinhCaNamDTO kq)
    {
        dskq.add(kq);
        KQ_HocSinhCaNamDAO kq_kqDATA = new KQ_HocSinhCaNamDAO();
        kq_kqDATA.add(kq);
    }

    public void delete(String id)
    {
        for(KQ_HocSinhCaNamDTO kq : dskq )
        {
            if(kq.getHocSinhID().equals(id))
            {
                dskq.remove(kq);
                KQ_HocSinhCaNamDAO kq_kqDATA = new KQ_HocSinhCaNamDAO();
                kq_kqDATA.delete(id);
                return;
            }
        }
    }
    public void set(KQ_HocSinhCaNamDTO s)
    {
        for(int i = 0 ; i < dskq.size() ; i++)
        {
            if(dskq.get(i).getHocSinhID().equals(s.getHocSinhID()))
            {
                dskq.set(i, s);
                KQ_HocSinhCaNamDAO kq_kqDATA = new KQ_HocSinhCaNamDAO();
                kq_kqDATA.set(s);
                return;
            }
        }
    }
    public boolean check(String id)
    {
        for(KQ_HocSinhCaNamDTO kq : dskq)
        {
            if(kq.getHocSinhID().equals(id))
            {
                return true;
            }
        }
        return false;
    }
    // public ArrayList<KQ_HocSinhCaNamDTO> search(String id,String hoten)
    // {
    //     ArrayList<KQ_HocSinhCaNamDTO> search = new ArrayList<>();
    //     id = id.isEmpty()?id = "": id;
    //     hoten = hoten.isEmpty()?hoten = "": hoten;
    //     for(KQ_HocSinhCaNamDTO kq : dskq)
    //     {
    //         if( kq.getHocSinhID().contains(id) && 
    //             kq.getTenHocSinh().contains(hoten))
    //         {
    //             search.add(kq);
    //         }
    //     }
    //     return search;
    // }

    
    
    public ArrayList<KQ_HocSinhCaNamDTO> getList() {
        return dskq;
    }

    
        public static void main(String[] args) {
            // Create an instance of KQ_HocSinhCaNamBUS
            KQ_HocSinhCaNamBUS hsbus = new KQ_HocSinhCaNamBUS();
            
            // Populate the list (assuming it's populated somewhere in your application)
            // For demonstration purposes, let's assume the list is populated in the constructor
            hsbus.list(); // This method populates the list
            
            // Call showInfoOfList method to display information
            for (KQ_HocSinhCaNamDTO kq : hsbus.getList()) {
                System.out.println("HocSinhID: " + kq.getHocSinhID());
                System.out.println("HocLuc: " + kq.getHocLuc());
                System.out.println("HanhKiem: " + kq.getHanhKiem());
                // Add more fields if needed
                System.out.println("----------------------");
            }
        }
    
}
