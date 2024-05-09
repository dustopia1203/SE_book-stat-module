package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookStatFrm extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JTextField txtSD;
    private JTextField txtED;
    private JPanel subPanel;
    private JButton btnConfirm;
    private JButton btnCancel;
    private JTable tblBorrowedBook;
    private JLabel lblSD;
    private JLabel lblED;

    public BookStatFrm() {
        setTitle("BookStatFrm");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        DefaultTableModel tblModel = new DefaultTableModel(null, new String[]{"Mã", "Tên sách", "Tác giả", "Lượt mượn"});
        tblBorrowedBook.setModel(tblModel);
        tblModel.addRow(new Object[]{"id", "book", "author", "loan"});
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(this);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date sd = formatter.parse(txtSD.getText());
                Date ed = formatter.parse(txtED.getText());
                System.out.println(sd + " " + ed);
            } catch (Exception exception) {
                if (exception instanceof ParseException) JOptionPane.showMessageDialog(this, "Invalid date!");
                else JOptionPane.showMessageDialog(this, "Error occured: " + exception.getMessage());
            }
        } else if (e.getSource() == btnCancel) {
            new StatFrm();
            this.dispose();
        }
    }
}
