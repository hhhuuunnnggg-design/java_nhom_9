/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MSI MODERN 14
 */
public class Tai_khoan_HS extends JPanel {
    public Tai_khoan_HS(){
        setPreferredSize(new Dimension (850,670));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        topPanel.setPreferredSize(new Dimension (250,670));
        topPanel.setBackground(Color.WHITE);
        
        JLabel jl1 = new JLabel("Tài khoản học sinh");
        jl1.setFont(jl1.getFont().deriveFont(Font.BOLD, 20));
        jl1.setHorizontalAlignment(JLabel.CENTER); 
        jl1.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 0;
        gbc1.weighty = 0;
        gbc1.insets = new Insets(80, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc1.anchor = GridBagConstraints.NORTH;
        topPanel.add(jl1, gbc1);
        
        JLabel jl2 = new JLabel();
        jl2.setPreferredSize(new Dimension (120,120));
        jl2.setBackground(Color.WHITE);
        jl2.setOpaque(true);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.weightx = 0;
        gbc2.weighty = 0;
        gbc2.insets = new Insets(20, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc2.anchor = GridBagConstraints.NORTH;
        // Đường dẫn tới tệp hình ảnh
        String imagePath1 = "C:\\Users\\MSI MODERN 14\\Documents\\NetBeansProjects\\thong_tin_tai_khoan\\src\\main\\java\\do_an\\noneavatar.jpg";
        // Tạo một ImageIcon từ tệp hình ảnh
        ImageIcon imageIcon1 = new ImageIcon(imagePath1);
        // Đặt ImageIcon làm hình ảnh cho JLabel
        jl2.setIcon(imageIcon1);
        topPanel.add(jl2,gbc2);
        
        JLabel jl3 = new JLabel();
        jl3.setPreferredSize(new Dimension (30,30));
        jl3.setBackground(Color.WHITE);
        jl3.setOpaque(true);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.weightx = 0;
        gbc3.weighty = 0;
        gbc3.insets = new Insets(20, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc3.anchor = GridBagConstraints.NORTH;
        // Đường dẫn tới tệp hình ảnh
        String imagePath2 = "C:\\Users\\MSI MODERN 14\\Documents\\NetBeansProjects\\thong_tin_tai_khoan\\src\\main\\java\\do_an\\reset.png";
        // Tạo một ImageIcon từ tệp hình ảnh
        ImageIcon imageIcon2 = new ImageIcon(imagePath2);
        // Đặt ImageIcon làm hình ảnh cho JLabel
        jl3.setIcon(imageIcon2);
        topPanel.add(jl3,gbc3);
        
        JPanel botPanel = new JPanel();
        botPanel.setLayout(new GridBagLayout());
        JLabel jl4 = new JLabel ("Tạo tài khoản");        
        jl4.setForeground(Color.WHITE);
        jl4.setPreferredSize(new Dimension (150,40));
        jl4.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl4.setHorizontalAlignment(JLabel.CENTER); 
        jl4.setVerticalAlignment(JLabel.CENTER);
        jl4.setBackground(new Color(52,48,128));
        jl4.setOpaque(true);
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 3;
        gbc4.weightx = 0;
        gbc4.weighty = 0;
        gbc4.insets = new Insets(210, 0, 110, 0); // Khoảng cách dưới 10 pixels
        gbc4.anchor = GridBagConstraints.SOUTH;
        topPanel.add(jl4,gbc4);
        add(topPanel, BorderLayout.WEST);
        
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setPreferredSize(new Dimension(600,670));
        rightPanel.setBackground(new Color(180,204,227));
        
        JLabel jl5 = new JLabel ("Mã tài khoản:");        
//        jl5.setForeground(Color.WHITE);
        jl5.setPreferredSize(new Dimension (150,40));
        jl5.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl5.setHorizontalAlignment(JLabel.CENTER); 
        jl5.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        gbc5.weightx = 0;
        gbc5.weighty = 0;
        gbc5.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
        gbc5.anchor = GridBagConstraints.WEST;
        rightPanel.add(jl5,gbc5);
        
        JTextField tf1 = new JTextField();       
        tf1.setPreferredSize(new Dimension (300,30));
        tf1.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        tf1.setHorizontalAlignment(JLabel.CENTER); 
        tf1.setBackground(Color.WHITE);
        tf1.setOpaque(true);
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 1;
        gbc6.gridy = 0;
        gbc6.weightx = 0;
        gbc6.weighty = 0;
        gbc6.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
        gbc6.anchor = GridBagConstraints.EAST;
        rightPanel.add(tf1,gbc6);
        
        JLabel jl6 = new JLabel ("Tạo mật khẩu:");        
//        jl6.setForeground(Color.WHITE);
        jl6.setPreferredSize(new Dimension (150,40));
        jl6.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl6.setHorizontalAlignment(JLabel.CENTER); 
        jl6.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 1;
        gbc7.weightx = 0;
        gbc7.weighty = 0;
        gbc7.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
        gbc7.anchor = GridBagConstraints.WEST;
        rightPanel.add(jl6,gbc7);
        
        JTextField tf2 = new JTextField();     
        tf2.setPreferredSize(new Dimension (300,30));
        tf2.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        tf2.setHorizontalAlignment(JLabel.CENTER); 
        tf2.setBackground(Color.WHITE);
        tf2.setOpaque(true);
        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 1;
        gbc8.gridy = 1;
        gbc8.weightx = 0;
        gbc8.weighty = 0;
        gbc8.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
        gbc8.anchor = GridBagConstraints.EAST;
        rightPanel.add(tf2,gbc8);
        
        JLabel jl7 = new JLabel ("Mã học sinh:");        
//        jl7.setForeground(Color.WHITE);
        jl7.setPreferredSize(new Dimension (150,40));
        jl7.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl7.setHorizontalAlignment(JLabel.CENTER); 
        jl7.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.gridx = 0;
        gbc9.gridy = 2;
        gbc9.weightx = 0;
        gbc9.weighty = 0;
        gbc9.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
        gbc9.anchor = GridBagConstraints.WEST;
        rightPanel.add(jl7,gbc9);
        
        JTextField tf3 = new JTextField();     
        tf3.setPreferredSize(new Dimension (300,30));
        tf3.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        tf3.setHorizontalAlignment(JLabel.CENTER); 
        tf3.setBackground(Color.WHITE);
        tf3.setOpaque(true);
        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 1;
        gbc10.gridy = 2;
        gbc10.weightx = 0;
        gbc10.weighty = 0;
        gbc10.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
        gbc10.anchor = GridBagConstraints.EAST;
        rightPanel.add(tf3,gbc10);
        
        JLabel jl8 = new JLabel ("Họ tên:");        
//        jl8.setForeground(Color.WHITE);
        jl8.setPreferredSize(new Dimension (150,40));
        jl8.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl8.setHorizontalAlignment(JLabel.CENTER); 
        jl8.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 0;
        gbc11.gridy = 3;
        gbc11.weightx = 0;
        gbc11.weighty = 0;
        gbc11.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
        gbc11.anchor = GridBagConstraints.WEST;
        rightPanel.add(jl8,gbc11);
        
        JTextField tf4 = new JTextField();     
        tf4.setPreferredSize(new Dimension (300,30));
        tf4.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        tf4.setHorizontalAlignment(JLabel.CENTER); 
        tf4.setBackground(Color.WHITE);
        tf4.setOpaque(true);
        GridBagConstraints gbc12 = new GridBagConstraints();
        gbc12.gridx = 1;
        gbc12.gridy = 3;
        gbc12.weightx = 0;
        gbc12.weighty = 0;
        gbc12.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
        gbc12.anchor = GridBagConstraints.EAST;
        rightPanel.add(tf4,gbc12);
        
        JLabel jl9 = new JLabel ("Giới tính:");        
//        jl9.setForeground(Color.WHITE);
        jl9.setPreferredSize(new Dimension (150,40));
        jl9.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl9.setHorizontalAlignment(JLabel.CENTER); 
        jl9.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc13 = new GridBagConstraints();
        gbc13.gridx = 0;
        gbc13.gridy = 4;
        gbc13.weightx = 0;
        gbc13.weighty = 0;
        gbc13.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
        gbc13.anchor = GridBagConstraints.WEST;
        rightPanel.add(jl9,gbc13);
        
        JTextField tf5 = new JTextField();     
        tf5.setPreferredSize(new Dimension (300,30));
        tf5.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        tf5.setHorizontalAlignment(JLabel.CENTER); 
        tf5.setBackground(Color.WHITE);
        tf5.setOpaque(true);
        GridBagConstraints gbc14 = new GridBagConstraints();
        gbc14.gridx = 1;
        gbc14.gridy = 4;
        gbc14.weightx = 0;
        gbc14.weighty = 0;
        gbc14.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
        gbc14.anchor = GridBagConstraints.EAST;
        rightPanel.add(tf5,gbc14);
        
        JLabel jl10 = new JLabel ("Ngày sinh:");        
//        jl10.setForeground(Color.WHITE);
        jl10.setPreferredSize(new Dimension (150,40));
        jl10.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl10.setHorizontalAlignment(JLabel.CENTER); 
        jl10.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc15 = new GridBagConstraints();
        gbc15.gridx = 0;
        gbc15.gridy = 5;
        gbc15.weightx = 0;
        gbc15.weighty = 0;
        gbc15.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
        gbc15.anchor = GridBagConstraints.WEST;
        rightPanel.add(jl10,gbc15);
        
        JTextField tf6 = new JTextField();     
        tf6.setPreferredSize(new Dimension (300,30));
        tf6.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        tf6.setHorizontalAlignment(JLabel.CENTER); 
        tf6.setBackground(Color.WHITE);
        tf6.setOpaque(true);
        GridBagConstraints gbc16 = new GridBagConstraints();
        gbc16.gridx = 1;
        gbc16.gridy = 5;
        gbc16.weightx = 0;
        gbc16.weighty = 0;
        gbc16.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
        gbc16.anchor = GridBagConstraints.EAST;
        rightPanel.add(tf6,gbc16);
        
        JLabel jl11 = new JLabel ("Địa chỉ:");        
//        jl11.setForeground(Color.WHITE);
        jl11.setPreferredSize(new Dimension (150,40));
        jl11.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        jl11.setHorizontalAlignment(JLabel.CENTER); 
        jl11.setVerticalAlignment(JLabel.CENTER);
        GridBagConstraints gbc17 = new GridBagConstraints();
        gbc17.gridx = 0;
        gbc17.gridy = 6;
        gbc17.weightx = 0;
        gbc17.weighty = 0;
        gbc17.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
        gbc15.anchor = GridBagConstraints.WEST;
        rightPanel.add(jl11,gbc17);
        
        JTextField tf7 = new JTextField();     
        tf7.setPreferredSize(new Dimension (300,30));
        tf7.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
        tf7.setHorizontalAlignment(JLabel.CENTER); 
        tf7.setBackground(Color.WHITE);
        tf7.setOpaque(true);
        GridBagConstraints gbc18 = new GridBagConstraints();
        gbc18.gridx = 1;
        gbc18.gridy = 6;
        gbc18.weightx = 0;
        gbc18.weighty = 0;
        gbc18.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
        gbc18.anchor = GridBagConstraints.EAST;
        rightPanel.add(tf7,gbc18);
        add(rightPanel, BorderLayout.CENTER);
    }
}
