package GUI;

import DTO.phanquyenDTO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BUS.phanquyenBUS;

public class phanquyen extends JFrame implements ActionListener {

    private Integer width, height;
    private JTable t;
    private JScrollPane scrollpane;
    private JPanel psearch;
    private DefaultTableModel model;
    private ArrayList<phanquyenDTO> dsquyen;
    private phanquyenBUS pqBUS;
    private JButton btnAdd, btnEdit, btnDelete;

    public phanquyen(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        init();
        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
    }

    public void init() {
        this.setSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel p1 = JSearch();
        p1.setPreferredSize(new Dimension(0, 40));
        p1.setBackground(new Color(173, 216, 230)); // Light blue background

        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(0, 300));
        p3.add(init_table());
        p3.setBackground(new Color(240, 255, 255)); // Azure background

        this.add(p1, BorderLayout.NORTH);
        this.add(p3, BorderLayout.CENTER);
    }

    public JPanel JSearch() {
        psearch = new JPanel();
        psearch.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        // Thêm 3 nút Thêm, Sửa và Xóa
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");

        psearch.add(btnAdd);
        psearch.add(btnEdit);
        psearch.add(btnDelete);

        return psearch;
    }

    public JScrollPane init_table() {
        String[] header = { "Mã Quyền", "Tên mã quyền" };

        pqBUS = new phanquyenBUS();
        pqBUS.listquyen();
        dsquyen = pqBUS.getlistquyen();
        System.out.println(dsquyen.size());
        Object[][] rowData = new Object[dsquyen.size()][header.length];
        for (int i = 0; i < dsquyen.size(); i++) {
            phanquyenDTO quyen = dsquyen.get(i);
            rowData[i][0] = quyen.getMaquyen();
            rowData[i][1] = quyen.getTenquyen();
        }

        model = new DefaultTableModel(rowData, header);
        t = new JTable(model);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        t.getTableHeader().setBackground(new Color(70, 130, 180)); // Steel blue header
        t.getTableHeader().setForeground(Color.WHITE);
        t.setSelectionBackground(new Color(100, 149, 237)); // Cornflower blue selection
        t.setGridColor(new Color(173, 216, 230)); // Light blue grid lines
        scrollpane = new JScrollPane(t);
        scrollpane.setPreferredSize(new Dimension(835, 295));
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    tableMouseClicked(evt);
                } catch (ParseException ex) {
                    Logger.getLogger(phanquyen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        return scrollpane;
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) throws ParseException {
        int row = t.getSelectedRow();
    }

    public void deleteFields() {
        // Clear fields logic if needed
    }

    public static void main(String[] args) {
        phanquyen frame = new phanquyen(850, 670);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            showAddDialog();
        } else if (e.getSource() == btnEdit) {
            // Edit logic
        } else if (e.getSource() == btnDelete) {
            // Delete logic
        }
    }

    private void showAddDialog() {
        JDialog addDialog = new JDialog(this, "Thêm Quyền", true);
        addDialog.setSize(400, 300);
        addDialog.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblMaQuyen = new JLabel("Mã Quyền:");
        JTextField txtMaQuyen = new JTextField();
        JLabel lblTenQuyen = new JLabel("Tên Quyền:");
        JTextField txtTenQuyen = new JTextField();

        inputPanel.add(lblMaQuyen);
        inputPanel.add(txtMaQuyen);
        inputPanel.add(lblTenQuyen);
        inputPanel.add(txtTenQuyen);

        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
        JCheckBox cbx1 = new JCheckBox("Chức năng 1");
        JCheckBox cbx2 = new JCheckBox("Chức năng 2");
        JCheckBox cbx3 = new JCheckBox("Chức năng 3");
        // Add more checkboxes as needed
        checkBoxPanel.add(cbx1);
        checkBoxPanel.add(cbx2);
        checkBoxPanel.add(cbx3);

        JButton btnSave = new JButton("Lưu");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maquyen = txtMaQuyen.getText();
                String tenquyen = txtTenQuyen.getText();
                // Gather selected checkboxes if needed

                if (!maquyen.isEmpty() && !tenquyen.isEmpty()) {
                    // Add save logic
                    // e.g., save to database or list
                    phanquyenDTO newQuyen = new phanquyenDTO(maquyen, tenquyen);
                    // pqBUS.addQuyen(newQuyen);
                    dsquyen.add(newQuyen);
                    model.addRow(new Object[] { maquyen, tenquyen });
                    addDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(addDialog, "Vui lòng nhập đủ thông tin.", "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addDialog.add(inputPanel, BorderLayout.NORTH);
        addDialog.add(checkBoxPanel, BorderLayout.CENTER);
        addDialog.add(btnSave, BorderLayout.SOUTH);

        addDialog.setVisible(true);
    }
}
