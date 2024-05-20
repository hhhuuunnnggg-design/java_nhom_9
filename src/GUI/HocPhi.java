package GUI;
//import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BUS.ChiTietDiemBUS;
import BUS.DTB_HocKyBUS;
import BUS.HocKyBUS;
import BUS.HocPhiBUS;
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
import DTO.HocPhiDTO;
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
    String outputID, outputTenHS, outputLop, outputNgaySinh, outputSDT, outputHocPhi, outputStatus, outputTime;

    ArrayList <HocSinhDTO> dshs;
    ArrayList <KQ_HocSinhCaNamDTO> dskq;
    ArrayList<MonHocDTO> dsmon;
    ArrayList<ChiTietDiemDTO> dsct;
    ArrayList<HocKyDTO> dshk;
    ArrayList<DTB_HocKyDTO> dsdtb;
    ArrayList<NamHocDTO> dsnh;
    ArrayList<PhanLopDTO> dspl;
    ArrayList<LopDTO> dslop;
    ArrayList<HocPhiDTO> dshp;
    
    PhanLopBUS plbus = new PhanLopBUS(1);
    LopBUS lopbus = new LopBUS(1);
    HocSinhBUS hsbus = new HocSinhBUS(1);
    MonHocBUS mhbus = new MonHocBUS(1);
    ChiTietDiemBUS ctbus = new ChiTietDiemBUS(1);
    DTB_HocKyBUS dtbbus = new DTB_HocKyBUS(1);
    HocKyBUS hkbus = new HocKyBUS(1);
    KQ_HocSinhCaNamBUS kqbus = new KQ_HocSinhCaNamBUS(1);
    NamHocBUS nhbus = new NamHocBUS(1);
    HocPhiBUS hpbus = new HocPhiBUS(1);

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
        mainTop.setBackground(new Color(180, 204, 227));
        mainTop.setOpaque(true);

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setOpaque(false);
        l1 = new JLabel("Danh sách hiển thị theo:");
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        option1 = new JComboBox<>(new String[] { "Mã HS", "Tên HS" });
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

        optionHP = new JComboBox<>(new String[] { "Tất cả", "Chưa thanh toán", "Đã thanh toán" }); // Replace with your
                                                                                                   // options

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
        btPanel.setPreferredSize(new Dimension(150, 0));
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
        //settingBtn.addActionListener(new SettingBtnListener());
        btPanel.add(filterBtn, gbc);
        gbc.gridy = 1;
        //btPanel.add(settingBtn, gbc);

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
        detailBtn.addActionListener(new DetailBtnListener());
        confirmBtn = new JButton("Confirm");

        detailBtn.setPreferredSize(new Dimension(100, 30));
        confirmBtn.setPreferredSize(new Dimension(100, 30));
        confirmBtn.addActionListener(new ConfirmBtnListener());
        confirmBtn.setVisible(false);
        detailBtn.setVisible(false);


        btnMid.add(detailBtn, gbcBtnMid);
        gbcBtnMid.gridy = 1;
        btnMid.add(confirmBtn, gbcBtnMid);

        midPanel.add(btnMid, BorderLayout.EAST);
        
        f.add(initTable(), BorderLayout.SOUTH);

        // Then load data into the table
        loaddatatoTable();

        // Add other panels
        f.add(mainTop, BorderLayout.NORTH);
        f.add(midPanel, BorderLayout.CENTER);
        f.setVisible(true);
    }


    public JScrollPane initTable() {
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(t);
        scrollPane.setPreferredSize(new Dimension(0, 300));
        
        String[] headers = {"ID HS", "Họ Tên", "Lớp", "Ngày Sinh", "SDT", "Học Phí", "Tình trạng học phí", "Thời gian thanh toán"};
        tblModel = new DefaultTableModel(headers, 0); // Initialize tblModel with column headers only
        t.setModel(tblModel); // Set tblModel to the table after initializing it
        
        // Set preferred column widths
        t.getColumnModel().getColumn(0).setPreferredWidth(80);
        t.getColumnModel().getColumn(1).setPreferredWidth(180);
        t.getColumnModel().getColumn(2).setPreferredWidth(60);
        t.getColumnModel().getColumn(3).setPreferredWidth(100);
        t.getColumnModel().getColumn(4).setPreferredWidth(120);
        t.getColumnModel().getColumn(5).setPreferredWidth(100);
        t.getColumnModel().getColumn(6).setPreferredWidth(150);
        t.getColumnModel().getColumn(7).setPreferredWidth(150); // New column
        
        t.setRowHeight(40);
        JTableHeader header = t.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setBackground(new Color(31, 28, 77));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD, 12));

        ((DefaultTableCellRenderer)t.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblModel.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    tableMouseClicked(evt);
                } catch (ParseException ex) {
                    Logger.getLogger(HocPhi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return scrollPane;
    }
    
    
    protected void tableMouseClicked(java.awt.event.MouseEvent e) throws ParseException {
        int row = t.getSelectedRow();
        outputID = (String) t.getValueAt(row, 0);
        outputTenHS = (String) t.getValueAt(row, 1);
        outputLop = (String) t.getValueAt(row, 2);
        outputNgaySinh = (String) t.getValueAt(row, 3);
        outputSDT = (String) t.getValueAt(row, 4);
        outputHocPhi = (String) t.getValueAt(row, 5);
        outputStatus = (String) t.getValueAt(row, 6);
        outputTime = (String) t.getValueAt(row, 7);
    
        // Set text fields with corresponding values
        txthoten.setText(outputTenHS);
        txtlop.setText(outputLop);
        txtngaysinh.setText(outputNgaySinh);
        txtdienthoai.setText(outputSDT);
        txtStatus.setText(outputStatus);
        txtFee.setText("1.850.000"); // Set a fixed value
    
        if (outputStatus.equals("Chưa thanh toán")) {
            confirmBtn.setVisible(true);
            confirmBtn.setForeground(Color.WHITE); // Set text color to white
            confirmBtn.setBackground(new Color(255, 49, 49)); // Set background color to RGB(255,49,49)
            detailBtn.setVisible(true);

        } else {
            confirmBtn.setVisible(false);
            detailBtn.setVisible(true);

        }
    }
    
    private class ConfirmBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int choice = JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán cho tài khoản "+outputID+" ?","", JOptionPane.OK_CANCEL_OPTION);
                          
            String idnam = null;
            for (NamHocDTO nh : dsnh){
                if(nh.getNamHocBatDau()==namhientai){
                    System.out.println("so sanh nam ConfirmBtnListener");
                    idnam = nh.getNamHocID();
                    System.out.println("id nam "+idnam);
                    break;
                }
            }

            if (choice == JOptionPane.OK_OPTION){

                currTime = new CurrentDateTime();
                outputTime= currTime.getFormatDateTime();
                HocPhiDTO hp = new HocPhiDTO(outputID, idnam,outputTime ,1);
                hpbus.add(hp);
                System.out.println("up data to hoc phi");
    
                JOptionPane.showMessageDialog(f, "Thanh toán thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                Object[] rowData = {outputID, outputTenHS, outputLop, outputNgaySinh, outputSDT, "1.850.000", "Đã thanh toán",outputTime};
                int row = t.getSelectedRow();
                tblModel.removeRow(row);
                tblModel.addRow(rowData);

            }else{
                return;
            }
            resetOutput();
            
        }
    }
    
    
    private void resetOutput() {
        outputID = "";
        outputTenHS = "";
        outputLop = "";
        outputNgaySinh = "";
        outputSDT = "";
        outputHocPhi = "";
        outputStatus = "";
        outputTime = "";
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
                System.out.println("id nam "+idnam);
                break;
            }
        }
        for (HocSinhDTO hs : dshs){

            String idhs = hs.getHocSinhID();
            System.out.println("id hoc sinh"+idhs);
            if(plbus.get(idhs, idnam) != null){

                String thoigian = hpbus.get(idhs, idnam)!=null?hpbus.get(idhs, idnam).getThoigian():"";
                String status = hpbus.get(idhs, idnam)!=null?String.valueOf(hpbus.get(idhs, idnam).getStatus()):"";
                
                String[] rowData = new String[]{
                    idhs,
                    hs.getTenHocSinh(),
                    lopbus.get(plbus.get(idhs,idnam).getLopID()).getTenLop(),
                    hs.getNgaySinh(), 
                    hs.getDienThoai(),
                    "1.850.000",
                    hs.getHocPhi(),
                    thoigian,
                    status
                };
                tblModel.addRow(rowData);
            } 
        }
        tblModel.fireTableDataChanged();
    }

    private class DetailBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a JPanel to add to the JOptionPane
            JPanel panel =createFeePanel();
            JOptionPane.showMessageDialog(null, panel, "Chi Tiết Học Phí", JOptionPane.PLAIN_MESSAGE);
            
        }
    }
    private JPanel createFeePanel() {
        JPanel midFee = new JPanel(new GridBagLayout());
        String[] a = {"Học phí cơ bản:", "Phí Cơ sở Vật chất:", "Lệ phí thi:", "Phí Sinh hoạt Ngoại khóa:"};
        String[] v = {"1.500.000d", "200.000d", "50.000d", "100.000d"};
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel(a[i]);
            label.setFont(new Font("Arial", Font.BOLD, 17));
            gbc.gridx = 0;
            gbc.gridy = i;
            midFee.add(label, gbc);
        }
        gbc.anchor = GridBagConstraints.EAST;
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel(v[i]);
            label.setFont(new Font("Arial", Font.PLAIN, 17));
            gbc.gridx = 1;
            gbc.gridy = i;
            midFee.add(label, gbc);
        }
        
        // Add the "Tổng cộng" label
        JLabel totalLabel = new JLabel("Tổng cộng:   1.850.000d");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 17));
        totalLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 4; // Add after the last row
        gbc.gridwidth = 2; // Span across both columns
        gbc.anchor = GridBagConstraints.CENTER;
        midFee.add(totalLabel, gbc);
    
        return midFee;
    }
    
    // public class SettingBtnListener implements ActionListener {

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         // Create a JXDatePicker
    //         JXDatePicker datePicker = new JXDatePicker();
    //         // Set the minimum date to today
    //         datePicker.setDate(new Date());
    //         datePicker.setFormats("yyyy-MM-dd");
    
    //         // Create a JPanel to hold the datePicker
    //         JPanel panel = new JPanel();
    //         panel.add(datePicker);
    
    //         // Show a JOptionPane with the datePicker panel
    //         int result = JOptionPane.showConfirmDialog(null, panel, "Select a date", JOptionPane.OK_CANCEL_OPTION);
    //         if (result == JOptionPane.OK_OPTION) {
    //             // Get the selected date
    //             Date selectedDate = datePicker.getDate();
    //             LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
    //             // Compare selected date with today
    //             LocalDate currentDate = LocalDate.now();
    //             if (selectedLocalDate.isAfter(currentDate)) {
    //                 // Show confirmation dialog
    //                 int confirmation = JOptionPane.showConfirmDialog(null,
    //                         "Are you sure you want to choose this date?", "Confirmation", JOptionPane.YES_NO_OPTION);
    //                 if (confirmation == JOptionPane.YES_OPTION) {
    //                     // User confirmed, do something with the selected date
    //                     System.out.println("Selected date: " + selectedLocalDate);
    //                 }
    //             } else {
    //                 // Selected date is not valid
    //                 JOptionPane.showMessageDialog(null, "Please select a date after today.");
    //             }
    //         }
    //     }
    // }
    public static void main(String[] args) {
        new HocPhi();
    }
}
