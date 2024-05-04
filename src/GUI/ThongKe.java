/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import BUS.HocSinhBUS;
import BUS.KQ_HocSinhCaNamBUS;
import DTO.HocSinhDTO;
import DTO.KQ_HocSinhCaNamDTO;

import java.sql.*;
import java.util.ArrayList;




/**
 *
 * @author PHUONG ANH
 */
public class ThongKe {
    private JFrame f;
    private JPanel topThongKe, selectPanel, radioPanel, dropdownPanel, totalPanel, btnPanel, contentThongKe;
    private JLabel l1, l2;
    private JRadioButton b1, b2, b3;
    private JComboBox<String> c1, c2, c3;
    private JTextField s;
    private JButton showBtn;
    private DefaultTableModel tblModel;
    private JScrollPane scrollPane;
    private JTable t;
    KQ_HocSinhCaNamBUS kq = new KQ_HocSinhCaNamBUS();
    HocSinhBUS hsbus = new HocSinhBUS(1);
    ArrayList <HocSinhDTO> dsHS = hsbus.getList();
    ArrayList <KQ_HocSinhCaNamDTO> dsKQ = kq.getList();
    public ThongKe() throws SQLException {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(850, 670);
        f.setLocationRelativeTo(null);
                f.setResizable(false);
          

        topThongKe = new JPanel();
        topThongKe.setLayout(new BorderLayout());
        topThongKe.setPreferredSize(new Dimension(0, 150));
        topThongKe.setBackground(new Color(180, 204, 227));

        selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
        selectPanel.setOpaque(false);

        l1 = new JLabel("Hiển thị danh sách thống kê theo:                     ");
        l1.setFont(new Font("Arial", Font.BOLD, 16));
        l1.setBorder(new EmptyBorder(10, 0, 0, 0));
        radioPanel = new JPanel();
        radioPanel.setOpaque(false);

        b1 = new JRadioButton("Học lực");
        b2 = new JRadioButton("Hạnh kiểm");
        b3 = new JRadioButton("Học phí");
        
        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        
        b1.setFont(new Font("Arial", Font.PLAIN, 14));
        b2.setFont(new Font("Arial", Font.PLAIN, 14));
        b3.setFont(new Font("Arial", Font.PLAIN, 14));
        b1.setBackground(new Color(180, 204, 227));
        b2.setBackground(new Color(180, 204, 227));
        b3.setBackground(new Color(180, 204, 227));

        dropdownPanel = new JPanel();
        dropdownPanel.setOpaque(false);

        String[] optionc1 = {"Giỏi", "Khá", "Trung bình", "Yếu"};
        c1 = new JComboBox<>(optionc1);
        String[] optionc2 = {"Tốt", "Khá", "Trung bình", "Yếu"};
        c2 = new JComboBox<>(optionc2);
        String[] optionc3 = {"Đã hoàn thành", "Chưa hoàn thành"};
        c3 = new JComboBox<>(optionc3);
        c1.setFont(new Font("Arial", Font.PLAIN, 14));
        c2.setFont(new Font("Arial", Font.PLAIN, 14));
        c3.setFont(new Font("Arial", Font.PLAIN, 14));

        totalPanel = new JPanel();
        totalPanel.setOpaque(false);

        l2 = new JLabel("Tổng số học sinh trong danh sách:");
        l2.setFont(new Font("Arial", Font.BOLD, 14));
        s = new JTextField(4);
        s.setEditable(false);
        s.setHorizontalAlignment(SwingConstants.CENTER);
        

        btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setPreferredSize(new Dimension(80, 0));
        btnPanel.setOpaque(false);
        showBtn = new JButton("Hiển thị");
        showBtn.setPreferredSize(new Dimension(100, 30));
        showBtn.setBackground(new Color(31, 28, 77));
        showBtn.setForeground(Color.WHITE);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        btnPanel.add(showBtn, gbc);
        
        totalPanel.add(l2);
        totalPanel.add(s);
        radioPanel.add(b1);
        radioPanel.add(b2);
        radioPanel.add(b3);
        dropdownPanel.add(c1);
        dropdownPanel.add(c2);
        dropdownPanel.add(c3);
        
        selectPanel.add(l1);
        selectPanel.add(radioPanel);
        selectPanel.add(dropdownPanel);
        selectPanel.add(totalPanel);
        
        topThongKe.add(selectPanel,BorderLayout.CENTER);
        topThongKe.add(btnPanel,BorderLayout.EAST);
        
        f.add(topThongKe,BorderLayout.NORTH);
        
        contentThongKe=new JPanel();
        contentThongKe.setLayout(new BorderLayout());
        contentThongKe.setOpaque(true);
        contentThongKe.add(initTable(), BorderLayout.NORTH);
        
        f.add(contentThongKe, BorderLayout.CENTER);
        
        f.setVisible(true);

        showBtn.addActionListener(new ShowBtnListener());
        }
        
    public JScrollPane initTable() throws SQLException{
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(t);
                scrollPane.setPreferredSize(new Dimension(0,520));

        String[] headers = {"ID", "Tên HS", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ","Hạnh Kiểm", "Học Lực", "Tình trạng học phí"};
        tblModel = new DefaultTableModel();
        for (String header : headers) {
            tblModel.addColumn(header);
        }
        t.setModel(tblModel);
        loaddatatoTable();

        ((DefaultTableCellRenderer)t.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < tblModel.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        return scrollPane;
    }
    
    public void loaddatatoTable(){
        for (HocSinhDTO x  : dsHS){
            String []rowData = new String[]{
                x.getHocSinhID(), x.getTenHocSinh(), x.getGioiTinh(), x.getNgaySinh(), x.getDienThoai(), x.getDiaChi(), kq.getHanhKiemById(x.getHocSinhID()), kq.getHocLucById(x.getHocSinhID()), x.getHocPhi()
            };
            tblModel.addRow(rowData);
        }
        tblModel.fireTableDataChanged();
        s.setText(String.valueOf(dsHS.size()));
    }
    public static void main(String[] args) throws SQLException {
        new ThongKe();
    }

    private class ShowBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
            
        }
        
    }
}
