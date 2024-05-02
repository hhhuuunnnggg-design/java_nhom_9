import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JDateChooser;

import BUS.QLHS_BUS;
import DTO.HocSinhDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vhuyn
 */
public final class QuanLiHocSinh extends JFrame implements MouseListener, ActionListener {
    private String mahs, hoten, gioitinh, diachi, namsinh, sodienthoai;
    private JLabel lblMahs, lblTenhs, lblGioitinh, lblDiachi, lblimg;
    private JButton btnThem, btnXoa, btnSua, btnFind, btnReset;
    private DefaultTableModel tblmodel;
    // private JTable tbl;
    private JScrollPane scrollpane;
    JTextField[] tf;
    JButton[] buttons;
    JTable t;
    int width, height;
    private JComboBox<String> searchselectBox;
    private final Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    private Color defaultColor;
    private String searchText;
    private JTextField JsearchText;
    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> sorter;
    JDateChooser dateChooser;
    JComboBox<String> genderComboBox;
    QLHS_BUS hsBUS = new QLHS_BUS();

    public QuanLiHocSinh(int width, int height) throws SQLException {
        this.width = width;
        this.height = height;
        init();
        btnThem.addMouseListener(this);
        btnXoa.addMouseListener(this);
        btnSua.addMouseListener(this);
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnFind.addActionListener(this);
        btnFind.addMouseListener(this);
        btnReset.addActionListener(this);
        JsearchText.addMouseListener(this);
    }

    public void init() throws SQLException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color myColor = new Color(99, 116, 198);
        Color searchPanel = new Color(180, 204, 227);
        this.setLayout(new BorderLayout());
        JPanel p3 = SearchHocSinh();
        // p3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0) , 4
        // , true));
        p3.setPreferredSize(new Dimension(0, 60));
        p3.setBackground(searchPanel);

