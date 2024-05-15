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

public class diemHS {
    private JFrame f;
    private JPanel topPanel, radioPanel, dropdownPanel, selectPanel, btnPanel;
    private JLabel b1, b2, b3;
    private JComboBox<String> c1, c2, c3;
    private JLabel l1;
    private JButton filterBtn;
    private JScrollPane scrollPane;
    private JTable t;
    private DefaultTableModel tblModel;
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

    public diemHS() throws SQLException {
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

        String[] optionc1 = { "Tất cả", "Toán", "Vật Lý", "Hóa Học", "Anh Văn" };
        c1 = new JComboBox<>(optionc1);
        String[] optionc2 = { "Tất cả", "Học Kỳ 1", "Học Kỳ 2" };
        c2 = new JComboBox<>(optionc2);
        String[] optionc3 = { "Tất cả", "2024-2025", "2023-2024" };
        c3 = new JComboBox<>(optionc3);

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

        f.add(initTable(), BorderLayout.CENTER);
        loaddatatoTable();
    }

    public JScrollPane initTable() throws SQLException {
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(t);
        // hs id, môn học, hệ số điểm ,điểm môn học,học kì, điểm tb học kỳ, năm học,điểm
        // tb cả năm, kết quả
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Mã HS");
        tblModel.addColumn("Họ tên");
        tblModel.addColumn("Môn học");
        tblModel.addColumn("Hệ số điểm");
        tblModel.addColumn("Điểm MH");
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
        t.getColumnModel().getColumn(1).setPreferredWidth(200);
        t.getColumnModel().getColumn(2).setPreferredWidth(70);
        t.getColumnModel().getColumn(3).setPreferredWidth(60);
        t.getColumnModel().getColumn(4).setPreferredWidth(80);
        t.getColumnModel().getColumn(5).setPreferredWidth(100);
        t.getColumnModel().getColumn(6).setPreferredWidth(80);
        t.getColumnModel().getColumn(7).setPreferredWidth(80);
        t.getColumnModel().getColumn(8).setPreferredWidth(150);
        t.getColumnModel().getColumn(9).setPreferredWidth(150);
        t.setRowHeight(40);
         // Thiết lập chiều cao của header
        JTableHeader header = t.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));
        header.setBackground(new Color(31, 28, 77));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD, 12));

        return scrollPane;
    }

    public void loaddatatoTable() {
        // tblModel.setRowCount(0);

        dshs = hsbus.getList();
        dskq = kqbus.getList();
        dsmon = mhbus.getList();
        dsct = ctbus.getList();
        dsdtb = dtbbus.getList();
        dshk = hkbus.getList();
        dsnh = nhbus.getList();
        dspl = plbus.getList();

        String targetId = "HS1"; // HocSinhID cần tìm

        for (HocSinhDTO hs : dshs) {
            if (!hs.getHocSinhID().equals(targetId)) {
                continue; // Bỏ qua nếu không phải học sinh cần tìm
            }
            for (NamHocDTO nh : dsnh) {
                String idnamhoc = nh.getNamHocID();
                String idhs = hs.getHocSinhID();

                for (HocKyDTO hk : dshk) {
                    String idhk = hk.getHocKyID();
                    for (MonHocDTO mh : dsmon) {
                        String idmon = mh.getMonHocID();
                        for (int heso = 1; heso < 4; heso++) {
                            String idHocKy = hk.getHocKyID();
                            String idNamHoc = nh.getNamHocID();
                            String idDiemHocKy = ctbus.get(idhs, idNamHoc, idHocKy, idmon, heso) != null
                                    ? String.valueOf(ctbus.get(idhs, idNamHoc, idHocKy, idmon, heso).getDiem())
                                    : "";
                            String idDiemTrungBinhHocKy = dtbbus.get(idhs, idNamHoc, idHocKy) != null
                                    ? String.valueOf(dtbbus.get(idhs, idNamHoc, idHocKy).getDiemTrungBinh())
                                    : "";
                            String idDiemTrungBinhNam = kqbus.get(idhs, idNamHoc) != null
                                    ? String.valueOf(kqbus.get(idhs, idNamHoc).getDiemTrungBinhNam())
                                    : "";
                            String idKQ = kqbus.get(idhs, idNamHoc) != null
                                    ? String.valueOf(kqbus.get(idhs, idNamHoc).getKetQua())
                                    : "";
                            String[] rowData = new String[] {
                                    idhs,
                                    hsbus.get(idhs).getTenHocSinh(),
                                    mhbus.get(idmon).getTenMonHoc(),
                                    String.valueOf(heso),
                                    idDiemHocKy,
                                    hkbus.get(idhk).getTenHocKy(),
                                    idDiemTrungBinhHocKy,
                                    nhbus.get(idnamhoc).getNamHocBatDau() + "-"
                                            + nhbus.get(idnamhoc).getNamHocKetThuc(),
                                    idDiemTrungBinhNam,
                                    idKQ
                            };
                            tblModel.addRow(rowData);
                        }
                    }
                }
            }
        }
        tblModel.fireTableDataChanged();
    }

    public static void main(String[] args) throws SQLException {
        new diemHS();
    }

    private class ShowFilterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tblModel.setRowCount(0);
            String monhoc = (String) c1.getSelectedItem();
            String hocki = (String) c2.getSelectedItem();
            String namhoc = (String) c3.getSelectedItem();

            if (sorter == null) {
                sorter = new TableRowSorter<>(tblModel);
                t.setRowSorter(sorter);
            }

            List<RowFilter<Object, Object>> filters = new ArrayList<>();

            if (!monhoc.equals("Tất cả")) {
                RowFilter<Object, Object> filterMonHoc = RowFilter.regexFilter(monhoc, 2);
                filters.add(filterMonHoc);
            }

            if (!hocki.equals("Tất cả")) {
                RowFilter<Object, Object> filterHocKy = RowFilter.regexFilter(hocki, 5);
                filters.add(filterHocKy);
            }

            if (!namhoc.equals("Tất cả")) {
                RowFilter<Object, Object> filterNamHoc = RowFilter.regexFilter(namhoc, 7);
                filters.add(filterNamHoc);
            }

            RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
            sorter.setRowFilter(combinedFilter);
        }
    }

}