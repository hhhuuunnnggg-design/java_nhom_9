/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.sql.*;


/**
 *
 * @author PHUONG ANH
 */
public class ThongKe extends JPanel{

    private JPanel topThongke, selectPanel, radioPanel, dropdownPanel, totalPanel, btnPanel, contentThongke;
    private JLabel l1, l2;
    private JRadioButton b1, b2, b3;
    private JComboBox<String> c1, c2, c3;
    private JTextField s;
    private JButton filterBtn;
    private DefaultTableModel tblModel;
    private JScrollPane scrollPane;
    private JTable t;
    public ThongKe() throws SQLException {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(850, 670));
          

        topThongke = new JPanel();
        topThongke.setLayout(new BorderLayout());
        topThongke.setPreferredSize(new Dimension(0, 150));
        topThongke.setBackground(new Color(180, 204, 227));

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

        btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setPreferredSize(new Dimension(150, 0));
        btnPanel.setOpaque(false);
        filterBtn = new JButton("Lọc");
        filterBtn.setPreferredSize(new Dimension(70, 30));
        filterBtn.setBackground(new Color(31, 28, 77));
        filterBtn.setForeground(Color.WHITE);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        btnPanel.add(filterBtn, gbc);
        
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
        
        topThongke.add(selectPanel,BorderLayout.CENTER);
        topThongke.add(btnPanel,BorderLayout.EAST);
        
        this.add(topThongke,BorderLayout.NORTH);
        
        contentThongke=new JPanel();
        contentThongke.setLayout(new BorderLayout());
        contentThongke.setOpaque(true);
        contentThongke.add(initTable(), BorderLayout.NORTH);
        
        this.add(contentThongke, BorderLayout.CENTER);

        }
        
    public JScrollPane initTable() throws SQLException{
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(t);
                scrollPane.setPreferredSize(new Dimension(0,520));

        String[] headers = {"ID", "Ten HS", "Gioi tinh", "Ngay sinh", "Dien thoai", "Dia chi"};
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
    public void loaddatatoTable() throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/student_management?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user="admin";
            String password="1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mydb = DriverManager.getConnection(url, user, password);
            
            String sql="SELECT * FROM hocsinh";
            PreparedStatement pst=mydb.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            
            tblModel.setRowCount(0);
            
            while(rs.next()){
                String [] rowData=new String[]{
                    rs.getString("HocSinhid"),rs.getString("hovaten"), rs.getString("gioiTinh"), rs.getString("ngaySinh").toString(), rs.getString("DienThoai"), rs.getString("diaChi")
                };
                tblModel.addRow(rowData);
            }
            
            tblModel.fireTableDataChanged();
            mydb.close();
            
        }catch(SQLException| ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }    


}
