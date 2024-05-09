package view;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginFrm extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton btnLogin;
    private JButton btnForgetPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblUsername;
    private JLabel lblPassword;

    public LoginFrm() {
        setTitle("LoginFrm");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        btnLogin.setFocusable(false);
        btnLogin.addActionListener(this);
        btnForgetPassword.setFocusable(false);
        btnForgetPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLogin)) {
            User user = new User();
            user.setUsername(txtUsername.getText());
            user.setPassword(String.valueOf(txtPassword.getPassword()));
            UserDAO userDAO = new UserDAO();
            if (userDAO.checkLogin(user)) {
                if (user.getRole().equals("manager")) {
                    new ManagerHomeFrm(user);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
            }
        }
    }
}
