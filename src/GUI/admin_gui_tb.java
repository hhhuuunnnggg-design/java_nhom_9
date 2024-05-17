package GUI;

import javax.swing.*;
import java.awt.*;

public class admin_gui_tb {
    JFrame f;
    JPanel mainPanel;
    JLabel[] label;
    JCheckBox checkboxHS, checkboxGV;
    JTextField txtHeader, txtContent;

    public admin_gui_tb() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(850, 670);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

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

        checkboxHS = new JCheckBox("Học Sinh");
        checkboxHS.setOpaque(false);
        checkboxHS.setBounds(320, 50, 150, 30); // Adjusted position to the right
        checkboxHS.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and bold
        checkboxGV = new JCheckBox("Giáo Viên");
        checkboxGV.setOpaque(false);
        checkboxGV.setBounds(470, 50, 150, 30); // Adjusted position to the right
        checkboxGV.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and bold

        txtHeader = new JTextField();
        txtHeader.setBounds(300, 100, 300, 30);
        txtHeader.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and bold
        txtContent = new JTextField();
        txtContent.setBounds(150, 200, 600, 300);
        txtContent.setFont(new Font("Arial", Font.BOLD, 14)); // Set font size and bold

        // Add components to main panel
        for (JLabel jLabel : label) {
            mainPanel.add(jLabel);
        }
        mainPanel.add(checkboxHS);
        mainPanel.add(checkboxGV);
        mainPanel.add(txtHeader);
        mainPanel.add(txtContent);

        f.add(mainPanel);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new admin_gui_tb();
    }
}
