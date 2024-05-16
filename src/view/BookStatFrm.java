package view;

import dao.BookStatDAO;
import model.BookStat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

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
    private DefaultTableModel tblModel = new DefaultTableModel(null, new String[]{"Mã", "Tên sách", "Tác giả", "Lượt mượn", "Doanh thu"});
    private ArrayList<BookStat> bookStats;

    public BookStatFrm() {
        setTitle("BookStatFrm");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        tblBorrowedBook.setModel(tblModel);
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(this);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(this);
        tblBorrowedBook.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    if (row != -1) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            new BookDetailFrm(bookStats.get(row), formatter.parse(txtSD.getText()), formatter.parse(txtED.getText()));
                        } catch (ParseException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date sd = formatter.parse(txtSD.getText());
                Date ed = formatter.parse(txtED.getText());
                BookStatDAO bookStatDAO = new BookStatDAO();
                bookStats = bookStatDAO.getBookStat(sd, ed);
                tblModel.setRowCount(0);
                if (!bookStats.isEmpty()) {
                    for (BookStat bookStat : bookStats) {
                        int id = bookStat.getId();
                        String name = bookStat.getName();
                        String author = bookStat.getAuthor();
                        int totalBorrowing = bookStat.getTotalBorrowing();
                        float venue = bookStat.getTotalRevenue();
                        tblModel.addRow(new Object[]{id, name, author, totalBorrowing, venue});
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Không có kết quả!");
                }
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
