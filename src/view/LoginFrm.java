package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        btnForgetPassword.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
