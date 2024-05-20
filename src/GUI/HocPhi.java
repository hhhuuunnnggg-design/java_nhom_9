package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
import DTO.CurrentDateTime;
import DTO.DTB_HocKyDTO;
import DTO.HocKyDTO;
import DTO.HocSinhDTO;
import DTO.KQ_HocSinhCaNamDTO;
import DTO.LopDTO;
import DTO.MonHocDTO;
import DTO.NamHocDTO;
import DTO.PhanLopDTO;

public class HocPhi {
    JFrame f;
    JPanel topPanel, btPanel, mainTop, midPanel, mainMid, btnMid;
    JLabel l1, labelLop, l2, l3;
    JComboBox<String> option1, optionLop, optionHP; 
    JTextField txtIdName, txthoten, txtlop, txtngaysinh, txtdienthoai, txtStatus, txtFee;
    JButton filterBtn, settingBtn, detailBtn, confirmBtn;
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

    CurrentDateTime currTime = new CurrentDateTime();
    int namhientai = currTime.getYear();
    public HocPhi() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(850, 670);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        
        mainTop = new JPanel();
        mainTop.setLayout(new BorderLayout());
        mainTop.setPreferredSize(new Dimension(0, 110));
        mainTop.setBackground(new Color(180,204,227));
        mainTop.setOpaque(true);

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setOpaque(false);
        l1 = new JLabel("Danh sách hiển thị theo:");
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        option1 = new JComboBox<>(new String[]{"Mã HS", "Tên HS"});
        labelLop = new JLabel("Lớp:");
        optionLop = new JComboBox<>();
        dslop = lopbus.getList();
        optionLop.addItem("Tất cả");
        for (LopDTO lop : dslop) {
            String tenlop = lop.getTenLop();
            optionLop.addItem(tenlop); // Use addItem() method instead of add()
        }
        txtIdName = new JTextField();
        
        l3 = new JLabel("Tình trạng học phí:");

        optionHP = new JComboBox<>(new String[]{"Tất cả", "Chưa thanh toán", "Đã thanh toán"}); // Replace with your options

        int xOffset = 60;

        l1.setBounds(20, 45, 250, 30);
        option1.setBounds(170 + xOffset, 20, 120, 30);
        txtIdName.setBounds(170 + xOffset, 60, 120, 30);
        labelLop.setBounds(370 + xOffset, 20, 150, 30);
        optionLop.setBounds(330 + xOffset, 60, 120, 30);
        l3.setBounds(490 + xOffset, 20, 120, 30);
        optionHP.setBounds(480 + xOffset, 60, 120, 30);

