package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableRowSorter;
import java.util.List;
import java.util.ArrayList;

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

import java.awt.*;
import java.util.ArrayList;
import java.sql.*;

public class diemHS extends JPanel {
    private JPanel topPanel, radioPanel, dropdownPanel, selectPanel, btnPanel, diemPanel, loaiPanel;
    private JLabel b1, b2, b3, jl1, jl2, jl3, jl4;
    private JTextField tf1, tf2, tf3, tf4;
    private JComboBox<String> c1, c2, c3;
    private JLabel l1;
    private JButton filterBtn;
    private JScrollPane scrollPane;
    private JTable t;
    private DefaultTableModel tblModel;
    private String mahocsinh;
    private String HKY;
    private String NH;
    ArrayList<HocSinhDTO> dshs;
    ArrayList<KQ_HocSinhCaNamDTO> dskq;
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
    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> sorter;

    public diemHS(String mahocsinh) throws SQLException {
        this.mahocsinh = mahocsinh;
        setLayout(new BorderLayout());
        setSize(850, 670);

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 100));
        topPanel.setBackground(new Color(180, 204, 227));

        selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
        selectPanel.setOpaque(false);

        l1 = new JLabel("Xem điểm theo:              ");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBorder(BorderFactory.createEmptyBorder(10, 250, 0, 0));

        radioPanel = new JPanel();
        radioPanel.setOpaque(false);
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

        b1 = new JLabel("Môn học");
        b2 = new JLabel("Học kỳ");
        b3 = new JLabel("Năm học");
        b1.setBackground(new Color(180, 204, 227));
        b2.setBackground(new Color(180, 204, 227));
        b3.setBackground(new Color(180, 204, 227));

        dropdownPanel = new JPanel();
        dropdownPanel.setOpaque(false);
        dropdownPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        dropdownPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        String[] optionc1 = {"Tất cả", "Toán", "Vật Lý", "Hóa Học", "Anh Văn"};
        c1 = new JComboBox<>(optionc1);

        dshk = hkbus.getList();
        c2 = new JComboBox<>();
        List<HocKyDTO> dshk = hkbus.getList();
        c2.addItem("Tất cả");
        for (HocKyDTO hk : dshk) {
            c2.addItem(hk.getTenHocKy());
        }

        dshk = hkbus.getList();
        c3 = new JComboBox<>();
        List<NamHocDTO> dsnh = nhbus.getList();
        c3.addItem("Tất cả");
        for (NamHocDTO nh : dsnh) {
            String idnamhoc = nh.getNamHocID();
            c3.addItem(nhbus.get(idnamhoc).getNamHocBatDau() + "-" + nhbus.get(idnamhoc).getNamHocKetThuc());
        }

        btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setPreferredSize(new Dimension(150, 0));
        btnPanel.setOpaque(false);

        filterBtn = new JButton("Lọc");
        filterBtn.setBackground(new Color(31, 28, 77));
        filterBtn.setForeground(Color.WHITE);
        filterBtn.setPreferredSize(new Dimension(70, 30));

        filterBtn.addActionListener(new ShowFilterListener());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        btnPanel.add(filterBtn, gbc);

        radioPanel.add(b2);
        radioPanel.add(b3);
        dropdownPanel.add(c2);
        dropdownPanel.add(c3);

        selectPanel.add(l1);
        selectPanel.add(radioPanel);
        selectPanel.add(dropdownPanel);

        topPanel.add(selectPanel, BorderLayout.CENTER);
        topPanel.add(btnPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        setVisible(true);
        PanelDiem();
        add(diemPanel, BorderLayout.CENTER);
    }

    public void PanelDiem() throws SQLException{
        diemPanel = new JPanel();
        diemPanel.setLayout(new BoxLayout(diemPanel, BoxLayout.Y_AXIS)); // Change layout to BoxLayout with Y_AXIS
        diemPanel.setBackground(new Color(180,204,227));
        diemPanel.setPreferredSize(new Dimension(850, 0));
        diemPanel.setVisible(true);
        
        JScrollPane tableScrollPane = initTable(); // Create JScrollPane for table
        diemPanel.add(tableScrollPane); // Add table to diemPanel
        loaddatatoTable();
        JPanel LoaiPanel = PanelLoai(); // Create PanelLoai
        diemPanel.add(LoaiPanel); // Add PanelLoai to the bottom of diemPanel
    }
    
    
    public JPanel PanelLoai() {
        loaiPanel = new JPanel(new GridBagLayout());
        loaiPanel.setPreferredSize(new Dimension(850, 180));
        loaiPanel.setBackground(new Color(180, 204, 227));
        loaiPanel.setVisible(true);
        addComponentsToPanel();
        return loaiPanel;
    }
    
    private void addComponentsToPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);

        jl1 = createLabel("Điểm trung bình học kỳ:", gbc, 0, 2);
        tf1 = createTextField(gbc, 1, 2);

        jl2 = createLabel("Điểm trung bình cả năm:", gbc, 0, 3);
        tf2 = createTextField(gbc, 1, 3);

        jl3 = createLabel("Xếp loại học lực:", gbc, 0, 4);
        tf3 = createTextField(gbc, 1, 4);

        jl4 = createLabel("Xếp loại hạnh kiểm:", gbc, 0, 5);
        tf4 = createTextField(gbc, 1, 5);

        lockTextFields();

    }

    private JLabel createLabel(String text, GridBagConstraints gbc, int x, int y) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(400, 40));
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.LEFT); // Set horizontal alignment to LEFT
        label.setVerticalAlignment(SwingConstants.TOP); // Set vertical alignment to TOP
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        loaiPanel.add(label, gbc);
        return label;
    }
    

    private JTextField createTextField(GridBagConstraints gbc, int x, int y) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 30));
        textField.setFont(textField.getFont().deriveFont(Font.BOLD, 18));
        textField.setHorizontalAlignment(SwingConstants.LEFT); // Set horizontal alignment to LEFT
        textField.setBackground(Color.WHITE);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        loaiPanel.add(textField, gbc);
        return textField;
    }
    
    private void lockTextFields() {
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
    }
    public JScrollPane initTable() throws SQLException {
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(t);

        tblModel = new DefaultTableModel();
        tblModel.addColumn("STT");
        tblModel.addColumn("Môn học");
        tblModel.addColumn("Điểm 15'");
        tblModel.addColumn("Điểm 1 tiết");
        tblModel.addColumn("Điểm học kì");
        tblModel.addColumn("Điểm TBM");

        t.setModel(tblModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < t.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        t.getColumnModel().getColumn(0).setPreferredWidth(50);
        t.getColumnModel().getColumn(1).setPreferredWidth(170);
        t.getColumnModel().getColumn(2).setPreferredWidth(170);
        t.getColumnModel().getColumn(3).setPreferredWidth(170);
        t.getColumnModel().getColumn(4).setPreferredWidth(170);
        t.getColumnModel().getColumn(5).setPreferredWidth(170);
        t.setRowHeight(40);

        JTableHeader header = t.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setBackground(new Color(31, 28, 77));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD, 12));
        // diemPanel.add(scrollPane, BorderLayout.CENTER);
        return scrollPane;
    }

    public void loaddatatoTable() {
        tblModel.setRowCount(0); // Clear existing data
        
        dshs = hsbus.getList();
        dskq = kqbus.getList();
        dsmon = mhbus.getList();
        dsct = ctbus.getList();
        dsdtb = dtbbus.getList();
        dshk = hkbus.getList();
        dsnh = nhbus.getList();
        dspl = plbus.getList();
        
        String mahocsinh = "HS1"; 
        int stt = 1;
        HKY = (String) c2.getSelectedItem(); // Gán giá trị cho biến HKY
        NH = (String) c3.getSelectedItem(); // Gán giá trị cho biến NH
        System.out.println(HKY);

        for (HocKyDTO hk : dshk) {
        String TenHK = hk.getTenHocKy();
        }
        for (NamHocDTO nh : dsnh) {
            String idnamhoc = nh.getNamHocID();
            String TenNH = nhbus.get(idnamhoc).getNamHocBatDau() + "-" + nhbus.get(idnamhoc).getNamHocKetThuc();
        }

        for (MonHocDTO mh : dsmon) {
            double diem15 = 0, diem1Tiet = 0, diemHocKy = 0;
            int heSo15 = 0, heSo1Tiet = 0, heSoHocKy = 0;
                    for (ChiTietDiemDTO ct : dsct) {
                        if (ct.getHocSinhID().equals(mahocsinh) && ct.getMonHocID().equals(mh.getMonHocID())) {
                            System.out.println("Subject: " + mh.getTenMonHoc()); // Debug statement
                            System.out.println("HeSoID: " + ct.getHeSoID() + ", Diem: " + ct.getDiem()); // Debug statement
                            System.out.println("HK: " + ct.getHocKyID() + ", Nam: " + ct.getNamHocID()); // Debug statement

                            // && tenHK.equals("Học kỳ 1") && NHHT.equals("2024-2025")
                            if (ct.getHeSoID() == 1 && ct.getHocKyID().equals("1") && ct.getNamHocID().equals("giapthin")) {
                                diem15 = ct.getDiem();
                                heSo15 = ct.getHeSoID();
                            }
                             else if (ct.getHeSoID() == 2 && ct.getHocKyID().equals("1") && ct.getNamHocID().equals("giapthin")) {
                                diem1Tiet = ct.getDiem();
                                heSo1Tiet = ct.getHeSoID();
                            } else if (ct.getHeSoID() == 3 && ct.getHocKyID().equals("1") && ct.getNamHocID().equals("giapthin")) {
                                diemHocKy = ct.getDiem();
                                heSoHocKy = ct.getHeSoID();
                            }
                        }
                    }
            System.out.println("Diem 15': " + diem15 + ", Diem 1 tiet: " + diem1Tiet + ", Diem Hoc Ky: " + diemHocKy); // Debug statement
            
            double tbm = (diem15 * heSo15 + diem1Tiet * heSo1Tiet + diemHocKy * heSoHocKy) / (heSo15 + heSo1Tiet + heSoHocKy);
            String formattedTBM = String.format("%.1f", tbm);
            String[] rowData = new String[] {
                String.valueOf(stt),
                mh.getTenMonHoc(),
                String.valueOf(diem15),
                String.valueOf(diem1Tiet),
                String.valueOf(diemHocKy),
                formattedTBM
            };
            tblModel.addRow(rowData);
            stt++; // Increment serial number
        }
    }
    
    

    private class ShowFilterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String monhoc = (String) c1.getSelectedItem();
            String hocki = (String) c2.getSelectedItem();
            String namhoc = (String) c3.getSelectedItem();

            if (sorter == null) {
                sorter = new TableRowSorter<>(tblModel);
                t.setRowSorter(sorter);
            }

            List<RowFilter<Object, Object>> filters = new ArrayList<>();

            if (!monhoc.equals("Tất cả")) {
                RowFilter<Object, Object> filterMonHoc = RowFilter.regexFilter(monhoc, 1); // Index 1 for "Môn học"
                filters.add(filterMonHoc);
            }

            if (!hocki.equals("Tất cả")) {
                RowFilter<Object, Object> filterHocKy = RowFilter.regexFilter(hocki, 2); // Adjust index for "Học kỳ"
                filters.add(filterHocKy);
            }

            if (!namhoc.equals("Tất cả")) {
                RowFilter<Object, Object> filterNamHoc = RowFilter.regexFilter(namhoc, 3); // Adjust index for "Năm học"
                filters.add(filterNamHoc);
            }

            RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
            sorter.setRowFilter(combinedFilter);

            // Update serial numbers after filtering
            updateSerialNumbers();
        }

        private void updateSerialNumbers() {
            for (int i = 0; i < tblModel.getRowCount(); i++) {
                tblModel.setValueAt(i + 1, i, 0); // Update the STT column
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Điểm Học Sinh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);

        try {
            diemHS testdiemPanel = new diemHS("HS1");
            frame.add(testdiemPanel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
}
