/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package GUI;

/**
 *
 * @author MSI MODERN 14
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.border.Border;

public class Thong_tin_tai_khoan extends JFrame {
    private JPanel jp1, LeftPanel, RightPanel, jp2, jp3;
    private JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;

    public Thong_tin_tai_khoan() {
        init();
    }

    public void init() {
        JFrame f = new JFrame();
        f.setTitle("Thông tin tài khoản");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        f.setSize(1000, 700);

        // Tạo JPanel jp1 ở phía trên
        jp1 = new JPanel(new BorderLayout());
        jp1.setPreferredSize(new Dimension(0, 40));
        jp1.setBackground(new Color(78, 78, 234));
        jp1.setPreferredSize(new Dimension(0, 40));
        jp1.setOpaque(true);

        // Thêm các JLabel vào jp1
        // Tạo LeftPanel chứa jl1,jl2
        // LeftPanel = new JPanel();
        // LeftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        // LeftPanel.setBackground(new Color(78, 78, 234));
        // LeftPanel.setOpaque(true);
        // LeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // Tạo RightPanel chứa exitbutton
        // RightPanel = new JPanel();
        // RightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        // RightPanel.setBackground(new Color(78, 78, 234));
        // RightPanel.setOpaque(true);
        // RightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        // Tạo JLabel jl1 với hình ảnh kích thước (20, 20)
        // jl1 = new JLabel();
        // jl1.setPreferredSize(new Dimension(20, 20));
        ImageIcon imageIcon = new ImageIcon("path_to_image.png");
        // Image image = imageIcon.getImage().getScaledInstance(40, 40);
        // jl1.setBackground(Color.WHITE);
        // jl1.setIcon(new ImageIcon(image));
        // jl1.setOpaque(true);
        // LeftPanel.add(jl1);
        // Tạo JLabel jl2 với nội dung "Quản lí học sinh"
        jl2 = new JLabel("QUẢN LÝ HỌC SINH");
        jl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Students-icon.png")));
        // LeftPanel.add(jl2);
        // Tạo JButton để thoát
        JLabel exitButton = new JLabel("X");
        exitButton.setFont(exitButton.getFont().deriveFont(Font.BOLD, 20));
        exitButton.setPreferredSize(new Dimension(30, 30));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Xử lý sự kiện khi nhấp vào JLabel
                System.exit(0); // Ví dụ: Thoát ứng dụng khi nhấp vào JLabel
            }
        });

        // RightPanel.add(exitButton);
        jp1.add(jl2, BorderLayout.WEST);
        jp1.add(exitButton, BorderLayout.EAST);

        // Tạo JPanel jp2 nằm bên trái và dưới jp1 với độ rộng 1/5 của JFrame
        jp2 = new JPanel();
        jp2.setBackground(new Color(52, 48, 128));
        jp2.setLayout(new BorderLayout());
        jp2.setPreferredSize(new Dimension(150, 0));
        jp2.setOpaque(true);
        // Tạo topPanel
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        topPanel.setBackground(new Color(52, 48, 128));
        topPanel.setOpaque(true);

        // Thêm hình tròn
        jl3 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                int radius = Math.min(getWidth(), getHeight()) / 2;
                int x = getWidth() / 2 - radius;
                int y = (getHeight() - radius * 2) / 2;
                g.fillOval(x, y, radius * 2, radius * 2);
            }
        };
        jl3.setPreferredSize(new Dimension(85, 85));
        // Định vị và căn chỉnh hình tròn trong topPanel
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 0;
        gbc1.weighty = 0;
        gbc1.anchor = GridBagConstraints.CENTER;
        topPanel.add(jl3, gbc1);

        // Thêm tên tài khoản
        jl4 = new JLabel("Tên tài khoản");
        jl4.setFont(jl4.getFont().deriveFont(Font.BOLD, 18)); // Đặt font mới và kích thước in đậm
        jl4.setForeground(Color.WHITE);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        gbc2.weightx = 0;
        gbc2.weighty = 0;
        gbc2.insets = new Insets(10, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc2.anchor = GridBagConstraints.CENTER;
        topPanel.add(jl4, gbc2);

        // Tạo centerPanel chứa các chức năng
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        centerPanel.setBackground(new Color(52, 48, 128));
        centerPanel.setOpaque(true);
        // Thêm chức năng 1
        jl5 = new JLabel("Chức năng 1");
        jl5.setFont(jl5.getFont().deriveFont(Font.BOLD, 18));
        jl5.setBackground(new Color(99, 116, 198));
        jl5.setHorizontalAlignment(JLabel.CENTER); // Căn giữa theo chiều ngang
        jl5.setVerticalAlignment(JLabel.CENTER); // Căn giữa theo chiều dọc
        jl5.setForeground(Color.WHITE);
        jl5.setPreferredSize(new Dimension(150, 40));
        jl5.setOpaque(true);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.weightx = 0;
        gbc3.weighty = 0;
        gbc3.insets = new Insets(0, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc3.anchor = GridBagConstraints.NORTH;
        centerPanel.add(jl5, gbc3);
        // Thêm chức năng 2
        jl6 = new JLabel("Chức năng 2");
        jl6.setFont(jl6.getFont().deriveFont(Font.BOLD, 18));
        jl6.setBackground(new Color(99, 116, 198));
        jl6.setHorizontalAlignment(JLabel.CENTER); // Căn giữa theo chiều ngang
        jl6.setVerticalAlignment(JLabel.CENTER); // Căn giữa theo chiều dọc
        jl6.setForeground(Color.WHITE);
        jl6.setPreferredSize(new Dimension(150, 40));
        jl6.setBackground(new Color(99, 116, 198));
        jl6.setOpaque(true);
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 1;
        gbc4.weightx = 0;
        gbc4.weighty = 0;
        gbc4.insets = new Insets(10, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc4.anchor = GridBagConstraints.NORTH;
        centerPanel.add(jl6, gbc4);
        // Thêm chức năng 3
        jl7 = new JLabel("Chức năng 3");
        jl7.setFont(jl7.getFont().deriveFont(Font.BOLD, 18));
        jl7.setBackground(new Color(99, 116, 198));
        jl7.setHorizontalAlignment(JLabel.CENTER); // Căn giữa theo chiều ngang
        jl7.setVerticalAlignment(JLabel.CENTER); // Căn giữa theo chiều dọc
        jl7.setForeground(Color.WHITE);
        jl7.setPreferredSize(new Dimension(150, 40));
        jl7.setBackground(new Color(99, 116, 198));
        jl7.setOpaque(true);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 2;
        gbc5.weightx = 0;
        gbc5.weighty = 0;
        gbc5.insets = new Insets(10, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc5.anchor = GridBagConstraints.NORTH;
        centerPanel.add(jl7, gbc5);
        // Thêm chức năng 4
        jl9 = new JLabel("Chức năng 4");
        jl9.setFont(jl7.getFont().deriveFont(Font.BOLD, 18));
        jl9.setBackground(new Color(99, 116, 198));
        jl9.setHorizontalAlignment(JLabel.CENTER); // Căn giữa theo chiều ngang
        jl9.setVerticalAlignment(JLabel.CENTER); // Căn giữa theo chiều dọc
        jl9.setForeground(Color.WHITE);
        jl9.setPreferredSize(new Dimension(150, 40));
        jl9.setBackground(new Color(99, 116, 198));
        jl9.setOpaque(true);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 3;
        gbc7.weightx = 0;
        gbc7.weighty = 0;
        gbc7.insets = new Insets(10, 0, 0, 0); // Khoảng cách dưới 10 pixels
        gbc5.anchor = GridBagConstraints.NORTH;
        centerPanel.add(jl9, gbc7);

        // Tạo bottomPanel chứa nút đăng xuất
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        bottomPanel.setBackground(new Color(52, 48, 128));
        bottomPanel.setOpaque(true);
        // Nút đăng xuất
        jl8 = new JLabel("ĐĂNG XUẤT");
        jl8.setFont(jl8.getFont().deriveFont(Font.BOLD, 14));
        jl8.setHorizontalAlignment(JLabel.CENTER); // Căn giữa theo chiều ngang
        jl8.setVerticalAlignment(JLabel.CENTER); // Căn giữa theo chiều dọc
        jl8.setPreferredSize(new Dimension(120, 40));
        jl8.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Tạo khoảng cách giữa nội dung và viền
        jl8.setForeground(Color.WHITE); // Đặt màu chữ là màu trắng
        jl8.setBackground(new Color(255, 49, 49)); // Đặt màu nền là màu tùy chỉnh
        jl8.setOpaque(true);
        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 2;
        gbc6.weightx = 0;
        gbc6.weighty = 0;
        gbc6.insets = new Insets(0, 0, 20, 0); // Khoảng cách dưới 20 pixels
        gbc6.anchor = GridBagConstraints.SOUTH;
        bottomPanel.add(jl8, gbc6);

        jp2.add(topPanel, BorderLayout.NORTH);
        jp2.add(centerPanel, BorderLayout.CENTER);
        jp2.add(bottomPanel, BorderLayout.PAGE_END);

        // Tạo JPanel jp3 nằm bên phải của jp2 và dưới jp1
        jp3 = new JPanel();
        jp3.setBackground(Color.LIGHT_GRAY);
        jp3.setPreferredSize(new Dimension(850, 670));
        jp3.setOpaque(true);

        // Đặt các JPanel vào JFrame sử dụng BorderLayout
        f.add(jp1, BorderLayout.NORTH);
        f.add(jp2, BorderLayout.WEST);
        f.add(jp3, BorderLayout.CENTER);

        f.pack();
        f.setLocationRelativeTo(null); // Căn giữa cửa sổ
        f.setVisible(true);
    }

    public static void main(String[] args) {
         new Thong_tin_tai_khoan();
    }
}