        // Center the text of combo boxes
        ((JLabel) option1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) optionLop.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel) optionHP.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(l1);
        topPanel.add(option1);
        topPanel.add(txtIdName);
        topPanel.add(labelLop);
        topPanel.add(optionLop);
        topPanel.add(l3);
        topPanel.add(optionHP);

                
        btPanel = new JPanel(new GridBagLayout());
        btPanel.setOpaque(false);
        btPanel.setPreferredSize(new Dimension(150,0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        
        filterBtn = new JButton("Filter");
        settingBtn = new JButton("Setting");

        filterBtn.setPreferredSize(new Dimension(100, 30));
        settingBtn.setPreferredSize(new Dimension(100, 30));

        btPanel.add(filterBtn, gbc);
        gbc.gridy = 1;
        btPanel.add(settingBtn, gbc);

        mainTop.add(topPanel);
        mainTop.add(btPanel, BorderLayout.EAST);

        midPanel = new JPanel(new BorderLayout());
        mainMid = new JPanel(new GridLayout(0, 2)); // 2 columns
        JLabel lblHoten = new JLabel("Họ tên:");
        lblHoten.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and style
        lblHoten.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
        
        JLabel lblLop = new JLabel("Lớp:");
        lblLop.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and style
        lblLop.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
        
        JLabel lblNgaysinh = new JLabel("Ngày Sinh:");
        lblNgaysinh.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and style
        lblNgaysinh.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
        
        JLabel lblDienthoai = new JLabel("SDT:");
        lblDienthoai.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and style
        lblDienthoai.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
        
        JLabel lblStatus = new JLabel("Tình trạng học phí:");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and style
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
        
        JLabel lblFee = new JLabel("Học phí:");
        lblFee.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and style
        lblFee.setHorizontalAlignment(SwingConstants.CENTER); 

        txthoten = new JTextField(10);
        txtlop = new JTextField(10);
        txtngaysinh = new JTextField(10);
        txtdienthoai = new JTextField(10);
        txtStatus = new JTextField(10);
        txtFee = new JTextField(10);

        // Add labels and text fields to mainMid
        mainMid.add(lblHoten);
        mainMid.add(txthoten);
        mainMid.add(lblLop);
        mainMid.add(txtlop);
        mainMid.add(lblNgaysinh);
        mainMid.add(txtngaysinh);
        mainMid.add(lblDienthoai);
        mainMid.add(txtdienthoai);
        mainMid.add(lblFee);
        mainMid.add(txtFee);
        mainMid.add(lblStatus);
        mainMid.add(txtStatus);

        midPanel.add(mainMid, BorderLayout.CENTER);

        btnMid = new JPanel(new GridBagLayout());
        btnMid.setOpaque(false);
        btnMid.setPreferredSize(new Dimension(150, 0));
        GridBagConstraints gbcBtnMid = new GridBagConstraints();
        gbcBtnMid.gridx = 0;
        gbcBtnMid.gridy = 0;
        gbcBtnMid.weighty = 1;
        gbcBtnMid.insets = new Insets(5, 0, 0, 0);
        gbcBtnMid.anchor = GridBagConstraints.CENTER;

        detailBtn = new JButton("Detail");
        confirmBtn = new JButton("Confirm");

        detailBtn.setPreferredSize(new Dimension(100, 30));
        confirmBtn.setPreferredSize(new Dimension(100, 30));

        btnMid.add(detailBtn, gbcBtnMid);
        gbcBtnMid.gridy = 1;
        btnMid.add(confirmBtn, gbcBtnMid);

        midPanel.add(btnMid, BorderLayout.EAST);
        
        f.add(mainTop, BorderLayout.NORTH);
        f.add(midPanel, BorderLayout.CENTER);
        f.add(initTable(), BorderLayout.SOUTH);
        // loaddatatoTable();
        f.setVisible(true);
    }


    private void loaddatatoTable() {
        tblModel.setRowCount(0);

    dshs = hsbus.getList();
    dskq = kqbus.getList();
    dsmon = mhbus.getList();
    dsct = ctbus.getList();
    dsdtb = dtbbus.getList();
    dshk = hkbus.getList();
    dsnh = nhbus.getList();

    String idnam = null;
    for (NamHocDTO nh : dsnh){
        if(nh.getNamHocBatDau()==namhientai){
            System.out.println("so sanh nam");
            idnam = nh.getNamHocID();
            break;
        }
    }

    for (HocSinhDTO hs : dshs){

        String idhs = hs.getHocSinhID();
        if(plbus.get(idhs, idnam) != null)
            continue;
        else break;
        String[] rowData = new String[]{
            
        };
        }
    }


    public JScrollPane initTable() {
        JTable anotherTable = new JTable();
        anotherTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane anotherScrollPane = new JScrollPane(anotherTable);
        anotherScrollPane.setPreferredSize(new Dimension(0, 300));
        
        String[] headers = {"ID HS", "Họ Tên", "Lớp", "Ngày Sinh", "SDT", "Học Phí", "Tình trạng học phí", "Thời gian thanh toán"};
        int editableColumnIndex = 5; // Index of the "Học Phí" column
        NonEditableTableModel anotherTableModel = new NonEditableTableModel(headers, 0, editableColumnIndex);
        anotherTable.setModel(anotherTableModel);
        
        // Set preferred column widths
        anotherTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        anotherTable.getColumnModel().getColumn(1).setPreferredWidth(180);
        anotherTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        anotherTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        anotherTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        anotherTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        anotherTable.getColumnModel().getColumn(6).setPreferredWidth(150);
        anotherTable.getColumnModel().getColumn(7).setPreferredWidth(150); // New column
        
        anotherTable.setRowHeight(40);
        JTableHeader header = anotherTable.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setBackground(new Color(31, 28, 77));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD, 12));
    
        ((DefaultTableCellRenderer)anotherTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < anotherTableModel.getColumnCount(); i++) {
            anotherTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        return anotherScrollPane;
    }
    
    public static void main(String[] args) {
        new HocPhi();
    }
}
