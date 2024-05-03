package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStatFrm extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JTextField txtSD;
    private JTextField txtED;
    private JPanel subPanel;
    private JButton btnConfirm;
    private JButton btnHome;
    private JButton btnCancel;
    private JTable tblBorrowedBook;
    private JLabel lblSD;
    private JLabel lblED;

    public BookStatFrm() {
        setTitle("BookStatFrm");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);

        tblBorrowedBook.setModel(new DefaultTableModel(null, new String[]{"Mã", "Tên sách", "Tác giả", "Lượt mượn"}));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
