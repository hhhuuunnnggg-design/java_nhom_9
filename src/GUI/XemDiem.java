/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import javax.swing.*;
import java.awt.*;

public class XemDiem extends JPanel{
    private JPanel topPanel, radioPanel, dropdownPanel, selectPanel, btnPanel;
    private JRadioButton b1, b2, b3;
    private JComboBox<String> c1, c2, c3;
    private JLabel l1;
    private JButton filterBtn;

    public XemDiem() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(850, 670));

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

        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);

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

        this.add(topPanel, BorderLayout.NORTH);
    }

}