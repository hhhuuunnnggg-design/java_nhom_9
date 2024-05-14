
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BUS.HocSinhBUS;
import BUS.GiaoVienBUS;
import BUS.QLHS_GV_BUS;

import DTO.HocSinhDTO;
import DTO.LopDTO;
import DTO.PhanCongDTO;
import DTO.GiaoVienDTO;
import DTO.PhanLopDTO;
/**
 *
 * @author MSI MODERN 14
 */
public class TTTK_GV extends JPanel {
        private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12;
        private JButton btn1, btn2, btn3;
        private JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15;
        String maGV = "GV1";
        GiaoVienBUS gvbus = new GiaoVienBUS();
        QLHS_GV_BUS qlhsgv = new QLHS_GV_BUS();

        ArrayList<GiaoVienDTO> dsgv;
        ArrayList<PhanCongDTO> dspc;

        public TTTK_GV() {
                setPreferredSize(new Dimension(850, 670));
                setBackground(Color.WHITE);
                setLayout(new BorderLayout());

                JPanel topPanel = new JPanel();
                topPanel.setLayout(new GridBagLayout());
                topPanel.setPreferredSize(new Dimension(250, 670));
                topPanel.setBackground(Color.WHITE);

                // jl1 = new JLabel("Tài khoản HS_GV");
                // jl1.setFont(jl1.getFont().deriveFont(Font.BOLD, 20));
                // jl1.setHorizontalAlignment(JLabel.CENTER);
                // jl1.setVerticalAlignment(JLabel.CENTER);
                // GridBagConstraints gbc1 = new GridBagConstraints();
                // gbc1.gridx = 0;
                // gbc1.gridy = 0;
                // gbc1.weightx = 0;
                // gbc1.weighty = 0;
                // gbc1.insets = new Insets(80, 0, 0, 0); // Khoảng cách dưới 10 pixels
                // gbc1.anchor = GridBagConstraints.NORTH;
                // topPanel.add(jl1, gbc1);

                jl2 = new JLabel();
                jl2.setPreferredSize(new Dimension(120, 120));
                jl2.setBackground(Color.WHITE);
                jl2.setOpaque(true);
                GridBagConstraints gbc2 = new GridBagConstraints();
                gbc2.gridx = 0;
                gbc2.gridy = 0;
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
                topPanel.add(jl2, gbc2);

                // jl3 = new JLabel();
                // jl3.setPreferredSize(new Dimension (30,30));
                // jl3.setBackground(Color.WHITE);
                // jl3.setOpaque(true);
                // GridBagConstraints gbc3 = new GridBagConstraints();
                // gbc3.gridx = 0;
                // gbc3.gridy = 2;
                // gbc3.weightx = 0;
                // gbc3.weighty = 0;
                // gbc3.insets = new Insets(20, 0, 0, 0); // Khoảng cách dưới 10 pixels
                // gbc3.anchor = GridBagConstraints.NORTH;
                // // Đường dẫn tới tệp hình ảnh
                // String imagePath2 = "C:\\Users\\MSI MODERN
                // 14\\Documents\\NetBeansProjects\\thong_tin_tai_khoan\\src\\main\\java\\do_an\\reset.png";
                // // Tạo một ImageIcon từ tệp hình ảnh
                // ImageIcon imageIcon2 = new ImageIcon(imagePath2);
                // // Đặt ImageIcon làm hình ảnh cho JLabel
                // jl3.setIcon(imageIcon2);
                // topPanel.add(jl3,gbc3);

                // JPanel botPanel = new JPanel();
                // botPanel.setLayout(new GridBagLayout());
                // jl4 = new JLabel ("Tạo tài khoản");
                // jl4.setForeground(Color.WHITE);
                // jl4.setPreferredSize(new Dimension (150,40));
                // jl4.setFont(jl1.getFont().deriveFont(Font.BOLD, 18));
                // jl4.setHorizontalAlignment(JLabel.CENTER);
                // jl4.setVerticalAlignment(JLabel.CENTER);
                // jl4.setBackground(new Color(52,48,128));
                // jl4.setOpaque(true);
                // GridBagConstraints gbc4 = new GridBagConstraints();
                // gbc4.gridx = 0;
                // gbc4.gridy = 3;
                // gbc4.weightx = 0;
                // gbc4.weighty = 0;
                // gbc4.insets = new Insets(210, 0, 110, 0); // Khoảng cách dưới 10 pixels
                // gbc4.anchor = GridBagConstraints.SOUTH;
                // topPanel.add(jl4,gbc4);
                // add(topPanel, BorderLayout.WEST);

                JPanel rightPanel = new JPanel(new GridBagLayout());
                rightPanel.setPreferredSize(new Dimension(850, 670));
                rightPanel.setBackground(new Color(180, 204, 227));

                jl5 = new JLabel("Mã tài khoản:");
                // jl5.setForeground(Color.WHITE);
                jl5.setPreferredSize(new Dimension(150, 40));
                jl5.setFont(jl5.getFont().deriveFont(Font.BOLD, 18));
                jl5.setHorizontalAlignment(JLabel.CENTER);
                jl5.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc5 = new GridBagConstraints();
                gbc5.gridx = 0;
                gbc5.gridy = 0;
                gbc5.weightx = 0;
                gbc5.weighty = 0;
                gbc5.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc5.anchor = GridBagConstraints.WEST;
                // rightPanel.add(jl5, gbc5);

                tf1 = new JTextField();
                tf1.setPreferredSize(new Dimension(300, 30));
                tf1.setFont(tf1.getFont().deriveFont(Font.BOLD, 18));
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
                // rightPanel.add(tf1, gbc6);

                jl6 = new JLabel("Tạo mật khẩu:");
                // jl6.setForeground(Color.WHITE);
                jl6.setPreferredSize(new Dimension(150, 40));
                jl6.setFont(jl6.getFont().deriveFont(Font.BOLD, 18));
                jl6.setHorizontalAlignment(JLabel.CENTER);
                jl6.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc7 = new GridBagConstraints();
                gbc7.gridx = 0;
                gbc7.gridy = 1;
                gbc7.weightx = 0;
                gbc7.weighty = 0;
                gbc7.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc7.anchor = GridBagConstraints.WEST;
                // rightPanel.add(jl6, gbc7);

                tf2 = new JTextField();
                tf2.setPreferredSize(new Dimension(300, 30));
                tf2.setFont(tf2.getFont().deriveFont(Font.BOLD, 18));
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
                // rightPanel.add(tf2, gbc8);

                jl7 = new JLabel("Mã giáo viên:");
                // jl7.setForeground(Color.WHITE);
                jl7.setPreferredSize(new Dimension(150, 40));
                jl7.setFont(jl7.getFont().deriveFont(Font.BOLD, 18));
                jl7.setHorizontalAlignment(JLabel.CENTER);
                jl7.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc9 = new GridBagConstraints();
                gbc9.gridx = 0;
                gbc9.gridy = 2;
                gbc9.weightx = 0;
                gbc9.weighty = 0;
                gbc9.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc9.anchor = GridBagConstraints.WEST;
                rightPanel.add(jl7, gbc9);

                tf3 = new JTextField();
                tf3.setPreferredSize(new Dimension(300, 30));
                tf3.setFont(tf3.getFont().deriveFont(Font.BOLD, 18));
                tf3.setHorizontalAlignment(JLabel.CENTER);
                tf3.setBackground(Color.WHITE);
                tf3.setOpaque(true);

                GridBagConstraints gbc10 = new GridBagConstraints();
                gbc10.gridx = 1;
                gbc10.gridy = 2;
                gbc10.weightx = 0;
                gbc10.weighty = 0;
                gbc10.insets = new Insets(0, 20, 0, 0); // Khoảng cách dưới 10 pixels
                gbc10.anchor = GridBagConstraints.WEST;
                rightPanel.add(tf3, gbc10);

                jl8 = new JLabel("Họ tên:");
                // jl8.setForeground(Color.WHITE);
                jl8.setPreferredSize(new Dimension(150, 40));
                jl8.setFont(jl8.getFont().deriveFont(Font.BOLD, 18));
                jl8.setHorizontalAlignment(JLabel.CENTER);
                jl8.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc11 = new GridBagConstraints();
                gbc11.gridx = 0;
                gbc11.gridy = 3;
                gbc11.weightx = 0;
                gbc11.weighty = 0;
                gbc11.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc11.anchor = GridBagConstraints.WEST;
                rightPanel.add(jl8, gbc11);

                tf4 = new JTextField();
                tf4.setPreferredSize(new Dimension(300, 30));
                tf4.setFont(tf4.getFont().deriveFont(Font.BOLD, 18));
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
                rightPanel.add(tf4, gbc12);

                jl9 = new JLabel("Giới tính:");
                // jl9.setForeground(Color.WHITE);
                jl9.setPreferredSize(new Dimension(150, 40));
                jl9.setFont(jl9.getFont().deriveFont(Font.BOLD, 18));
                jl9.setHorizontalAlignment(JLabel.CENTER);
                jl9.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc13 = new GridBagConstraints();
                gbc13.gridx = 0;
                gbc13.gridy = 4;
                gbc13.weightx = 0;
                gbc13.weighty = 0;
                gbc13.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc13.anchor = GridBagConstraints.WEST;
                rightPanel.add(jl9, gbc13);

                tf5 = new JTextField();
                tf5.setPreferredSize(new Dimension(300, 30));
                tf5.setFont(tf5.getFont().deriveFont(Font.BOLD, 18));
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
                rightPanel.add(tf5, gbc14);

                jl10 = new JLabel("Ngày sinh:");
                // jl10.setForeground(Color.WHITE);
                jl10.setPreferredSize(new Dimension(150, 40));
                jl10.setFont(jl10.getFont().deriveFont(Font.BOLD, 18));
                jl10.setHorizontalAlignment(JLabel.CENTER);
                jl10.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc15 = new GridBagConstraints();
                gbc15.gridx = 0;
                gbc15.gridy = 5;
                gbc15.weightx = 0;
                gbc15.weighty = 0;
                gbc15.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc15.anchor = GridBagConstraints.WEST;
                rightPanel.add(jl10, gbc15);

                tf6 = new JTextField();
                tf6.setPreferredSize(new Dimension(300, 30));
                tf6.setFont(tf6.getFont().deriveFont(Font.BOLD, 18));
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
                rightPanel.add(tf6, gbc16);

                jl11 = new JLabel("Điện thoại:");
                // jl11.setForeground(Color.WHITE);
                jl11.setPreferredSize(new Dimension(150, 40));
                jl11.setFont(jl11.getFont().deriveFont(Font.BOLD, 18));
                jl11.setHorizontalAlignment(JLabel.CENTER);
                jl11.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc17 = new GridBagConstraints();
                gbc17.gridx = 0;
                gbc17.gridy = 6;
                gbc17.weightx = 0;
                gbc17.weighty = 0;
                gbc17.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc15.anchor = GridBagConstraints.WEST;
                rightPanel.add(jl11, gbc17);

                tf7 = new JTextField();
                tf7.setPreferredSize(new Dimension(300, 30));
                tf7.setFont(tf7.getFont().deriveFont(Font.BOLD, 18));
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
                rightPanel.add(tf7, gbc18);
                

                jl12 = new JLabel("Phân lớp:");
                // jl12.setForeground(Color.WHITE);
                jl12.setPreferredSize(new Dimension(150, 40));
                jl12.setFont(jl12.getFont().deriveFont(Font.BOLD, 18));
                jl12.setHorizontalAlignment(JLabel.CENTER);
                jl12.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc19 = new GridBagConstraints();
                gbc19.gridx = 0;
                gbc19.gridy = 7;
                gbc19.weightx = 0;
                gbc19.weighty = 0;
                gbc19.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc19.anchor = GridBagConstraints.WEST;
                rightPanel.add(jl12, gbc19);

                tf8 = new JTextField();
                tf8.setPreferredSize(new Dimension(300, 30));
                tf8.setFont(tf8.getFont().deriveFont(Font.BOLD, 18));
                tf8.setHorizontalAlignment(JLabel.CENTER);
                tf8.setBackground(Color.WHITE);
                tf8.setOpaque(true);
                GridBagConstraints gbc20 = new GridBagConstraints();
                gbc20.gridx = 1;
                gbc20.gridy = 7;
                gbc20.weightx = 0;
                gbc20.weighty = 0;
                gbc20.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
                gbc20.anchor = GridBagConstraints.EAST;
                rightPanel.add(tf8, gbc20);
                

                jl13 = new JLabel("Hạnh kiểm:");
                // jl13.setForeground(Color.WHITE);
                jl13.setPreferredSize(new Dimension(150, 40));
                jl13.setFont(jl13.getFont().deriveFont(Font.BOLD, 18));
                jl13.setHorizontalAlignment(JLabel.CENTER);
                jl13.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc21 = new GridBagConstraints();
                gbc21.gridx = 0;
                gbc21.gridy = 8;
                gbc21.weightx = 0;
                gbc21.weighty = 0;
                gbc21.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc21.anchor = GridBagConstraints.WEST;
                // rightPanel.add(jl13, gbc21);

                tf9 = new JTextField();
                tf9.setPreferredSize(new Dimension(300, 30));
                tf9.setFont(tf9.getFont().deriveFont(Font.BOLD, 18));
                tf9.setHorizontalAlignment(JLabel.CENTER);
                tf9.setBackground(Color.WHITE);
                tf9.setOpaque(true);
                GridBagConstraints gbc22 = new GridBagConstraints();
                gbc22.gridx = 1;
                gbc22.gridy = 8;
                gbc22.weightx = 0;
                gbc22.weighty = 0;
                gbc22.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
                gbc22.anchor = GridBagConstraints.EAST;
                // rightPanel.add(tf9, gbc22);
                

                jl14 = new JLabel("Địa chỉ:");
                // jl14.setForeground(Color.WHITE);
                jl14.setPreferredSize(new Dimension(150, 40));
                jl14.setFont(jl14.getFont().deriveFont(Font.BOLD, 18));
                jl14.setHorizontalAlignment(JLabel.CENTER);
                jl14.setVerticalAlignment(JLabel.CENTER);
                GridBagConstraints gbc23 = new GridBagConstraints();
                gbc23.gridx = 0;
                gbc23.gridy = 9;
                gbc23.weightx = 0;
                gbc23.weighty = 0;
                gbc23.insets = new Insets(0, 30, 0, 0); // Khoảng cách dưới 10 pixels
                gbc23.anchor = GridBagConstraints.WEST;
                rightPanel.add(jl14, gbc23);

                tf10 = new JTextField();
                tf10.setPreferredSize(new Dimension(300, 30));
                tf10.setFont(tf10.getFont().deriveFont(Font.BOLD, 18));
                tf10.setHorizontalAlignment(JLabel.CENTER);
                tf10.setBackground(Color.WHITE);
                tf10.setOpaque(true);
                GridBagConstraints gbc24 = new GridBagConstraints();
                gbc24.gridx = 1;
                gbc24.gridy = 9;
                gbc24.weightx = 0;
                gbc24.weighty = 0;
                gbc24.insets = new Insets(0, 20, 0, 30); // Khoảng cách dưới 10 pixels
                gbc24.anchor = GridBagConstraints.EAST;
                rightPanel.add(tf10,gbc24);
                add(rightPanel, BorderLayout.CENTER);
                loaddatatoPanel();
        }
        public void loaddatatoPanel() {
                dsgv = gvbus.getList();
                
                       for (GiaoVienDTO gv : dsgv) {
                        if(maGV.equals(gv.getMaGV())){
                                tf3.setText(gv.getMaGV());
                                tf4.setText(gv.getTenGV());
                                tf6.setText(gv.getNamSinh());
                                tf5.setText(gv.getGioiTinh());	
                                tf7.setText(gv.getDienThoai());	
                                //tf8.setText Phân lớp
                                // tf9.setText(gv.getDiaChi());	
                        }
                       }
        }
}
