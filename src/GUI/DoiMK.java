package GUI;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

import BUS.*;
import DTO.*;

public class DoiMK extends JPanel {
    private JTextField tf1, tf2, tf3;
    private JPanel mainP;
    private JLabel jl1, jl2, jl3;
    private JButton okButton;
    public DoiMK(int width, int height) {
        this.setSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());

        mainP = new JPanel(new GridBagLayout());
        mainP.setPreferredSize(new Dimension(width, height));
        mainP.setBackground(new Color(180, 204, 227));
        addComponentsToPanel();
        this.add(mainP, BorderLayout.CENTER);
        this.setVisible(true);
    }
    private void addComponentsToPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 30, 10, 30); // Khoảng cách giữa các thành phần

        jl1 = createLabel("Nhập Username:", gbc, 0, 2);
        tf1 = createTextField(gbc, 1, 2);

        jl2 = createLabel("Nhập mật khẩu cũ:", gbc, 0, 3);
        tf2 = createTextField(gbc, 1, 3);

        jl3 = createLabel("Nhập mật khẩu mới:", gbc, 0, 4);
        tf3 = createTextField(gbc, 1, 4);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(80, 40));
        okButton.setFont(okButton.getFont().deriveFont(Font.BOLD, 18));
        okButton.setBackground(new Color(52, 48, 128));
        okButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainP.add(okButton, gbc);
    }
    private JLabel createLabel(String text, GridBagConstraints gbc, int x, int y) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(200, 40));
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        mainP.add(label, gbc);
        return label;
    }
    private JTextField createTextField(GridBagConstraints gbc, int x, int y) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setFont(textField.getFont().deriveFont(Font.BOLD, 18));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBackground(Color.WHITE);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.EAST; // Căn lề trái trong lưới
        mainP.add(textField, gbc);
        return textField;
    }
    public static void main(String[] args) {
        // Tạo cửa sổ JFrame và thiết lập các thuộc tính cơ bản
        JFrame frame = new JFrame("Đổi Mật Khẩu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null); // Đặt vị trí ở giữa màn hình

        // Tạo một đối tượng của DoiMK và thêm nó vào JFrame
        DoiMK doiMKPanel = new DoiMK(850, 670);
        frame.add(doiMKPanel);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
