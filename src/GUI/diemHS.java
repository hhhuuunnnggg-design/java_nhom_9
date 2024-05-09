package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.HocSinhBUS;
import BUS.KQ_HocSinhCaNamBUS;
import BUS.DTB_HocKyBUS;
import BUS.ChiTietDiemBUS;
import DTO.HocSinhDTO;
import DTO.KQ_HocSinhCaNamDTO;
import DTO.DTB_HocKyDTO;
import DTO.ChiTietDiemDTO;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class diemHS {
    private JFrame f;
    private JPanel topPanel, radioPanel, dropdownPanel, selectPanel, btnPanel;
    private JRadioButton b1, b2, b3;
    private JComboBox<String> c1, c2, c3;
    private JLabel l1;
    private JButton filterBtn;
    private JScrollPane scrollPane;
    private JTable t;
    private DefaultTableModel tblModel;
    KQ_HocSinhCaNamBUS kq = new KQ_HocSinhCaNamBUS(1);
    HocSinhBUS hsbus = new HocSinhBUS(1);
    ChiTietDiemBUS ctdbus = new ChiTietDiemBUS(1);
    DTB_HocKyBUS dbthkbus = new DTB_HocKyBUS(1);
    ArrayList<HocSinhDTO> dsHS;
    ArrayList<KQ_HocSinhCaNamDTO> dsKQ;
    ArrayList<ChiTietDiemDTO> dsCTD;
    ArrayList<DTB_HocKyDTO> dsTBHK;
    public diemHS() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLayout(new BorderLayout());
        f.setSize(850, 670);

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 100));
        topPanel.setBackground(new Color(180, 204, 227));

        selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
        selectPanel.setOpaque(false);

        l1 = new JLabel("Xem điểm theo:              ");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        radioPanel = new JPanel();
        radioPanel.setOpaque(false);
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

        b1 = new JRadioButton("Môn học");
        b2 = new JRadioButton("Học kỳ");
        b3 = new JRadioButton("Năm học");
        b1.setBackground(new Color(180, 204, 227));
        b2.setBackground(new Color(180, 204, 227));
        b3.setBackground(new Color(180, 204, 227));

        dropdownPanel = new JPanel();
        dropdownPanel.setOpaque(false);
        dropdownPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        dropdownPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        String[] optionc1 = {"Toán", "Lý", "Hóa", "Ngoại ngữ", "Ngữ văn", "Sinh", "Sử", "Địa", "GDCD"};
        c1 = new JComboBox<>(optionc1);
        String[] optionc2 = {"HK I", "HK II"};
        c2 = new JComboBox<>(optionc2);
        String[] optionc3 = {"2019-2020", "2020-2021", "2021-2022"};
        c3 = new JComboBox<>(optionc3);

        btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setPreferredSize(new Dimension(150, 0));
        btnPanel.setOpaque(false);

        filterBtn = new JButton("Lọc");
        filterBtn.setBackground(new Color(31, 28, 77));
        filterBtn.setForeground(Color.WHITE);
        filterBtn.setPreferredSize(new Dimension(70, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        btnPanel.add(filterBtn, gbc);

        radioPanel.add(b1);
        radioPanel.add(b2);
        radioPanel.add(b3);
        dropdownPanel.add(c1);
        dropdownPanel.add(c2);
        dropdownPanel.add(c3);

        selectPanel.add(l1);
        selectPanel.add(radioPanel);
        selectPanel.add(dropdownPanel);

        topPanel.add(selectPanel, BorderLayout.CENTER);
        topPanel.add(btnPanel, BorderLayout.EAST);

        f.add(topPanel, BorderLayout.NORTH);
        f.setVisible(true);
        try {
            scrollPane = initTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        f.add(scrollPane, BorderLayout.CENTER);
        loaddatatoTable();
    }

    public JScrollPane initTable() throws SQLException {
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(t);
        //hs id, môn học, hệ số điểm ,điểm môn học,học kì, điểm tb học kỳ, năm học,điểm tb cả năm, kết quả
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã HS");
        tblModel.addColumn("Họ tên");
        tblModel.addColumn("Môn học");
        tblModel.addColumn("Hệ số điểm");
        tblModel.addColumn("Điểm môn học");
        tblModel.addColumn("Học kì");
        tblModel.addColumn("Điểm TBHK");
        tblModel.addColumn("Năm học");
        tblModel.addColumn("Điểm TBCN");
        tblModel.addColumn("Kết quả");

        t.setModel(tblModel);

        // Căn giữa nội dung trong các ô của bảng
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < t.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Thiết lập kích thước cột
        t.getColumnModel().getColumn(0).setPreferredWidth(80);
        t.getColumnModel().getColumn(1).setPreferredWidth(150);
        t.getColumnModel().getColumn(2).setPreferredWidth(70);
        t.getColumnModel().getColumn(3).setPreferredWidth(100);
        t.getColumnModel().getColumn(4).setPreferredWidth(120);
        t.getColumnModel().getColumn(5).setPreferredWidth(200);
        t.getColumnModel().getColumn(6).setPreferredWidth(80);
        t.getColumnModel().getColumn(7).setPreferredWidth(80);
        t.getColumnModel().getColumn(8).setPreferredWidth(150);
        t.getColumnModel().getColumn(9).setPreferredWidth(150);

        return scrollPane;
    }

    public void loaddatatoTable() {
        dsHS = hsbus.getList();
        tblModel.setRowCount(0); // Xóa dữ liệu cũ

        for (HocSinhDTO hs : dsHS) {
            Object[] rowData = {
                    hs.getHocSinhID(),
                    hs.getTenHocSinh(),
                    hs.getGioiTinh(),
                    hs.getNgaySinh(),
                    hs.getDienThoai(),
                    hs.getDiaChi(),
                    kq.getHanhKiemById(hs.getHocSinhID()),
                    kq.getHocLucById(hs.getHocSinhID())
            };
            tblModel.addRow(rowData);
        }

        tblModel.fireTableDataChanged(); // Cập nhật dữ liệu trên bảng
    }

    public static void main(String[] args) {
        new diemHS();
    }
}