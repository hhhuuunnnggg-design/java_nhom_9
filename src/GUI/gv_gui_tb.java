package GUI;

import javax.swing.*;
import java.awt.*;

public class gv_gui_tb {
    JFrame f;
    JPanel mainPanel, background;
    JLabel[] label;
    JRadioButton radioButtonHS, radioButtonGV;
    JTextField txtHeader, txtLop, txtHS;
    JTextArea txtContent;

    public gv_gui_tb() {
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

        radioButtonHS = new JRadioButton("Lớp:");
        radioButtonHS.setOpaque(false);
        radioButtonHS.setBounds(320, 50, 150, 30);
        radioButtonHS.setFont(new Font("Arial", Font.BOLD, 14));

        radioButtonGV = new JRadioButton("Học Sinh:");
        radioButtonGV.setOpaque(false);
        radioButtonGV.setBounds(570, 50, 150, 30);
        radioButtonGV.setFont(new Font("Arial", Font.BOLD, 14));

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonHS);
        buttonGroup.add(radioButtonGV);

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

        for (JLabel jLabel : label) {
            mainPanel.add(jLabel);
        }
        mainPanel.add(radioButtonHS);
        mainPanel.add(radioButtonGV);
        mainPanel.add(txtHeader);
        mainPanel.add(txtContent);
        mainPanel.add(txtLop);
        mainPanel.add(txtHS);

        background.add(mainPanel);
        f.add(background);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new gv_gui_tb();
    }
}
