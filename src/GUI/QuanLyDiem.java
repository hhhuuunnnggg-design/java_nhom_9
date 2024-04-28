/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import javax.swing.*;



/**
 *
 * @author PHUONG ANH
 */
public class QuanLyDiem extends JPanel{
    private JPanel topPanel, radioPanel, dropdownPanel, selectPanel, totalPanel, btnPanel;
    private JRadioButton b1, b2, b3;
    private JComboBox<String> c1, c2;
    private JTextField s, inputID;
    private JLabel l1, l2;
    private JButton filterBtn, addBtn, editBtn, delBtn;

    public QuanLyDiem() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(850, 670));

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 120));
        topPanel.setBackground(new Color(180, 204, 227));

        selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
        selectPanel.setOpaque(false);

        l1 = new JLabel("Hiển thị danh sách điểm theo:");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        radioPanel = new JPanel();
        radioPanel.setOpaque(false);
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

        b1 = new JRadioButton("Lớp");
        b2 = new JRadioButton("Môn học");
        b3 = new JRadioButton("Mã HS");
        b1.setBackground(new Color(180, 204, 227));
        b2.setBackground(new Color(180, 204, 227));
        b3.setBackground(new Color(180, 204, 227));

        dropdownPanel = new JPanel();
        dropdownPanel.setOpaque(false);
        dropdownPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        String[] optionc1 = {"10A1", "10A2", "10A3", "10A4", "11A1", "11A2", "11A3", "11A4", "12A1", "12A2", "12A3", "12A4"};
        c1 = new JComboBox<>(optionc1);
        String[] optionc2 = {"Toán", "Lý", "Hóa", "Ngoại ngữ", "Ngữ Văn", "Sinh", "Sử", "Địa", "GDCD"};
        c2 = new JComboBox<>(optionc2);
        inputID = new JTextField(6);

        totalPanel = new JPanel();
        totalPanel.setOpaque(false);

        l2 = new JLabel("Tổng số học sinh trong danh sách:");
        s = new JTextField(4);
        s.setEditable(false);

        btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(100, 0));
        btnPanel.setOpaque(false);
        btnPanel.setLayout(new GridLayout(4, 1, 0,0));

        filterBtn = new JButton("Lọc");
        addBtn = new JButton("Thêm");
        editBtn = new JButton("Sửa");
        delBtn = new JButton("Xóa");

        filterBtn.setBackground(new Color(31, 28, 77));
        filterBtn.setForeground(Color.WHITE);

        btnPanel.add(filterBtn);
        btnPanel.add(addBtn);
        btnPanel.add(editBtn);
        btnPanel.add(delBtn);

        totalPanel.add(l2);
        totalPanel.add(s);
        radioPanel.add(b1);
        radioPanel.add(b2);
        radioPanel.add(b3);
        dropdownPanel.add(c1);
        dropdownPanel.add(c2);
        dropdownPanel.add(inputID);

        selectPanel.add(l1);
        selectPanel.add(radioPanel);
        selectPanel.add(dropdownPanel);
        selectPanel.add(totalPanel);

        topPanel.add(selectPanel, BorderLayout.CENTER);
        topPanel.add(btnPanel, BorderLayout.EAST);

        this.add(topPanel, BorderLayout.NORTH);
        
    }

    
}
