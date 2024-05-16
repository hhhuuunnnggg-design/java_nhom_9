package GUI;
import javax.swing.*;

import DTO.user;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Page404;
import model.navItem;

/**
 *
 * @author Shadow
 */
public class mainChinhGUI extends JFrame implements MouseListener {
    protected static Object title_tentk;
    private JButton test;
    private String userID;
    private String userName;
    private String role;
    private boolean flag = true;
    private JPanel header, nav, main;
    private int DEFAULT_HEIGHT = 700, DEFALUT_WIDTH = 1060;
    private ArrayList<String> navItem = new ArrayList<>(); // Chứa thông tin có button cho menu gồm
    private ArrayList<navItem> navObj = new ArrayList<>(); // Chứa cái button trên thanh menu

    public mainChinhGUI(String username) throws SQLException {
        this.userName = username;
        Toolkit screen = Toolkit.getDefaultToolkit();
        init();
        setTitle("Quản lý học sinh ");
    }

    public void init() throws SQLException {
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        ImageIcon logo = new ImageIcon("./src/GUI/Students-icon.png");
        setIconImage(logo.getImage());
        setLayout(new BorderLayout());
        setSize(DEFALUT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        /************ PHẦN HEADER *************************************/
        header = new JPanel(null);
        Color my_color_jtop = new Color(78, 78, 234);
        header.setBackground(my_color_jtop);
        header.setPreferredSize(new Dimension(DEFALUT_WIDTH, 40));

        header hmain = new header(DEFALUT_WIDTH, 40);



        System.out.println(userName);

        JLabel user = new JLabel("Chào, " + userName);
        user.setFont(font);
        user.setForeground(Color.WHITE);
        user.setBounds(new Rectangle(DEFALUT_WIDTH - 300, -7, 150, 50));
        hmain.add(user);

        navItem btnLogOut = new navItem("", new Rectangle(DEFALUT_WIDTH - 150, -8, 50, 50), "logout_25px.png",
                "logout_25px.png", "logout_hover_25px.png", Color.green);
        hmain.add(btnLogOut.isButton());
        btnLogOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                lognGUI lg = new lognGUI();
                dispose();
            }
        });
        // }
        navItem exit = new navItem("", new Rectangle(DEFALUT_WIDTH - 50, -8, 50, 50), "exit_25px.png", "exit_25px.png",
                "exit_hover_25px.png", new Color(240, 71, 74));
        navItem minimize = new navItem("", new Rectangle(DEFALUT_WIDTH - 100, -8, 50, 50), "minimize_25px.png",
                "minimize_25px.png", "minimize_hover_25px.png", new Color(80, 80, 80));

        hmain.add(exit.isButton());
        hmain.add(minimize.isButton());

        exit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        minimize.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setState(Frame.ICONIFIED);
            }
        });

        header.add(hmain);
        
        if(userName.equals("admin")){

            nav = new JPanel(null);
            Color my_color_jleft = new Color(50, 48, 128);
            nav.setBackground(my_color_jleft);
            nav.setPreferredSize(new Dimension(220, DEFAULT_HEIGHT));
    
            JScrollPane scroll = new JScrollPane(nav);
            scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1, 100));
            scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
    
            navItem = new ArrayList<>();
            navItem.add("Quản lý giáo viên :Shop_20px.png:Shop_20px_active.png");
            navItem.add("Quản Lý Học Sinh:QLSP_20px.png:QLSP_20px_active.png");
            navItem.add("Thống kê:NhanVien_20px.png:NhanVien_20px_active.png");
            navItem.add("Thông tin tài khoản:KhachHang_20px.png:KhachHang_20px_active.png");
            navItem.add("chức năng 4:ThongKe_20px.png:ThongKe_20px_active.png");
            navItem.add("chức năng 5:CongCu_20px.png:CongCu_20px_active.png");
            if (role == null || role.equals("Admin")) {
                navItem.add("chức năng 6:CaiDat_20px.png:CaiDat_20px_active.png");
                navItem.add("chức năng 7:ThongKe_20px.png:ThongKe_20px_active.png");
            }
    
            outNav();
    
            /************ PHẦN MAIN ( HIỂN THỊ ) **************************/
            main = new JPanel(null);
            main.setBackground(Color.white);
            navObj.get(0).doActive();
            changeMainInfo(0);
    
            /**************************************************************/
    
            add(header, BorderLayout.NORTH);
            add(scroll, BorderLayout.WEST);
            add(main, BorderLayout.CENTER);
    
            setVisible(true);
        }else{
            String quyen;
            if (userName.length() >= 2) {
                quyen = userName.substring(0, 2);
            } else {
                quyen = userName;
            }
            System.out.println(quyen);

            if(quyen.equals("HS")){
                nav = new JPanel(null);
                Color my_color_jleft = new Color(50, 48, 128);
                nav.setBackground(my_color_jleft);
                nav.setPreferredSize(new Dimension(220, DEFAULT_HEIGHT));
        
                JScrollPane scroll = new JScrollPane(nav);
                scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1, 100));
                scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
        
                navItem = new ArrayList<>();
                navItem.add("Quản lý giáo viên :Shop_20px.png:Shop_20px_active.png");
                navItem.add("Quản Lý Học Sinh:QLSP_20px.png:QLSP_20px_active.png");
                navItem.add("Thống kê:NhanVien_20px.png:NhanVien_20px_active.png");
                navItem.add("Thông tin tài khoản:KhachHang_20px.png:KhachHang_20px_active.png");
                navItem.add("chức năng 4:ThongKe_20px.png:ThongKe_20px_active.png");
                navItem.add("chức năng 5:CongCu_20px.png:CongCu_20px_active.png");
                if (role == null || role.equals("Admin")) {
                    navItem.add("chức năng 6:CaiDat_20px.png:CaiDat_20px_active.png");
                    navItem.add("chức năng 7:ThongKe_20px.png:ThongKe_20px_active.png");
                }
        
                outNav();
        
         
                main = new JPanel(null);
                main.setBackground(Color.white);
                navObj.get(0).doActive();
                changeMainForHS(0);
        
                add(header, BorderLayout.NORTH);
                add(scroll, BorderLayout.WEST);
                add(main, BorderLayout.CENTER);
        
                setVisible(true);
            }
            if (quyen.equals("GV")) {
                System.out.println("đã vào giáo viên");
                nav = new JPanel(null);
                Color my_color_jleft = new Color(50, 48, 128);
                nav.setBackground(my_color_jleft);
                nav.setPreferredSize(new Dimension(220, DEFAULT_HEIGHT));
        
                JScrollPane scroll = new JScrollPane(nav);
                scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1, 100));
                scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
        
                navItem = new ArrayList<>();
                navItem.add("Quản lý giáo viên :Shop_20px.png:Shop_20px_active.png");
                navItem.add("Quản Lý Học Sinh:QLSP_20px.png:QLSP_20px_active.png");
                navItem.add("Thống kê:NhanVien_20px.png:NhanVien_20px_active.png");
                navItem.add("Thông tin tài khoản:KhachHang_20px.png:KhachHang_20px_active.png");
                navItem.add("chức năng 4:ThongKe_20px.png:ThongKe_20px_active.png");
                navItem.add("chức năng 5:CongCu_20px.png:CongCu_20px_active.png");
                navItem.add("chức năng 6:CaiDat_20px.png:CaiDat_20px_active.png");
                navItem.add("chức năng 7:ThongKe_20px.png:ThongKe_20px_active.png");
                outNav();
        
                
                main = new JPanel(null);
                main.setBackground(Color.white);
                navObj.get(0).doActive();
                changeMainForGV(0);
        
             
        
                add(header, BorderLayout.NORTH);
                add(scroll, BorderLayout.WEST);
                add(main, BorderLayout.CENTER);
        
                setVisible(true);
            }
        }

        
        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for (int i = 0; i < navObj.size(); i++) {
            navItem item = navObj.get(i); // lấy vị trí item trong menu
            if (e.getSource() == item) {
                item.doActive(); // Active NavItem đc chọn
                changeMainInfo(i); // Hiển thị ra phần main
            } else {
                item.noActive();
            }
        }
    }


    public void changeMainForHS(int i){
        
    }

    public void changeMainForGV(int i){
        
        switch (i) {
            case 0: // QUẢN LÝ Giao Vien
                main.removeAll();
                try {
                    main.add(new QLGV(850, 670));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break;                            
            case 1: // QUẢN LÝ Hoc Sinh
                main.removeAll();
                main.removeAll();
                try {
                    main.add(new QuanLiHocSinh(850, 670));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break;

            case 2: //THỐNG KÊ
            main.removeAll();
            try {
                main.add(new ThongKe(850,670));                
            }
                 catch (SQLException e) {
                e.printStackTrace();
            }
            main.repaint();
            main.revalidate();
            break;

            case 3: // THÔNG TIN TÀI KHOẢN HS VÀ GV
                if (flag) {
                    // Thêm 2 btn vào dưới "chức năng 3"
                    navItem.add(4, "Học sinh:KhachHang_20px.png:KhachHang_20px_active.png");
                    navItem.add(5, "Giáo viên:KhachHang_20px.png:KhachHang_20px_active.png");
                    flag = false; // Thông báo là đang Dropdown
                } else {
                    // Xóa 2 btn của "chức năng 3"
                    navItem.remove(4);
                    navItem.remove(5);
                    flag = true; // Thông báo là Dropdown đã ẩn
                }
                outNav(); // Load lại phần Navigation
                break;

            case 4: // Chức năng 3.1: Thông tin tài khoản học sinh
            main.removeAll();
            try {
                main.add(new TTTK_HS(850, 670));
            }
                 catch (SQLException e) {
                e.printStackTrace();
            }
            main.repaint();
            main.revalidate();
            break;

            case 5: // Chức năng 3.2: Thông tin tài khoản giáo viên
            main.removeAll();
            try {
                main.add(new TTTK_GV(850, 670));
            }
                 catch (SQLException e) {
                e.printStackTrace();
            }
            main.repaint();
            main.revalidate();
            break;

            case 6: // NHẬP VÀ XUẤT
                if (flag) {
                    navItem.add(7, "Chức năng 4.1:KhachHang_20px.png:KhachHang_20px_active.png");
                    navItem.add(8, "Chức năng 4.2:KhachHang_20px.png:KhachHang_20px_active.png");
                    flag = false;
                } else {
                    navItem.remove(7);
                    navItem.remove(8);
                    flag = true;
                }
                outNav();
                break;

        }
    }


    public void changeMainInfo(int i) {
        if (flag && i > 4 && i < 8) // Thay đổi nếu Thống kê đang dropdown
        {
            i = i + 2;
        }
        switch (i) {
            case 0: // QUẢN LÝ Giao Vien
                main.removeAll();
                try {
                    main.add(new QLGV(850, 670));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break;

                            


            case 1: // QUẢN LÝ Hoc Sinh
                main.removeAll();
                main.removeAll();
                try {
                    main.add(new QuanLiHocSinh(850, 670));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break;

            case 2: //THỐNG KÊ
            main.removeAll();
            try {
                main.add(new ThongKe(850,670));                
            }
                 catch (SQLException e) {
                e.printStackTrace();
            }
            main.repaint();
            main.revalidate();
            break;

            case 3: // THÔNG TIN TÀI KHOẢN HS VÀ GV
                if (flag) {
                    // Thêm 2 btn vào dưới "chức năng 3"
                    navItem.add(4, "Học sinh:KhachHang_20px.png:KhachHang_20px_active.png");
                    navItem.add(5, "Giáo viên:KhachHang_20px.png:KhachHang_20px_active.png");
                    flag = false; // Thông báo là đang Dropdown
                } else {
                    // Xóa 2 btn của "chức năng 3"
                    navItem.remove(4);
                    navItem.remove(5);
                    flag = true; // Thông báo là Dropdown đã ẩn
                }
                outNav(); // Load lại phần Navigation
                break;

            case 4: // Chức năng 3.1: Thông tin tài khoản học sinh
            main.removeAll();
            try {
                main.add(new TTTK_HS(850, 670));
            }
                 catch (SQLException e) {
                e.printStackTrace();
            }
            main.repaint();
            main.revalidate();
            break;

            case 5: // Chức năng 3.2: Thông tin tài khoản giáo viên
            main.removeAll();
            try {
                main.add(new TTTK_GV(850, 670));
            }
                 catch (SQLException e) {
                e.printStackTrace();
            }
            main.repaint();
            main.revalidate();
            break;

            case 6: // NHẬP VÀ XUẤT
                if (flag) {
                    navItem.add(7, "Chức năng 4.1:KhachHang_20px.png:KhachHang_20px_active.png");
                    navItem.add(8, "Chức năng 4.2:KhachHang_20px.png:KhachHang_20px_active.png");
                    flag = false;
                } else {
                    navItem.remove(7);
                    navItem.remove(8);
                    flag = true;
                }
                outNav();
                break;

            // Other cases as needed
        }
    }

    public void outNav() {
        navObj.clear();
        for (int i = 0; i < navItem.size(); i++) {
            String s = navItem.get(i).split(":")[0];
            String icon = navItem.get(i).split(":")[1];
            String iconActive = navItem.get(i).split(":")[2];
            navObj.add(new navItem(s, new Rectangle(0, 200 + 50 * i, 220, 50), icon, iconActive));
            navObj.get(i).addMouseListener(this);
        }
        if (!flag && navObj.size() > 8) // Đổi màu phần DropDown của thống kê
        {
            navObj.get(4).setColorNormal(new Color(86, 94, 127));
            navObj.get(5).setColorNormal(new Color(86, 94, 127));
            navObj.get(6).setColorNormal(new Color(86, 94, 127));
        }

        nav.removeAll();
        JLabel profile = new JLabel(new ImageIcon("./src/image/profile_150px.png"));
        profile.setBounds(0, 0, 220, 200);
        nav.add(profile);
        for (navItem n : navObj) {
            nav.add(n);
        }
        repaint();
        revalidate();
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    // new mainChinhGUI();
    }
}