        JPanel p1 = JHocsinh();
        p1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        p1.setBackground(myColor);
        p1.setPreferredSize(new Dimension(0, 200));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(1, 0, 0));
        p2.add(initTable());
        p2.setPreferredSize(new Dimension(0, 340));
        p2.setBackground(Color.gray);

        this.add(p1, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.NORTH);
        this.setSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public JPanel SearchHocSinh() {

        Color btnResets = new Color(52, 48, 128);

        JPanel JSearch = new JPanel();
        JSearch.setLayout(new FlowLayout(1, 10, 5));

        JLabel imgSearch = new JLabel();
        imgSearch.setPreferredSize(new Dimension(50, 50));
        imgSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        String imagePath = "C:\\Users\\vhuyn\\OneDrive\\Documents\\NetBeansProjects\\do_an\\src\\main\\java\\image\\b1_cahoigionvothantre.jpg";

        ImageIcon icon = new ImageIcon(imagePath);

        imgSearch.setIcon(icon);

        JsearchText = new JTextField();
        JsearchText.setPreferredSize(new Dimension(300, 40));

        JLabel lblSearch = new JLabel("Tìm kiếm theo: ");
        lblSearch.setFont(new Font("arial", Font.BOLD, 14));
        String searchOption[] = { "Mã học sinh", "Họ và tên" };
        searchselectBox = new JComboBox<>(searchOption);

        imgSearch.setOpaque(true);
        imgSearch.setIcon(new ImageIcon(""));

        btnReset = new JButton("Reset");
        btnReset.setBackground(btnResets);
        btnReset.setForeground(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 12);
        btnReset.setFont(font);
        btnReset.setPreferredSize(new Dimension(80, 40));
        btnReset.setOpaque(true);

        JSearch.add(imgSearch);
        JSearch.add(JsearchText);
        JSearch.add(lblSearch);
        JSearch.add(searchselectBox);
        JSearch.add(btnReset);

        return JSearch;

    }

    public JPanel JChucnang() {
        Color myColor = new Color(99, 116, 198);
        JPanel Pchucnang = new JPanel();
        Pchucnang.setLayout(new FlowLayout(0, 5, 5));
        Pchucnang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        btnThem = new JButton("Thêm");
        btnThem.setPreferredSize(new Dimension(140, 40));
        btnThem.setBorder(raisedBevel);
        btnXoa = new JButton("Xóa");
        btnXoa.setPreferredSize(new Dimension(140, 40));
        btnXoa.setBorder(raisedBevel);
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(140, 40));
        btnSua.setBorder(raisedBevel);
        btnFind = new JButton("Tìm kiếm");
        btnFind.setPreferredSize(new Dimension(140, 40));
        btnFind.setBorder(raisedBevel);
        Pchucnang.setBackground(myColor);
        defaultColor = btnThem.getBackground();
        Pchucnang.add(btnThem);
        Pchucnang.add(btnXoa);
        Pchucnang.add(btnSua);
        Pchucnang.add(btnFind);
        return Pchucnang;
    }

    // Trong phương thức JHocsinh(), thay thế các phần liên quan đến ngày sinh và
    // giới tính như sau:

    public JPanel JHocsinh() {
        JPanel Phocsinh = new JPanel();
        Phocsinh.setLayout(null);
        String[] arrHocsinh = { "Mã học sinh", "Tên học sinh", "Giới tính", "Năm sinh", "Số điện thoại", "Địa chỉ" };
        int length = arrHocsinh.length;
        tf = new JTextField[length];
        buttons = new JButton[length];
        Phocsinh.setLayout(null);
        int toadoXbutton = 190;
        int toadoYbutton = 10;
        int toadoXTextfield = 330;
        int toadoYTextfield = 10;
        int x = 230;
        int y = 15;
        for (int i = 0; i < arrHocsinh.length; i++) {
            buttons[i] = new JButton(arrHocsinh[i]);
            buttons[i].setBounds(toadoXbutton, toadoYbutton, 120, 30);
            buttons[i].setHorizontalAlignment(JButton.CENTER);
            buttons[i].setName("btn" + i);
            toadoYbutton = toadoYbutton + 35;
            Phocsinh.add(buttons[i]);
            if (i == 3) {
                dateChooser = new JDateChooser();
                dateChooser.setDateFormatString("dd/MM/yyyy");
                dateChooser.setBounds(toadoXTextfield, toadoYTextfield, 320, 30);
                Phocsinh.add(dateChooser);
                toadoYTextfield = toadoYTextfield + 35;

            } else if (i == 2) { // Thay thế TextField của giới tính bằng JComboBox
                String[] genders = { "Nam", "Nữ", "Khác" };
                genderComboBox = new JComboBox<>(genders);
                genderComboBox.setBounds(toadoXTextfield, toadoYTextfield, 320, 30);
                Phocsinh.add(genderComboBox);
                toadoYTextfield = toadoYTextfield + 35;

            } else {
                tf[i] = new JTextField();
                tf[i].setBounds(toadoXTextfield, toadoYTextfield, 320, 30);
                tf[i].setFont(new Font("Arial", Font.BOLD, 12));
                tf[i].setBorder(border);
                tf[i].setName("text" + i);
                toadoYTextfield = toadoYTextfield + 35;
                Phocsinh.add(tf[i]);
            }
            y = y + 35;
        }
        x = x + 180;
        JPanel Pchucnang = JChucnang();
        Pchucnang.setBounds(660, 0, 160, y);
        Phocsinh.add(Pchucnang);

        lblimg = new JLabel();
        lblimg.setBounds(0, 0, 180, y);
        lblimg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        lblimg.setOpaque(true);
        lblimg.setIcon(new ImageIcon(""));
        Phocsinh.add(lblimg);
        Phocsinh.setPreferredSize(new Dimension(x, y));

        return Phocsinh;
    }

    public JScrollPane initTable() throws SQLException {

        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollpane = new JScrollPane(t);
        scrollpane.setPreferredSize(new Dimension(840, 340));
        String[] header = { "Mã học sinh", "Họ và tên", "Giới tính", "Năm sinh", "Địa chỉ", "Số điện thoại",
                "Ảnh chân dung" };

        if (hsBUS.getList() == null)
            hsBUS.listHS();
        ArrayList<HocSinhDTO> hs = hsBUS.getList();
        Object[][] rowData = new Object[hs.size()][7]; // Có 8 cột trong DTO
        for (int i = 0; i < hs.size(); i++) {
            HocSinhDTO student = hs.get(i);
            rowData[i][0] = student.getHocSinhID();
            rowData[i][1] = student.getTenHocSinh(); // Thay vì getHoTen()
            rowData[i][2] = student.getGioiTinh();
            rowData[i][3] = student.getNgaySinh(); // Thay vì getNamSinh()
            rowData[i][4] = student.getDiaChi();
            rowData[i][5] = student.getDienThoai(); // Thay vì getSoDienThoai()
            // rowData[i][6] = student.getHocPhi(); // Thêm cột HocPhi
            rowData[i][6] = student.getIMG(); // Thêm cột IMG
        }

        Font font = new Font("Arial", Font.BOLD, 12);
        t.getTableHeader().setBackground(Color.gray);
        t.getTableHeader().setForeground(Color.WHITE);
        t.getTableHeader().setFont(font);
        tblmodel = new DefaultTableModel(rowData, header);
        t.setModel(tblmodel);
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    tableMouseClicked(evt);
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLiHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        return scrollpane;
    }

    public void addRow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateChooser.getDate();
        String dateString = sdf.format(date); // Convert Date to String

        // Lấy các giá trị từ các trường nhập
        String hocSinhID = tf[0].getText();
        String tenHocSinh = tf[1].getText();
        String gioiTinh = (String) genderComboBox.getSelectedItem();
        String ngaySinh = dateString;
        String diaChi = tf[5].getText();
        String soDienThoai = tf[4].getText();

        HocSinhDTO hocSinh = new HocSinhDTO(hocSinhID, tenHocSinh, gioiTinh, ngaySinh, diaChi,
                Integer.parseInt(soDienThoai), "", "");

        // Gọi phương thức addHS() từ lớp QLHS_BUS để thêm học sinh vào cơ sở dữ liệu
        hsBUS.addHS(hocSinh);

        Object[] rowData = { hocSinhID, tenHocSinh, gioiTinh, ngaySinh, diaChi, soDienThoai };
        tblmodel.addRow(rowData);
        clearTextFields();
    }

    public void deleteRow() {
        int row = t.getSelectedRow();
        if (row != -1) {
            tblmodel.removeRow(row);
        }
        String hocSinhID = tf[0].getText();
        hsBUS.deleteHS(hocSinhID);
        clearTextFields();
    }

    public void updateRow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateChooser.getDate();
        String dateString = sdf.format(date);

        // Lấy các giá trị từ các trường nhập
        String hocSinhID = tf[0].getText();
        String tenHocSinh = tf[1].getText();
        String gioiTinh = (String) genderComboBox.getSelectedItem();
        String ngaySinh = dateString;
        String diaChi = tf[5].getText();
        String soDienThoai = tf[4].getText();

        HocSinhDTO hocSinh = new HocSinhDTO(hocSinhID, tenHocSinh, gioiTinh, ngaySinh, diaChi,
                Integer.parseInt(soDienThoai), "", "");

        // Gọi phương thức addHS() từ lớp QLHS_BUS để thêm học sinh vào cơ sở dữ liệu
        hsBUS.updateHS(hocSinh);

        Object[] rowData = { hocSinhID, tenHocSinh, gioiTinh, ngaySinh, diaChi, soDienThoai };

        int row = t.getSelectedRow();
        tblmodel.removeRow(row);
        tblmodel.addRow(rowData);
        clearTextFields();
    }

    public void clearTextFields() {
        tf[0].setText("");
        tf[1].setText("");
        genderComboBox.setSelectedItem(2);
        dateChooser.setDate(null);
        tf[4].setText("");
        tf[5].setText("");
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) throws ParseException {
        int row = t.getSelectedRow();
        if (row >= 0) {
            mahs = (String) t.getValueAt(row, 0);
            hoten = (String.valueOf(t.getValueAt(row, 1)));
            gioitinh = (String.valueOf(t.getValueAt(row, 2)));
            namsinh = (String.valueOf(t.getValueAt(row, 3)));
            diachi = (String.valueOf(t.getValueAt(row, 4)));
            sodienthoai = (String.valueOf(t.getValueAt(row, 5)));

            tf[0].setText(mahs);
            tf[1].setText(hoten);
            genderComboBox.setSelectedItem(gioitinh);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(namsinh);
            dateChooser.setDate(date);
            tf[4].setText(sodienthoai);
            tf[5].setText(diachi);
        }
    }

    public static void main(String argv[]) throws SQLException {
        QuanLiHocSinh sv = new QuanLiHocSinh(850, 670);
        sv.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == JsearchText) {
            clearTextFields();
        }
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == btnThem) {
            btnThem.setBackground(Color.red);
        }
        if (e.getSource() == btnXoa) {
            btnXoa.setBackground(Color.red);
        }
        if (e.getSource() == btnSua) {
            btnSua.setBackground(Color.red);
        }
        if (e.getSource() == btnFind) {
            btnFind.setBackground(Color.red);
        }
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == btnThem) {
            btnThem.setBackground(defaultColor);
        } else if (e.getSource() == btnXoa) {
            btnXoa.setBackground(defaultColor);
        } else if (e.getSource() == btnSua) {
            btnSua.setBackground(defaultColor);
        } else if (e.getSource() == btnFind) {
            btnFind.setBackground(defaultColor);
        }
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThem) {
            JOptionPane.showMessageDialog(this,
                    "Thêm thành công",
                    "Chức năng thêm",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Ban chon them");
            tf[0].requestFocus();
            addRow();
        } else if (e.getSource() == btnSua) {
            updateRow();
            JOptionPane.showMessageDialog(this,
                    "Sửa thành công",
                    "Chức năng Sửa",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnXoa) {

            int result = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc muốn xóa thành viên này",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION,

                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                System.out.println("Ban chon đồn ý xóa");
                deleteRow();
            } else if (result == JOptionPane.NO_OPTION) {
                System.out.println("Bạn chọn không đồng ý xóa");
            }
        } else if (e.getSource() == btnFind) {
            searchText = JsearchText.getText().trim();
            String selectedOption = (String) searchselectBox.getSelectedItem();
            if (searchText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Vui lòng nhập thông tin tìm kiếm",
                        "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            model = (DefaultTableModel) t.getModel();
            sorter = new TableRowSorter<>(model);
            t.setRowSorter(sorter);
            if (selectedOption.equals("Mã học sinh")) {
                sorter.setRowFilter(RowFilter.regexFilter(searchText, 0));
            } else if (selectedOption.equals("Họ và tên")) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 1));
            }
        } else if (e.getSource() == btnReset) {
            JsearchText.setText("");
            clearTextFields();
            model = (DefaultTableModel) t.getModel();
            sorter = new TableRowSorter<>(model);
            t.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter("", 0));
        }
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
