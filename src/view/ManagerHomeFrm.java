package view;

import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerHomeFrm extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton btnStat;
    private JButton btnManage;
    private JButton btnLogOut;
    private JLabel lblFullName;
    private User user;

    public ManagerHomeFrm(User user) {
        this.user = user;
        setTitle("StatFrm");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        btnStat.setFocusable(false);
        btnStat.addActionListener(this);
        btnManage.setFocusable(false);
        btnManage.addActionListener(this);
        btnLogOut.setFocusable(false);
        btnLogOut.addActionListener(this);
        lblFullName.setText("Trang chủ người dùng " + user.getName());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStat) {
            new StatFrm();
        } else if (e.getSource() == btnLogOut) {
            new LoginFrm();
            this.dispose();
        }
    }
}
