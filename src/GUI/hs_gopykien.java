package GUI;

import javax.swing.*;

import BUS.HocSinhBUS;
import BUS.ThongBaoBUS;
import BUS.YKienBUS;
import DTO.CurrentDateTime;
import DTO.YKienDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hs_gopykien {
    JFrame f;
    JPanel mainPanel;
    JLabel[] label;
    JTextField txtHeader;
    JTextArea txtContent;
    JButton btnGui; // Added button
    private String mahocsinh;
    HocSinhBUS hsbus = new HocSinhBUS(1);
    YKienBUS ykbus = new YKienBUS(1);

    public hs_gopykien(String mahocsinh) {
        this.mahocsinh = mahocsinh;
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(850, 670);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(180, 204, 227));

        label = new JLabel[2]; // Adjusted label count
        for (int i = 0; i < 2; i++) { // Adjusted loop range
            label[i] = new JLabel();
            label[i].setFont(new Font("Arial", Font.BOLD, 16)); // Set font size and bold
        }
        label[0].setText("Tiêu đề:"); // Adjusted label index
        label[0].setBounds(150, 50, 100, 30); // Adjusted position
        label[1].setText("Nhập ý kiến đóng góp:"); // Adjusted label index
        label[1].setBounds(150, 100, 250, 30); // Adjusted position

        txtHeader = new JTextField();
        txtHeader.setBounds(250, 50, 400, 30); // Adjusted position and size
        txtHeader.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and bold
        
        txtContent = new JTextArea(); // Changed from JTextField to JTextArea
        txtContent.setBounds(150, 150, 600, 300); // Adjusted position and size
        txtContent.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and bold
        txtContent.setLineWrap(true); // Enable text wrapping
        txtContent.setWrapStyleWord(true); // Wrap at word boundaries

        btnGui = new JButton("Gửi"); // Create button
        btnGui.setBounds(700, 500, 100, 30); // Set position and size
        btnGui.addActionListener(new SendBtnListener());
        // Add components to main panel
        for (JLabel jLabel : label) {
            mainPanel.add(jLabel);
        }
        mainPanel.add(txtHeader);
        mainPanel.add(txtContent);
        mainPanel.add(btnGui); // Add button to panel

        f.add(mainPanel);
        f.setVisible(true);
    }

    public class SendBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CurrentDateTime currDate = new CurrentDateTime();

            if (txtContent.getText().equals("") && txtHeader.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Thông báo không thể bỏ trống cả tiêu đề và nội dung");
                return;
            }
            System.out.println("tao yk dto");
            YKienDTO yk = new YKienDTO(mahocsinh, txtHeader.getText(), txtContent.getText(), currDate.getFormatDateTime(), hsbus.get(mahocsinh).getTenHocSinh());

            System.out.println("up yk to data");
            ykbus.add(yk);
            JOptionPane.showMessageDialog(null, "Ý kiến đã được gửi");
            resetText();
        }
        public void resetText(){
            txtContent.setText("");
            txtHeader.setText("");
        }
    }
    public static void main(String[] args) {
        new hs_gopykien("HS3");
    }
}
