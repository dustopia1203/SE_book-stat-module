package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookDetailFrm extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JButton btnBack;
    private JTable tblBorrowing;

    public BookDetailFrm() {
        setTitle("BookDetailFrm");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);

        tblBorrowing.setModel(new DefaultTableModel(null, new String[]{"Ngày", "Tên độc giả", "Ngày trả", "Tiền phạt"}));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
