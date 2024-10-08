package GUI;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

import BUS.*;
import DTO.*;

public class TTTK_HS extends JPanel {
    private JTextField tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    private JTextArea tf10;
    private JLabel jl2, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14;
    private JPanel rightPanel;
    private String username;
    private int width, height;
    private HocSinhBUS hsbus = new HocSinhBUS(1);
    private NamHocBUS nhbus = new NamHocBUS(1);
    private KQ_HocSinhCaNamBUS kqbus = new KQ_HocSinhCaNamBUS(1);
    private LopBUS Lopbus = new LopBUS(1);
    private PhanLopBUS plbus = new PhanLopBUS(1);

    public TTTK_HS(int width, int height, String username) throws SQLException {
        this.width = width;
        this.height = height;
        this.username = username;  // Lưu trữ username
        this.setSize(new Dimension(width, height));
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());

        rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setPreferredSize(new Dimension(width, height));
        rightPanel.setBackground(new Color(180, 204, 227));

        addComponentsToPanel();
        this.add(rightPanel, BorderLayout.CENTER);

        loaddatatoPanel();

        this.setVisible(true);
    }

    void addComponentsToPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 30, 0, 30);

        jl7 = createLabel("Mã học sinh:", gbc, 0, 2);
        tf3 = createTextField(gbc, 1, 2);

        jl8 = createLabel("Họ tên:", gbc, 0, 3);
        tf4 = createTextField(gbc, 1, 3);

        jl9 = createLabel("Giới tính:", gbc, 0, 4);
        tf5 = createTextField(gbc, 1, 4);

        jl10 = createLabel("Ngày sinh:", gbc, 0, 5);
        tf6 = createTextField(gbc, 1, 5);

        jl11 = createLabel("Lớp:", gbc, 0, 6);
        tf7 = createTextField(gbc, 1, 6);

        // jl12 = createLabel("Học lực:", gbc, 0, 7);
        // tf8 = createTextField(gbc, 1, 7);

        jl12 = createLabel("Điện thoại:", gbc, 0, 7);
        tf8 = createTextField(gbc, 1, 7);
        // jl13 = createLabel("Hạnh kiểm:", gbc, 0, 8);
        // tf9 = createTextField(gbc, 1, 8);

        jl14 = createLabel("Địa chỉ:", gbc, 0, 8);
        tf10 = createTextArea(gbc, 1, 8); // Thay thế phần tạo JTextField cho tf10 bằng createTextArea
        tf10.setFocusable(false);

        lockTextFields();

    }
    private JTextArea createTextArea(GridBagConstraints gbc, int x, int y) {
        JTextArea textArea = new JTextArea();
        textArea.setFont(textArea.getFont().deriveFont(Font.BOLD, 18));
        textArea.setBackground(Color.WHITE);
        textArea.setLineWrap(true); // Cho phép wrap dòng
        textArea.setWrapStyleWord(true); // Wrap từ nguyên một từ
        textArea.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 60)); // Kích thước của JScrollPane
        gbc.gridx = x;
        gbc.gridy = y;
        rightPanel.add(scrollPane, gbc);
        return textArea;
    }
    private JLabel createLabel(String text, GridBagConstraints gbc, int x, int y) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(150, 40));
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.LEFT); // Set horizontal alignment to LEFT
        label.setVerticalAlignment(SwingConstants.TOP); // Set vertical alignment to TOP
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(label, gbc);
        return label;
    }

    private JTextField createTextField(GridBagConstraints gbc, int x, int y) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setFont(textField.getFont().deriveFont(Font.BOLD, 18));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBackground(Color.WHITE);
        gbc.gridx = x;
        gbc.gridy = y;
        rightPanel.add(textField, gbc);
        return textField;
    }
    private void lockTextFields() {
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf10.setEditable(false);
    }
    public void loaddatatoPanel() throws SQLException {
        ArrayList<HocSinhDTO> dshs = hsbus.getList();
        ArrayList<NamHocDTO> dsnh = nhbus.getList();
        ArrayList<KQ_HocSinhCaNamDTO> dsKQ = kqbus.getList();
        ArrayList<PhanLopDTO> dsPL = plbus.getList();
        ArrayList<LopDTO> dsLop = Lopbus.getList();
        diemHS dhs = new diemHS(username);
        for (HocSinhDTO hs : dshs) {
            if (username.equals(hs.getHocSinhID())) {  // Sử dụng username để lấy thông tin học sinh
                String idhs = hs.getHocSinhID();
                for (NamHocDTO nam : dsnh) {
                    for (PhanLopDTO pl : dsPL) {
                        for (LopDTO lop : dsLop) {
                            if (pl.getNamHocID().equals(dhs.getNH())) {
                                tf3.setText(idhs);
                                tf4.setText(hs.getTenHocSinh());
                                tf5.setText(hs.getGioiTinh());
                                tf6.setText(hs.getNgaySinh());
                                tf7.setText(lop.getTenLop());
                                tf8.setText(hs.getDienThoai());
                                tf10.setText(hs.getDiaChi());
                            }
                        }
                    }
                }
            }
        }
        // for (KQ_HocSinhCaNamDTO kq : dsKQ){
        //     if (kq.getHocSinhID().equals(username) && kq.getNamHocID().equals(dhs.getNH())) {
        //         tf8.setText(String.valueOf(kq.getHocLuc()));
        //         tf9.setText(String.valueOf(kq.getHanhKiem()));
        //     }
        // }
    }
    
    public JPanel getPanel() {
        return this;
    }
    
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 670);
        TTTK_HS panel = new TTTK_HS(850, 670, "HS2");
        frame.add(panel);
        frame.setVisible(true);
    }
}
