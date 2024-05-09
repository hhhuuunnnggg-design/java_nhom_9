/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.ChiTietDiemBUS;
import BUS.DTB_HocKyBUS;
import BUS.HocKyBUS;
import BUS.HocSinhBUS;
import BUS.KQ_HocSinhCaNamBUS;
import BUS.LopBUS;
import BUS.MonHocBUS;
import BUS.NamHocBUS;
import BUS.PhanLopBUS;
import DTO.ChiTietDiemDTO;
import DTO.DTB_HocKyDTO;
import DTO.HocKyDTO;
import DTO.HocSinhDTO;
import DTO.KQ_HocSinhCaNamDTO;
import DTO.LopDTO;
import DTO.MonHocDTO;
import DTO.NamHocDTO;
import DTO.PhanLopDTO;



/**
 *
 * @author PHUONG ANH
 */
public class QuanLyDiem extends JPanel{
    private JFrame f;
    private JPanel topPanel, radioPanel, dropdownPanel, selectPanel, totalPanel, btnPanel, contentPanel;
    private JRadioButton b1, b2, b3, b4, b5, b6;
    private JComboBox<String> optionLop, optionMon, optionHe, optionHocky, optionNam;
    private JTextField s, inputID;
    private JLabel l1, l2;
    private JButton filterBtn, addBtn, editBtn, delBtn;
    private DefaultTableModel tblModel;
    private JScrollPane scrollPane;
    private JTable t;

    ArrayList <HocSinhDTO> dshs;
    ArrayList <KQ_HocSinhCaNamDTO> dskq;
    ArrayList<MonHocDTO> dsmon;
    ArrayList<ChiTietDiemDTO> dsct;
    ArrayList<HocKyDTO> dshk;
    ArrayList<DTB_HocKyDTO> dsdtb;
    ArrayList<NamHocDTO> dsnh;
    ArrayList<PhanLopDTO> dspl;
    ArrayList<LopDTO> dslop;
    
