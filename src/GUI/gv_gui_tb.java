package GUI;

import javax.swing.*;

import BUS.HocSinhBUS;
import BUS.LopBUS;
import BUS.PhanCongBUS;
import BUS.PhanLopBUS;
import DTO.HocSinhDTO;
import DTO.LopDTO;
import DTO.PhanCongDTO;
import DTO.PhanLopDTO;

import java.awt.*;
import java.util.ArrayList;

public class gv_gui_tb {
    JFrame f;
    JPanel mainPanel, background;
    JLabel[] label;
    JRadioButton radioButtonHS, radioButtonLop;
    JTextField txtHeader, txtLop, txtHS;
    JTextArea txtContent;
    JButton btnGui;
    private String magiaovien, idhs, idmon, idlop;

    ArrayList <HocSinhDTO> dshs;
    ArrayList<LopDTO> dslop;
    ArrayList<PhanLopDTO> dspl;
    ArrayList<PhanCongDTO> dspc;
    PhanLopBUS plbus = new PhanLopBUS(1);
    LopBUS lopbus = new LopBUS(1);
    HocSinhBUS hsbus = new HocSinhBUS(1);
    PhanCongBUS pcbus = new PhanCongBUS(1);
    
    public gv_gui_tb(String magiaovien) {
        this.magiaovien = magiaovien;
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(850, 670);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

        background = new JPanel();
        background.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(180, 204, 227));

        label = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            label[i] = new JLabel();
            label[i].setFont(new Font("Arial", Font.BOLD, 16)); // Set font size and bold
        }
        label[0].setText("Gửi thông báo đến:");
        label[0].setBounds(150, 50, 200, 30);
        label[1].setText("Tiêu đề:");
        label[1].setBounds(150, 100, 100, 30);
        label[2].setText("Nhập nội dung thông báo:");
        label[2].setBounds(150, 150, 250, 30);

        radioButtonLop = new JRadioButton("Lớp:");
        radioButtonLop.setOpaque(false);
        radioButtonLop.setBounds(320, 50, 150, 30);
        radioButtonLop.setFont(new Font("Arial", Font.BOLD, 14));

        radioButtonHS = new JRadioButton("Học Sinh:");
        radioButtonHS.setOpaque(false);
        radioButtonHS.setBounds(570, 50, 150, 30);
        radioButtonHS.setFont(new Font("Arial", Font.BOLD, 14));

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonHS);
        buttonGroup.add(radioButtonLop);

        txtHeader = new JTextField();
        txtHeader.setBounds(300, 100, 300, 30);
        txtHeader.setFont(new Font("Arial", Font.BOLD, 14));

        txtContent = new JTextArea();
        txtContent.setLineWrap(true); // Enable text wrapping
        txtContent.setWrapStyleWord(true); // Wrap at word boundaries
        txtContent.setBounds(150, 200, 600, 300);
        txtContent.setFont(new Font("Arial", Font.BOLD, 14));

        txtLop = new JTextField();
        txtLop.setEditable(false);
        txtLop.setBorder(BorderFactory.createLineBorder(new Color(52, 48, 128)));
        txtLop.setHorizontalAlignment(JTextField.CENTER);
        txtLop.setBounds(380, 50, 70, 30);

        txtHS = new JTextField();
        txtHS.setEditable(false);
        txtHS.setBorder(BorderFactory.createLineBorder(new Color(52, 48, 128)));
        txtHS.setHorizontalAlignment(JTextField.CENTER);
        txtHS.setBounds(665, 50, 70, 30);

        radioButtonHS.addActionListener(e -> {
            // Create a custom panel with a table
            JPanel panel = createHSTablePanel();
            // Show the panel in JOptionPane
            int result = JOptionPane.showConfirmDialog(null, panel, "Chọn Học Sinh", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                // OK button clicked, retrieve data from the table
                JTable table = (JTable) ((JScrollPane) panel.getComponent(0)).getViewport().getView();
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Ensure a row is selected
                    Object selectedID = table.getValueAt(selectedRow, 0);
                    Object selectedName = table.getValueAt(selectedRow, 1);
                    Object selectedGrade = table.getValueAt(selectedRow, 2);
                    // Do something with the selected data
                    System.out.println("Selected ID: " + selectedID);
                    System.out.println("Selected Name: " + selectedName);
                    System.out.println("Selected Grade: " + selectedGrade);
                } else {
                    // No row selected, handle this case if needed
                }
            }
        });
        
        radioButtonLop.addActionListener(e -> {
            // Create a custom panel with a table
            JPanel panel = createLopTablePanel();
            // Show the panel in JOptionPane
            int result = JOptionPane.showConfirmDialog(null, panel, "Chọn Lớp", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                // OK button clicked, retrieve data from the table
                JTable table = (JTable) ((JScrollPane) panel.getComponent(0)).getViewport().getView();
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Ensure a row is selected
                    Object selectedID = table.getValueAt(selectedRow, 0);
                    Object selectedName = table.getValueAt(selectedRow, 1);
                    Object selectedGrade = table.getValueAt(selectedRow, 2);
                    // Do something with the selected data
                    System.out.println("Selected ID: " + selectedID);
                    System.out.println("Selected Name: " + selectedName);
                    System.out.println("Selected Grade: " + selectedGrade);

                    
                } else {
                    // No row selected, handle this case if needed
                }
            }
        });
        
        btnGui = new JButton("Gửi"); // Create button
        btnGui.setBounds(650, 550, 100, 30);
        for (JLabel jLabel : label) {
            mainPanel.add(jLabel);
        }
        mainPanel.add(radioButtonHS);
        mainPanel.add(radioButtonLop);
        mainPanel.add(txtHeader);
        mainPanel.add(txtContent);
        mainPanel.add(txtLop);
        mainPanel.add(txtHS);
        mainPanel.add(btnGui);

        background.add(mainPanel);
        f.add(background);
        f.setVisible(true);
    }

    // Method to create a panel containing a table
    private JPanel createHSTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Name", "Grade"};
        Object[][] data = {
                {1, "John", "A"},
                {2, "Doe", "B"},
                {3, "Jane", "C"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }
    private JPanel createLopTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Name", "Grade"};
        Object[][] data = {
                {1, "John", "A"},
                {2, "Doe", "B"},
                {3, "Jane", "C"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        new gv_gui_tb("GV3");
    }
}
