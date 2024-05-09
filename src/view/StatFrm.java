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
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        btnBorrowedBookStat.setFocusable(false);
        btnBorrowedBookStat.addActionListener(this);
        btnFinaceStat.setFocusable(false);
        btnFinaceStat.addActionListener(this);
        btnReaderBorrowStat.setFocusable(false);
        btnReaderBorrowStat.addActionListener(this);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBorrowedBookStat) {
            new BookStatFrm();
            this.dispose();
        }
        else if (e.getSource() == btnCancel) {
            this.dispose();
        }
    }
}
