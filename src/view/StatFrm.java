package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatFrm extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton btnFinaceStat;
    private JButton btnBorrowedBookStat;
    private JButton btnReaderBorrowStat;
    private JButton btnCancel;

    public StatFrm() {
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
