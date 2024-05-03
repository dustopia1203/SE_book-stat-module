package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerHomeFrm extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton btnStat;
    private JButton btnManage;
    private JButton btnLogOut;
    private JLabel lblFullName;

    public ManagerHomeFrm() {
        setTitle("StatFrm");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