    PhanLopBUS plbus = new PhanLopBUS(1);
    LopBUS lopbus = new LopBUS(1);
    HocSinhBUS hsbus = new HocSinhBUS(1);
    MonHocBUS mhbus = new MonHocBUS(1);
    ChiTietDiemBUS ctbus = new ChiTietDiemBUS(1);
    DTB_HocKyBUS dtbbus = new DTB_HocKyBUS(1);
    HocKyBUS hkbus = new HocKyBUS(1);
    KQ_HocSinhCaNamBUS kqbus = new KQ_HocSinhCaNamBUS(1);
    NamHocBUS nhbus = new NamHocBUS(1);
    public QuanLyDiem() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(850, 670);

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 180));
        topPanel.setBackground(new Color(180, 204, 227));

        selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
        selectPanel.setOpaque(false);

        l1 = new JLabel("Hiển thị danh sách điểm theo ");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 100));

        radioPanel = new JPanel();
        radioPanel.setOpaque(false);
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));

        b1 = new JRadioButton("Lớp");
        b2 = new JRadioButton("Môn học");
        b3 = new JRadioButton("Mã HS");
        b4 = new JRadioButton("Hệ điểm");
        b5 = new JRadioButton("Học kỳ");
        b6 = new JRadioButton("Năm học");

        JRadioButton dummyButton = new JRadioButton();
        dummyButton.setVisible(false);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(b1);
        buttonGroup.add(b2);
        buttonGroup.add(b3);
        buttonGroup.add(b4);
        buttonGroup.add(b5);
        buttonGroup.add(b6);
        buttonGroup.add(dummyButton);
        
        JRadioButton[] buttons = {b1, b2, b3, b4, b5, b6};

        Color color = new Color(180, 204, 227);
        for (JRadioButton button : buttons) {
            button.setBackground(color);
        }

        dropdownPanel = new JPanel();
        dropdownPanel.setOpaque(false);
        dropdownPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 36, 0));

        String[] c1 = {"10A1" ,"11A1", "12A1"};
        optionMon = new JComboBox<>(c1);
        String[] c2 = {"Toán", "Lý", "Hóa", "Ngoại ngữ"};
        optionLop = new JComboBox<>(c2);
        inputID = new JTextField(6);
        String[] c3 = {"15 phút", "1 tiết"};
        optionHe = new JComboBox<>(c3);
        String[] c4 = {"HKI", "HKII"};
        optionHocky = new JComboBox<>(c4);
        String[] c5 = {"2023-2024","2024-2025"};
        optionNam = new JComboBox<>(c5);
        totalPanel = new JPanel();
        totalPanel.setOpaque(false);

        l2 = new JLabel("Tổng số học sinh trong danh sách:");
        s = new JTextField(4);
        s.setEditable(false);

        btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(108, 0));
        btnPanel.setOpaque(false);
        btnPanel.setLayout(new GridLayout(5, 1, 0,0));

        filterBtn = new JButton("Lọc");
        addBtn = new JButton("Thêm");
        editBtn = new JButton("Sửa");
        delBtn = new JButton("Xóa");

        filterBtn.setBackground(new Color(31, 28, 77));
        filterBtn.setForeground(Color.WHITE);

        JButton deselectButton = new JButton("Xóa lựa chọn");
        deselectButton.addActionListener(e -> {
            buttonGroup.clearSelection(); // Deselect all buttons
        });

        btnPanel.add(filterBtn);
        btnPanel.add(deselectButton);
        btnPanel.add(addBtn);
        btnPanel.add(editBtn);
        btnPanel.add(delBtn);

        totalPanel.add(l2);
        totalPanel.add(s);

        radioPanel.add(b3);
        radioPanel.add(b2);
        radioPanel.add(b1);
        radioPanel.add(b4);
        radioPanel.add(b5);
        radioPanel.add(b6);
        
        dropdownPanel.add(inputID);
        dropdownPanel.add(optionLop);
        dropdownPanel.add(optionMon);
        dropdownPanel.add(optionHe);
        dropdownPanel.add(optionHocky);
        dropdownPanel.add(optionNam);

        selectPanel.add(l1);
        selectPanel.add(radioPanel);
        selectPanel.add(dropdownPanel);
        selectPanel.add(totalPanel);

        topPanel.add(selectPanel, BorderLayout.CENTER);
        topPanel.add(btnPanel, BorderLayout.EAST);

        f.add(topPanel, BorderLayout.NORTH);

        contentPanel=new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setOpaque(true);
        contentPanel.add(initTable(), BorderLayout.NORTH);
        loaddatatoTable();

        f.add(contentPanel);
        f.setVisible(true);
    }
        
    public JScrollPane initTable(){
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(t);
        scrollPane.setPreferredSize(new Dimension(0,520));

        String [] headers = {"ID", "Tên HS", "Lớp", "Môn Học", "Hệ Điểm","Điểm", "Học Kỳ","ĐiểmTB HK", "Năm Học","ĐiểmTB NH"};
        tblModel = new DefaultTableModel();
        for (String header : headers) {
            tblModel.addColumn(header);
        }
        t.setModel(tblModel);
                
        ((DefaultTableCellRenderer)t.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < tblModel.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        return scrollPane;
    }    

    public void loaddatatoTable(){
        tblModel.setRowCount(0);

        dshs = hsbus.getList();
        dskq = kqbus.getList();
        dsmon = mhbus.getList();
        dsct = ctbus.getList();
        dsdtb = dtbbus.getList();
        dshk = hkbus.getList();
        dsnh = nhbus.getList();
        
        for (HocSinhDTO hs  : dshs){
            String id = hs.getHocSinhID();
            String []rowData = new String[]{
                id,
                hs.getTenHocSinh(),
                lopbus.get(plbus.searchById(id).getLopID()).getTenLop(),
                mhbus.get((ctbus.get(id)).getMonHocID()).getTenMonHoc(),
                (ctbus.get(id)).getHeSoID(), 
                String.valueOf((ctbus.get(id)).getDiem()),
                hkbus.get((dtbbus.get(id)).getHocKyID()).getTenHocKy(), 
                
            }
        }
    }
    public static void main(String[] args) {
        new QuanLyDiem();
    }
}
