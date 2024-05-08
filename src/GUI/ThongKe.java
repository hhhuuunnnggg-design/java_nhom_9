/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package GUI;
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
    private JLabel b1, b2, b3;
    private JComboBox<String> optionHL, optionHK, optionHP;
    private JTextField s;
    private JButton showBtn;
    private DefaultTableModel tblModel;
    private JScrollPane scrollPane;
    private JTable t;
    KQ_HocSinhCaNamBUS kq = new KQ_HocSinhCaNamBUS(1);
    HocSinhBUS hsbus = new HocSinhBUS(1);
    ArrayList <HocSinhDTO> dsHS;
    ArrayList <KQ_HocSinhCaNamDTO> dsKQ;
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
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBorder(new EmptyBorder(10, 0, 0, 0));
        radioPanel = new JPanel();
        radioPanel.setOpaque(false);

        b1 = new JLabel("Học lực");
        b2 = new JLabel("Hạnh kiểm");
        b3 = new JLabel("Học phí");
        
        b1.setFont(new Font("Arial", Font.PLAIN, 16));
        b2.setFont(new Font("Arial", Font.PLAIN, 16));
        b3.setFont(new Font("Arial", Font.PLAIN, 16));
        int topMargin = 10;
        int leftMargin = 10;
        int bottomMargin = 0;
        int rightMargin = 35;
        b1.setBorder(new EmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));
        b2.setBorder(new EmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));
        b3.setBorder(new EmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));

        dropdownPanel = new JPanel();
        dropdownPanel.setOpaque(false);

        String[] option1 = {"Tất cả","Giỏi", "Khá", "Trung bình", "Yếu"};
        optionHL = new JComboBox<>(option1);
        String[] option2 = {"Tất cả","Tốt", "Khá", "Trung bình", "Yếu"};
        optionHK = new JComboBox<>(option2);
        String[] option3 = {"Tất cả","Đã thanh toán", "Chưa thanh toán"};
        optionHP = new JComboBox<>(option3);
        optionHL.setFont(new Font("Arial", Font.PLAIN, 14));
        optionHK.setFont(new Font("Arial", Font.PLAIN, 14));
        optionHP.setFont(new Font("Arial", Font.PLAIN, 14));

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
        dropdownPanel.add(optionHL);
        dropdownPanel.add(optionHK);
        dropdownPanel.add(optionHP);
        
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
        loaddatatoTable();

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

        dsHS = hsbus.getList();
        dsKQ = kq.getList();
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
            tblModel.setRowCount(0);
            
            String hocluc = (String) optionHL.getSelectedItem();
            String hanhkiem = (String) optionHK.getSelectedItem();
            String hocphi = (String) optionHP.getSelectedItem();
            dsHS = hsbus.search(null,null,null,null,null,null,  hocphi);
            dsKQ = kq.search(null, null, hocluc, hanhkiem,0.0f,null);
            for (HocSinhDTO x : dsHS){
                for(KQ_HocSinhCaNamDTO y : dsKQ){
                    if(x.getHocSinhID().equals(y.getHocSinhID())){
                        String []rowData = new String[]{
                            x.getHocSinhID(), x.getTenHocSinh(), x.getGioiTinh(), x.getNgaySinh(), x.getDienThoai(), x.getDiaChi(), y.getHanhKiem(), y.getHocLuc(), x.getHocPhi()
                        };
                        tblModel.addRow(rowData);
                    }
                }
            }
            s.setText(String.valueOf(tblModel.getRowCount()));
            if (tblModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu ");
            }    
        }
    }
        
}

