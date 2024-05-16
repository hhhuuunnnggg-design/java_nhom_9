package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BUS.ChangeAcc_BUS;
import DTO.Account_DTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vhuyn
 */
public final class ChangeAccount extends JPanel implements MouseListener, ActionListener {
    JLabel lbl1, lblTK, lblMK, lblRMK;
    JButton btnFinish;
    JTextField textTK, textMK, textRMK;
    JCheckBox checkHS, checkGV;
    ButtonGroup group;
    JPanel pHead, pContent, pFooter;
    int width, height;

    ChangeAcc_BUS accBus = new ChangeAcc_BUS();

    public ChangeAccount(int width, int height) {
        this.width = width;
        this.height = height;
        init();
        btnFinish.addActionListener(this);
        btnFinish.addMouseListener(this);
        checkHS.addMouseListener(this);
        checkGV.addMouseListener(this);
    }

    public void init() {
        Color color = new Color(180, 204, 227);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(width, height));
        group = new ButtonGroup();

        lbl1 = new JLabel("Chọn loại tài khoản muốn thay đổi: ");
        lbl1.setFont(new Font("arial", Font.BOLD, 16));
        lbl1.setBackground(color);
        lbl1.setOpaque(true);

        checkHS = new JCheckBox("Học sinh");
        checkHS.setBackground(color);

        checkGV = new JCheckBox("Giáo viên");
        checkGV.setBackground(color);

        group.add(checkHS);
        group.add(checkGV);

        lblTK = new JLabel("Nhập mã tài khoản: ");
        lblTK.setHorizontalAlignment(SwingConstants.RIGHT);
        textTK = new JTextField();
        textTK.setFont(new Font("Arial", Font.BOLD, 12));

        lblMK = new JLabel("Nhập mật khẩu mới: ");
        lblMK.setHorizontalAlignment(SwingConstants.RIGHT);
        textMK = new JTextField();
        textMK.setFont(new Font("Arial", Font.BOLD, 12));

        lblRMK = new JLabel("Xác nhận lại mật khẩu mới: ");
        lblRMK.setHorizontalAlignment(SwingConstants.RIGHT);
        textRMK = new JTextField();
        textRMK.setFont(new Font("Arial", Font.BOLD, 12));

        lblTK.setFont(new Font("arial", Font.BOLD, 14));
        lblMK.setFont(new Font("arial", Font.BOLD, 14));
        lblRMK.setFont(new Font("arial", Font.BOLD, 14));

        lblTK.setBounds(230, 120, 200, 20);
        textTK.setBounds(440, 120, 150, 20);
        lblMK.setBounds(230, 170, 200, 20);
        textMK.setBounds(440, 170, 150, 20);
        lblRMK.setBounds(230, 230, 200, 20);
        textRMK.setBounds(440, 230, 150, 20);

        btnFinish = new JButton("Hoàn tất");

        pHead = new JPanel();
        pContent = new JPanel();
        pFooter = new JPanel();
        pHead.setPreferredSize(new Dimension(0, 100));
        pHead.setBackground(Color.GRAY);
        pContent.setPreferredSize(new Dimension(0, 0));
        pContent.setBackground(color);
        pFooter.setPreferredSize(new Dimension(0, 100));
        pFooter.setBackground(Color.GRAY);

        pContent.setLayout(null);
        lbl1.setBounds(30, 30, 300, 40);
        checkHS.setBounds(360, 37, 100, 27);
        checkGV.setBounds(480, 37, 100, 27);
        pContent.add(lbl1);
        pContent.add(checkHS);
        pContent.add(checkGV);

        pContent.add(lblTK);
        pContent.add(textTK);
        pContent.add(lblMK);
        pContent.add(textMK);
        pContent.add(lblRMK);
        pContent.add(textRMK);
        pContent.add(btnFinish);

        btnFinish.setBounds(380, 330, 100, 30);
        btnFinish.setOpaque(true);

        this.add(pHead, BorderLayout.NORTH);
        this.add(pContent, BorderLayout.CENTER);
        this.add(pFooter, BorderLayout.SOUTH);
    }

    public boolean areFieldsEmpty() {
        return textTK.getText().isEmpty() || textMK.getText().isEmpty() || textRMK.getText().isEmpty();
    }

    public boolean arePasswordsMatching() {
        String password = textMK.getText();
        String confirmPassword = textRMK.getText();
        return password.equals(confirmPassword);
    }

    public void ChangePassword() {
        String username = textTK.getText();
        String password = textMK.getText();
        Account_DTO acc = new Account_DTO(username, password);
        accBus.updateACC(acc);
    }

    public boolean checkUsernameExits() {
        String username = textTK.getText();
        return accBus.KtraUsername(username);
    }

    public void clearTextFields() {
        textTK.setText("");
        textMK.setText("");
        textRMK.setText("");
    }

    // public static void main(String[] args) {
    //     ChangeAccount change = new ChangeAccount(850, 670);
    //     change.setVisible(true);
    // }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == checkHS) {
            textTK.setText("HS");
        } else if (e.getSource() == checkGV) {
            textTK.setText("GV");
        }

        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated
        // from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFinish) {

            if (areFieldsEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!arePasswordsMatching()) {
                JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!checkUsernameExits()) {
                JOptionPane.showMessageDialog(this, "Username không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int result = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc sửa mật khẩu này không này",
                    "Tài khoản",
                    JOptionPane.YES_NO_OPTION,

                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this,
                        "Sửa thành công",
                        "Chức năng thêm",
                        JOptionPane.INFORMATION_MESSAGE);
                ChangePassword();
                clearTextFields();
            }
        }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
    }

}
