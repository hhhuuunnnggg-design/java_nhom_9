package GUI;

import javax.swing.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import BUS.QLHS_BUS;
import BUS.phanquyenBUS;
import DTO.chitietquyenDTO;
import DTO.chucnangDTO;
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
public class Text extends JFrame implements MouseListener {
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
    private QLHS_BUS qlhsBUS;
    private phanquyenBUS pqBUS;

    ArrayList<chitietquyenDTO> listChitietquyen;
    ArrayList<chucnangDTO> listchucnang;
    ArrayList<String> macn;

    public Text(String username) throws SQLException {
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

        String maquyen = qlhsBUS.getRole(userName);
        System.out.println("mã quyền là " + maquyen);

        if (!maquyen.isEmpty()) {

            navObj = new ArrayList<>();

            nav = new JPanel(null);
            Color my_color_jleft = new Color(50, 48, 128);
            nav.setBackground(my_color_jleft);
            nav.setPreferredSize(new Dimension(220, DEFAULT_HEIGHT));

            JScrollPane scroll = new JScrollPane(nav);
            scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1, 100));
            scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);

            pqBUS = new phanquyenBUS();
            pqBUS.listChiTietQuyen(maquyen);
            listChitietquyen = new ArrayList<>();
            listChitietquyen = pqBUS.getListchitietquyen();

            pqBUS.listchucnang();
            listchucnang = new ArrayList<>();
            listchucnang = pqBUS.getlistchucnang();

            navItem = new ArrayList<>();

            for (int i = 0; i < listChitietquyen.size(); i++) {
                chitietquyenDTO ctq = listChitietquyen.get(i);

                for (int j = 0; j < listchucnang.size(); j++) {
                    chucnangDTO cn = listchucnang.get(j);
                    if (ctq.getMachucnang().equals(cn.getMachucnang())) {
                        System.out.println(cn.getTenchucnang());
                        String text = cn.getTenchucnang() + ":Shop_20px.png:Shop_20px_active.png";
                        navItem.add(text);
                        macn = new ArrayList<>();
                        macn.add(cn.getMachucnang());
                    }
                }
            }
            // navItem.add("Quản lý giáo viên :Shop_20px.png:Shop_20px_active.png");
            // navItem.add("Quản Lý Học Sinh:QLSP_20px.png:QLSP_20px_active.png");
            // navItem.add("Thống kê:NhanVien_20px.png:NhanVien_20px_active.png");
            // navItem.add("Đổi Password:KhachHang_20px.png:KhachHang_20px_active.png");
            // navItem.add("Thanh toán học phí:ThongKe_20px.png:ThongKe_20px_active.png");
            // navItem.add("Quản lý điểm:CongCu_20px.png:CongCu_20px_active.png");
            System.out.println(navItem);
            outNav();

            main = new JPanel(null);
            main.setBackground(Color.white);
            navObj.get(0).doActive();
            changeMainInfo("CN1");

            add(header, BorderLayout.NORTH);
            add(scroll, BorderLayout.WEST);
            add(main, BorderLayout.CENTER);

            setVisible(true);
        }

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for (int i = 0; i < navObj.size(); i++) {
            navItem item = navObj.get(i); // lấy vị trí item trong menu
            if (e.getSource() == item) {
                item.doActive(); // Active NavItem đc chọn
                String ma = macn.get(i);
                changeMainInfo(ma);
            } else {
                item.noActive();
            }
        }

    }

    public void changeMainInfo(String macn) {
        switch (macn) {
            case "CN1": // QUẢN LÝ Giao Vien
                main.removeAll();
                try {
                    main.add(new QLGV(850, 670));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break;

            case "CN2": // QUẢN LÝ Hoc Sinh
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

            case "CN3": // THỐNG KÊ
                main.removeAll();
                try {
                    main.add(new ThongKe(850, 670));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break;

            case "CN4":
                main.removeAll();
                main.add(new ChangeAccount(850, 670));
                main.repaint();
                main.revalidate();
                break;

            case "CN5":
                main.removeAll();
                main.add(new ThanhToanHocPhi());
                main.repaint();
                main.revalidate();
                break;

            case "CN7":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN8":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN9":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN10":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN11":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN12":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN13":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN14":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN15":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN16":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN17": //Đổi mật khẩu HS/GV
                main.removeAll();
                main.add(new DoiMK(850, 670, userName));
                main.repaint();
                main.revalidate();
                break;
            case "CN18": //Xem điểm HS
                main.removeAll();
                try {
                    main.add(new diemHS(userName));
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break;
            case "CN19":
                main.removeAll();
                main.add(new QuanLyDiem(850, 670));
                main.repaint();
                main.revalidate();
                break;
            case "CN20": // Xem thông tin tài khoản HS
                main.removeAll();
                try {
                    main.add(new TTTK_HS(850, 670, userName));
                } catch (SQLException e) {
                    System.out.println("khong vao duoc");
                    e.printStackTrace();
                }
                main.repaint();
                main.revalidate();
                break; 
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

    }
}
